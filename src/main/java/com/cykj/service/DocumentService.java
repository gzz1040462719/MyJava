package com.cykj.service;

import com.cykj.bean.Document;
import com.cykj.bean.DocumentTypes;
import com.cykj.bean.LayuiReplay;

import java.util.HashMap;
import java.util.List;

public interface DocumentService {


    //条件查询所有文档
    LayuiReplay<Document> conditionFindAll(HashMap<String, Object> condition, int curPage, int pageSize);

    //修改文档
    public int updateDocument(Document document);

    //所有文档类型
    public List<DocumentTypes> documentTypesFindAll();

    //修改文档类型积分
    public int updateDocumentTypes(List<DocumentTypes> documentTypesList);
}
