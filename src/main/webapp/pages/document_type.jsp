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
    <title>文档配置</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.5.1.js" type="text/javascript" charset="UTF-8"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css" media="all">
    <script src="${pageContext.request.contextPath}/layui/layui.js" charset="utf-8"></script>
    <script src="${pageContext.request.contextPath}/js/user/document_type.js" type="text/javascript" charset="UTF-8"></script>

</head>
<style>
    .layui-form-checkbox span {
        width: 70px;
    }
</style>
<body>

<input id="path" type="hidden" value="${pageContext.request.contextPath}">



<form class="layui-form layui-col-md-offset3" id="myForm">
    <br>
    <br>
    <br>
    <br>
    <label class="layui-form-block">请选择文档类型</label>
<%--    <div class="layui-form-item">--%>
<%--        <div class="layui-input-block">--%>
<%--            <input type="checkbox" name="like[write]" title=".doc/.docx">--%>
<%--            <input type="checkbox" name="like[read]" title=".xls/.xlsx" checked="">--%>
<%--            <input type="checkbox" name="like[game]" title=".ppt/.pptx">--%>
<%--        </div>--%>
<%--        <div class="layui-input-block">--%>
<%--            <input type="checkbox" name="like[write]" title=".jpg">--%>
<%--            <input type="checkbox" name="like[read]" title=".txt" checked="">--%>
<%--            <input type="checkbox" name="like[game]" title=".png">--%>
<%--        </div>--%>
<%--        <div class="layui-input-block">--%>
<%--            <input type="checkbox" name="like[write]" title=".war">--%>
<%--            <input type="checkbox" name="like[read]" title=".zip" checked="">--%>
<%--            <input type="checkbox" name="like[game]" title=".7z">--%>
<%--        </div>--%>
<%--        <div class="layui-input-block">--%>
<%--            <input type="checkbox" name="like[write]" title=".java">--%>
<%--            <input type="checkbox" name="like[read]" title=".class" checked="">--%>
<%--        </div>--%>
<%--    </div>--%>

<%--    <div class="layui-form-item">--%>
<%--        <div class="layui-input-block">--%>
<%--            <button class="layui-btn" lay-submit lay-filter="formDemo">提交</button>--%>
<%--        </div>--%>
<%--    </div>--%>
</form>
</body>
<%--<script>--%>
<%--    //Demo--%>
<%--    layui.use('form', function(){--%>
<%--        var form = layui.form;--%>
<%--        form.--%>
<%--        //监听提交--%>
<%--        form.on('submit(formDemo)', function(data){--%>
<%--            layer.msg(JSON.stringify(data.field));--%>
<%--            return false;--%>
<%--        });--%>
<%--    });--%>
<%--</script>--%>
</html>
