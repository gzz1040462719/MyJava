package com.cykj.dao.impl;

import com.cykj.bean.Document;
import com.cykj.bean.DocumentTypes;
import com.cykj.bean.User;
import com.cykj.dao.DocumentDao;
import com.cykj.mapper.DocumentMapper;
import com.cykj.mapper.UserMapper;
import com.cykj.myuitl.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;

public class DocumentDaoimpl implements DocumentDao {

    //条件查询所有文档
    @Override
    public List<Document> conditionFindAll(HashMap<String, Object> condition, int curPage, int pageSize) {
        SqlSession session = MybatisUtil.getInstance().getSession();
        DocumentMapper mapper = session.getMapper(DocumentMapper.class);
        condition.put("startPage",(curPage - 1) * pageSize);
        condition.put("endPage",(curPage *pageSize));
        System.out.println("开始"+(curPage - 1) * pageSize);
        System.out.println("结束"+(curPage *pageSize));
        List<Document> all = mapper.conditionFindAll(condition);
        MybatisUtil.getInstance().close(session);
        return all;
    }

    //条件查询所有文档总数
    @Override
    public int total(HashMap<String, Object> condition) {
        SqlSession session = MybatisUtil.getInstance().getSession();
        DocumentMapper mapper = session.getMapper(DocumentMapper.class);
        int total = mapper.total(condition);
        MybatisUtil.getInstance().close(session);
        return total;
    }

    //修改文档
    @Override
    public int updateDocument(Document document) {
        SqlSession session = MybatisUtil.getInstance().getSession();
        DocumentMapper mapper = session.getMapper(DocumentMapper.class);
        int i = mapper.updateDocument(document);
        MybatisUtil.getInstance().close(session);
        return i;
    }

    //所有文档类型
    @Override
    public List<DocumentTypes> documentTypesFindAll() {
        SqlSession session = MybatisUtil.getInstance().getSession();
        DocumentMapper mapper = session.getMapper(DocumentMapper.class);
        List<DocumentTypes> documentTypes = mapper.documentTypesFindAll();
        MybatisUtil.getInstance().close(session);
        return documentTypes;
    }

    //修改文档类型积分
    @Override
    public int updateDocumentTypes(List<DocumentTypes> documentTypesList) {
        SqlSession session = MybatisUtil.getInstance().getSession();
        DocumentMapper mapper = session.getMapper(DocumentMapper.class);
        int i = mapper.updateDocumentTypes(documentTypesList);
        MybatisUtil.getInstance().close(session);
        return i;
    }
}
