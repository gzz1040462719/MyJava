package com.cykj.bean;

import java.math.BigDecimal;

//文档类型
public class DocumentTypes {

    private BigDecimal documentTypesId;
    private String documentTypesName;//类型名称
    private BigDecimal documentTypesScore;//积分
    private BigDecimal documentTypesState;//状态


    public DocumentTypes() {
    }

    public BigDecimal getDocumentTypesState() {
        return documentTypesState;
    }

    public void setDocumentTypesState(BigDecimal documentTypesState) {
        this.documentTypesState = documentTypesState;
    }

    public BigDecimal getDocumentTypesId() {
        return documentTypesId;
    }

    public void setDocumentTypesId(BigDecimal documentTypesId) {
        this.documentTypesId = documentTypesId;
    }

    public String getDocumentTypesName() {
        return documentTypesName;
    }

    public void setDocumentTypesName(String documentTypesName) {
        this.documentTypesName = documentTypesName;
    }

    public BigDecimal getDocumentTypesScore() {
        return documentTypesScore;
    }

    public void setDocumentTypesScore(BigDecimal documentTypesScore) {
        this.documentTypesScore = documentTypesScore;
    }
}
