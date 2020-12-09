<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/12/2
  Time: 10:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <meta charset="utf-8">
    <title>用户管理</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css" media="all">
    <script src="${pageContext.request.contextPath}/layui/layui.js" charset="utf-8"></script>
    <script src="${pageContext.request.contextPath}/js/jquery-3.5.1.js" type="text/javascript" charset="UTF-8"></script>
    <script src="${pageContext.request.contextPath}/js/user/user_list.js" type="text/javascript" charset="UTF-8"></script>

</head>
<body>

<input id="path" type="hidden" value="${pageContext.request.contextPath}">
<div class="demoTable layui-col-md-offset3">
    注册时间：
    <div class="layui-inline">
        <input class="layui-input" name="id" id="stateTime" placeholder="选择时间">
    </div>
    至：
    <div class="layui-inline">
        <input class="layui-input" name="id" id="entTime" placeholder="选择时间">
    </div>
</div>

<hr>
<div class="demoTable layui-col-md-offset3">
    用户名：
    <div class="layui-inline">
        <input class="layui-input" id="userName" autocomplete="off">
    </div>
    <div class="layui-inline">
        <button class="layui-btn" data-type="reload">搜索</button>
    </div>
</div>

<script type="text/html" id="barDemo">
    {{#  if(d.userState ==1){ }}
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="forbid">禁用</a>
    {{#  } else if(d.userState ==2){ }}
    <a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="start">启用</a>
    {{#  } else{ }}
    {{#  } }}
</script>
    <table class="layui-hide" id="LAY_table_user" lay-filter="user"></table>
</body>
</html>