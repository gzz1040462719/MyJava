package com.cykj.service.impl;

import com.cykj.bean.Document;
import com.cykj.bean.DocumentTypes;
import com.cykj.bean.LayuiReplay;
import com.cykj.bean.User;
import com.cykj.dao.DocumentDao;
import com.cykj.dao.UserDao;
import com.cykj.dao.impl.DocumentDaoimpl;
import com.cykj.dao.impl.UserDaoimpl;
import com.cykj.myuitl.ObjectFactory;
import com.cykj.service.DocumentService;

import java.util.HashMap;
import java.util.List;

public class DocumentServiceimpl implements DocumentService {

    DocumentDao documentDao = (DocumentDao) ObjectFactory.newInstance(DocumentDaoimpl.class);
    @Override
    public LayuiReplay<Document> conditionFindAll(HashMap<String, Object> condition, int curPage, int pageSize) {

        List<Document> list = documentDao.conditionFindAll(condition, curPage, pageSize);
        int i = documentDao.total(condition);
        String msg="";
        if (i>0){
            msg="查询成功";
        }else {
            msg="暂无数据";
        }
        LayuiReplay<Document> layuiReplay = new LayuiReplay<>(0, msg, i, list);
        return layuiReplay;
    }
    //修改文档
    @Override
    public int updateDocument(Document document) {
        return documentDao.updateDocument(document);
    }

    //所有文档类型
    @Override
    public List<DocumentTypes> documentTypesFindAll() {
        return documentDao.documentTypesFindAll();
    }

    @Override
    public int updateDocumentTypes(List<DocumentTypes> documentTypesList) {
        return documentDao.updateDocumentTypes(documentTypesList);
    }
}
