package com.cykj.bean;

import com.cykj.myuitl.MyTool;

import java.math.BigDecimal;
import java.util.Date;

//文档表
public class Document {
    private BigDecimal documentId;
    private String documentName;//文档名称
    private BigDecimal documentType;//文档类型
    private BigDecimal userId;//上传人id
    private BigDecimal documentState;//文档状态
    private String documentUrl;//文档路径
    private Date startTime;//上传时间
    private String startTimeName;//上传时间String

    private User user;//上传用户
    private Parameter parameter;//状态参数表
    private DocumentTypes documentTypes;//文档类型

    public Document() {
    }

    public BigDecimal getDocumentId() {
        return documentId;
    }

    public void setDocumentId(BigDecimal documentId) {
        this.documentId = documentId;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public BigDecimal getDocumentType() {
        return documentType;
    }

    public void setDocumentType(BigDecimal documentType) {
        this.documentType = documentType;
    }

    public BigDecimal getUserId() {
        return userId;
    }

    public void setUserId(BigDecimal userId) {
        this.userId = userId;
    }

    public BigDecimal getDocumentState() {
        return documentState;
    }

    public void setDocumentState(BigDecimal documentState) {
        this.documentState = documentState;
    }

    public String getDocumentUrl() {
        return documentUrl;
    }

    public void setDocumentUrl(String documentUrl) {
        this.documentUrl = documentUrl;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        setStartTimeName(MyTool.getDateString(startTime));
        this.startTime = startTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Parameter getParameter() {
        return parameter;
    }

    public void setParameter(Parameter parameter) {
        this.parameter = parameter;
    }

    public DocumentTypes getDocumentTypes() {
        return documentTypes;
    }

    public void setDocumentTypes(DocumentTypes documentTypes) {
        this.documentTypes = documentTypes;
    }

    public String getStartTimeName() {
        return startTimeName;
    }

    public void setStartTimeName(String startTimeName) {
        this.startTimeName = startTimeName;
    }

    @Override
    public String toString() {
        return "DocumentDao{" +
                "documentId=" + documentId +
                ", documentName='" + documentName + '\'' +
                ", documentType=" + documentType +
                ", userId=" + userId +
                ", documentState=" + documentState +
                ", documentUrl='" + documentUrl + '\'' +
                ", startTime=" + startTime +
                ", user=" + user +
                ", parameter=" + parameter +
                ", documentTypes=" + documentTypes +
                '}';
    }
}
