<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/12/4
  Time: 9:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>我要上传</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.5.1.js" type="text/javascript" charset="UTF-8"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css" media="all">
    <script src="${pageContext.request.contextPath}/layui/layui.js" charset="utf-8"></script>
    <script src="${pageContext.request.contextPath}/js/user/uploading.js" type="text/javascript" charset="UTF-8"></script>

</head>
<body>

<input id="path" type="hidden" value="${pageContext.request.contextPath}">


<form class="layui-form layui-col-md-offset3" >
    <br>
    <br>
    <div class="layui-form-item">
        <label class="layui-form-label">文档标题:</label>
        <div class="layui-input-inline">
            <input type="text" name="title" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">文档简介:</label>
        <div class="layui-input-inline">
            <textarea name="desc" placeholder="请输入内容" class="layui-textarea"></textarea>
        </div>
    </div>

    <div class="layui-upload">
        <label class="layui-form-label">上传文档:</label>
        <button type="button" class="layui-btn layui-btn-normal" id="test8">选择文件</button>
    </div>
    <br>
    <div class="layui-form-item">
        <label class="layui-form-label">下载积分:</label>
        <div class="layui-input-inline">
            <input type="text" name="title" required  lay-verify="required"  autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-input-block">
            <button id="uploadingBtn" class="layui-btn" lay-submit lay-filter="formDemo">上传</button>
            <button type="reset" class="layui-btn layui-btn-primary">返回</button>
        </div>
    </div>
</form>
</body>

<script>
    //Demo

</script>

</html>
