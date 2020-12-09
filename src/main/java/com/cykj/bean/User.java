package com.cykj.bean;

import com.cykj.myuitl.MyTool;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class User {
    private BigDecimal userId;
    private String userAccount;
    private String userPassword;
    private String userName;
    private String email;//邮箱
    private String mobile;//手机号
    private String sex;//性别
    private String idNumber;//身份证
    private Date registerTime;//注册时间
    private String registerTimeName;//注册时间名
    private BigDecimal score;//积分
    private BigDecimal userState;//状态
    private String userStateName;//状态名
    private BigDecimal uploadingNumber;//上传数量
    private BigDecimal downloadNumber;//下载数量
    private BigDecimal role;//角色

    private List<Document> documentList;

    public User() {
    }
    public BigDecimal getUserId() {
        return userId;
    }

    public void setUserId(BigDecimal userId) {
        this.userId = userId;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        //格式转换
        if (registerTime!=null){
            setRegisterTimeName(MyTool.getDateString(registerTime));
        }

        this.registerTime = registerTime;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    public BigDecimal getUserState() {
        return userState;
    }

    public void setUserState(BigDecimal userState) {
        this.userState = userState;
    }

    public String getUserStateName() {
        return userStateName;
    }

    public void setUserStateName(String userStateName) {
        this.userStateName = userStateName;
    }

    public BigDecimal getUploadingNumber() {
        return uploadingNumber;
    }

    public void setUploadingNumber(BigDecimal uploadingNumber) {
        this.uploadingNumber = uploadingNumber;
    }

    public BigDecimal getDownloadNumber() {
        return downloadNumber;
    }

    public void setDownloadNumber(BigDecimal downloadNumber) {
        this.downloadNumber = downloadNumber;
    }

    public String getRegisterTimeName() {
        return registerTimeName;
    }
    public void setRegisterTimeName(String registerTimeName) {
        this.registerTimeName = registerTimeName;
    }

    public List<Document> getDocumentList() {
        return documentList;
    }

    public void setDocumentList(List<Document> documentList) {
        this.documentList = documentList;
    }

    public BigDecimal getRole() {
        return role;
    }

    public void setRole(BigDecimal role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userAccount='" + userAccount + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", sex='" + sex + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", registerTime=" + registerTime +
                ", registerTimeName='" + registerTimeName + '\'' +
                ", score=" + score +
                ", userState=" + userState +
                ", userStateName='" + userStateName + '\'' +
                ", uploadingNumber=" + uploadingNumber +
                ", downloadNumber=" + downloadNumber +
                ", documentList=" + documentList +
                '}';
    }
}
