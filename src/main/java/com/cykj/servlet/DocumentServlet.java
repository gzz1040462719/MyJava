package com.cykj.servlet;

import com.cykj.bean.Document;
import com.cykj.bean.DocumentTypes;
import com.cykj.bean.LayuiReplay;
import com.cykj.dao.UserDao;
import com.cykj.dao.impl.UserDaoimpl;
import com.cykj.myuitl.MyTool;
import com.cykj.myuitl.ObjectFactory;
import com.cykj.service.DocumentService;
import com.cykj.service.impl.DocumentServiceimpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@WebServlet("/DocumentServlet")
public class DocumentServlet extends BaseServlet {

    DocumentService documentService = (DocumentService) ObjectFactory.newInstance(DocumentServiceimpl.class);

    //文档审核列表
    public void conditionFindAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int count = 0;//总条数
        int currentPage = 1;//当前页数
        int size = 5;//每页显示条数
        String page = req.getParameter("page");//当选择了分页之后，会自动加上page和limit的上传参数
        String limit = req.getParameter("limit");//page表示当前页，limit表示每页显示条数
        System.out.println("页数："+limit);
        if (page != null && !"".equals(page)) {
            currentPage = Integer.parseInt(page);
        }
        if (limit != null && !"".equals(limit)) {
            size = Integer.parseInt(limit);
        }
//        查询条件
        HashMap<String, Object> map = new HashMap<>();
        String stateTime = req.getParameter("stateTime");
        String entTime = req.getParameter("entTime");
        String userName = req.getParameter("userName");
        String documentName = req.getParameter("documentName");
        String documentType = req.getParameter("documentType");

        if (MyTool.isNotNull(stateTime)) {
            map.put("stateTime", stateTime);
            req.setAttribute("stateTime", stateTime);
        }
        if (MyTool.isNotNull(entTime)) {
            map.put("entTime", entTime);
            req.setAttribute("entTime", entTime);
        }
        if (MyTool.isNotNull(userName)) {
            map.put("userName", userName);
            req.setAttribute("userName", userName);
            System.out.println("进入名");
        }
        if (MyTool.isNotNull(documentName)) {
            map.put("documentName", documentName);
            req.setAttribute("documentName", documentName);
        }
        if (MyTool.isNotNull(documentType)) {
            map.put("documentType", new BigDecimal(documentType));
            req.setAttribute("documentType", documentType);
        }
//        map.put("documentState",new BigDecimal(3));
        LayuiReplay<Document> documentLayuiReplay = documentService.conditionFindAll(map, currentPage, size);
        resp.getWriter().write(documentLayuiReplay.toJson());
    }

      //初始化下拉框
//    public void initPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
//        List<DocumentTypes> documentTypes = documentService.documentTypesFindAll();
//        Gson gson=new Gson();
//        String select = gson.toJson(documentTypes);
//        resp.getWriter().write(select);
//    }


    //文档审核请求
    public  void checkDocument(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String documentId = req.getParameter("documentId");
        String documentState = req.getParameter("documentState");

        Document document = new Document();
        document.setDocumentId(new BigDecimal(documentId));
        document.setDocumentState(new BigDecimal(documentState));
        int i = documentService.updateDocument(document);
        if (i>0){
            resp.getWriter().write("修改成功");
        }else {
            resp.getWriter().write("修改失败");
        }
    }

    //修改文档类型
//    public void updateDocumentTypes(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
//        String list = req.getParameter("list");
//        Gson gson=new Gson();
//        List<DocumentTypes> documentTypes= gson.fromJson(list, new TypeToken<List<DocumentTypes>>() {}.getType());
//        int i = documentService.updateDocumentTypes(documentTypes);
//        if (i>0){
//            resp.getWriter().write("修改成功");
//        }else {
//            resp.getWriter().write("修改失败");
//        }
//    }

}
