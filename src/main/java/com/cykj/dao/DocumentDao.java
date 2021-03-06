package com.cykj.dao;

import com.cykj.bean.Document;
import com.cykj.bean.DocumentTypes;
import com.cykj.bean.User;

import java.util.HashMap;
import java.util.List;

public interface DocumentDao {


    //条件查询所有文档
    List<Document> conditionFindAll(HashMap<String, Object> condition, int curPage, int pageSize);

    //条件查询所有文档总数
    public int total(HashMap<String, Object> condition);

    //修改文档
    public int updateDocument(Document document);

    //所有文档类型
    public List<DocumentTypes> documentTypesFindAll();

    //修改文档类型积分
    public int updateDocumentTypes(List<DocumentTypes> documentTypesList);


}
