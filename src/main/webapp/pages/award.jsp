<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/12/4
  Time: 10:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>奖励配置</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.5.1.js" type="text/javascript" charset="UTF-8"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css" media="all">
    <script src="${pageContext.request.contextPath}/layui/layui.js" charset="utf-8"></script>
    <script src="${pageContext.request.contextPath}/js/user/award.js" type="text/javascript"
            charset="UTF-8"></script>

</head>
<style>
    .layui-form-label{
        font-size: 20px;
    }
</style>
<body>

<input id="path" type="hidden" value="${pageContext.request.contextPath}">

<form class="layui-form layui-col-md-offset4" id="myForm" >
    <br>
    <label style="font-size: 30px">当前文档积分奖励:</label>
    <br>
    <br>
    <br>
</form>
</body>
</html>
