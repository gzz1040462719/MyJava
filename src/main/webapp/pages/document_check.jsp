<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/12/3
  Time: 22:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <meta charset="utf-8">
    <title>文档审核</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css" media="all">
    <script src="${pageContext.request.contextPath}/layui/layui.js" charset="utf-8"></script>
    <script src="${pageContext.request.contextPath}/js/jquery-3.5.1.js" type="text/javascript" charset="UTF-8"></script>
    <script src="${pageContext.request.contextPath}/js/user/document_check.js" type="text/javascript"
            charset="UTF-8"></script>

</head>
<body>
<input id="path" type="hidden" value="${pageContext.request.contextPath}">
<form class="layui-form">

    <div class="demoTable layui-col-md-offset1">
        文档标题：
        <div class="layui-inline">
            <input class="layui-input" id="documentName" autocomplete="off">
        </div>
        上传人：
        <div class="layui-inline">
            <input class="layui-input" id="userName" autocomplete="off">
        </div>

        <div class="layui-inline">
            <label class="layui-form-label">文档类型</label>
            <div class="layui-input-inline">
                <select name="quiz" id="documentType">
                    <option value="">暂无选择</option>
                </select>
            </div>
        </div>
    </div>
    </div>
</form>
<hr>

<div class="demoTable layui-col-md-offset1">
    上传时间：
    <div class="layui-inline">
        <input class="layui-input" name="id" id="stateTime" placeholder="选择时间">
    </div>
    至：
    <div class="layui-inline">
        <input class="layui-input" name="id" id="entTime" placeholder="选择时间">
    </div>
    <div class="layui-inline layui-col-md-offset3">
        <button class="layui-btn" data-type="reload">搜索</button>
    </div>
</div>




<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="download">下载</a>
    {{#  if(d.documentState ==3){ }}
    <a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="win">审核通过</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="defeated">审核不通过</a>
    {{#  } else{ }}
    {{#  } }}


</script>
<table class="layui-hide" id="LAY_table_user" lay-filter="user"></table>
</body>

<script>

</script>


</html>
