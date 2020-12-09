package com.cykj.servlet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

//上传文件
@WebServlet("/FileUpServlet")
public class FileUpServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println("进入");
//        String parameter = request.getParameter("Content-Disposition");
//        String name = request.getParameter("name");
//        String filename = request.getParameter("filename");
//        String type = request.getParameter("Content-type");
//        // 使用FileItem工场类创建相应工场对象
//        FileItemFactory factory = new DiskFileItemFactory();
//        // 创建servlet文件上传对象并将指定工场对象传入
//        ServletFileUpload fileUpload = new ServletFileUpload(factory);
//        // 声明文件集合
//        List<FileItem> parseRequest = null;
//        List<String> src = new ArrayList<>();
//        try {
//            // 使用servlet文件上传对象解析请求返回文件集合
//            parseRequest = fileUpload.parseRequest(request);
//            // 遍历文件对象集合 获取数据
//            for (FileItem fileItem : parseRequest) {
//                // 判断数据类型是不是普通的form表单字段
//                if (!fileItem.isFormField()) {
//                    // 获取上传文件的文件名
//                    String fileName = fileItem.getName();
//
//                    // 使用上传文件创建输入流
//                    InputStream fileStream = fileItem.getInputStream();
//                    // 使用UUID+文件名的方式生成保存文件的名称，避免文件重名
//                    String realFileName = UUID.randomUUID().toString() + "-" + fileName;
//                    // 定义保存的父路径
//
//                    File fileFatherPath = new File("F:\\MyJavaDemo\\src\\main\\webapp\\Files");
//                    System.out.println(fileFatherPath.exists());
//                    if (!fileFatherPath.exists()){
//                        // 创建父路径 避免路径不存在保错
//                        fileFatherPath.mkdirs();
//                    }
//                    System.out.println(fileFatherPath);
//                    //保存路径src
//                    src.add("F:\\MyJavaDemo\\src\\main\\webapp\\Files"+realFileName);
//                    // 创建要保存的文件
//                    File file = new File(fileFatherPath, realFileName);
//                    // 创建输出流
//                    OutputStream out = new FileOutputStream(file);
//                    // 创建字节缓存
//                    byte[] buffer = new byte[1024];
//                    int len = -1;
//                    // 一次读取1kb(1024byte),返回-1表明读取完毕
//                    while ((len = fileStream.read(buffer)) != -1) {
//                        // 一次写入1kb(1024byte)
//                        out.write(buffer, 0, len);
//                    }
//                    // 冲刷流资源
//                    out.flush();
//                    // 关闭流
//                    out.close();
//                    fileStream.close();
//                    System.out.println("结束");
//                    System.out.println("files/"+realFileName);
//                    response.getWriter().write("上传成功！");
//                }
//            }
////            LayuiJson layuiJson = new LayuiJson(0,src);
////            response.getWriter().write(gson.toJson(layuiJson));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }

    public String getPath(){
        String pathWebroot = this.getClass().getResource("/").toString();
        pathWebroot = pathWebroot + "esXml/";
        String path = pathWebroot.substring(5);
        return path;
    }


}
