<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/12/3
  Time: 21:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css" media="all">
</head>
<body>

<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
    <legend>基本演示</legend>
</fieldset>
<div class="layui-btn-container">
    <button type="button" class="layui-btn layui-btn-sm" lay-demo="getChecked">获取选中节点数据</button>
    <button type="button" class="layui-btn layui-btn-sm" lay-demo="setChecked">勾选指定节点</button>
    <button type="button" class="layui-btn layui-btn-sm" lay-demo="reload">重载实例</button>
</div>

<div id="test12" class="demo-tree-more"></div>
<div id="test1" class="demo-transfer"></div>
<script src="${pageContext.request.contextPath}/layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
    layui.use(['tree', 'util','transfer', 'layer'], function () {
        var tree = layui.tree
            , layer = layui.layer
            , util = layui.util
            ,$ = layui.$
            ,transfer = layui.transfer
            //模拟数据
            , data = [{
                title: '一级1'
                , id: 1
                , field: 'name1'
                , checked: true
                , spread: true
                , children: [{
                    title: '二级1-1 可允许跳转'
                    , id: 3
                    , field: 'name11'
                        , children: [{
                            title: '五级1-1-3-1-2'
                            , id: 31
                            , field: ''
                    }]
                }, {
                    title: '二级1-2'
                    , id: 4
                    , spread: true
                    , children: [{
                        title: '三级1-2-1'
                        , id: 9
                        , field: ''
                        , disabled: true
                    }, {
                        title: '三级1-2-2'
                        , id: 10
                        , field: ''
                    }]
                }, {
                    title: '二级1-3'
                    , id: 20
                    , field: ''
                    , children: [{
                        title: '三级1-3-1'
                        , id: 21
                        , field: ''
                    }, {
                        title: '三级1-3-2'
                        , id: 22
                        , field: ''
                    }]
                }]
            }, {
                title: '一级2'
                , id: 2
                , field: ''
                , spread: true
                , children: [{
                    title: '二级2-1'
                    , id: 5
                    , field: ''
                    , spread: true
                    , children: [{
                        title: '三级2-1-1'
                        , id: 11
                        , field: ''
                    }, {
                        title: '三级2-1-2'
                        , id: 12
                        , field: ''
                    }]
                }, {
                    title: '二级2-2'
                    , id: 6
                    , field: ''
                    , children: [{
                        title: '三级2-2-1'
                        , id: 13
                        , field: ''
                    }, {
                        title: '三级2-2-2'
                        , id: 14
                        , field: ''
                        , disabled: true
                    }]
                }]
            }];

        //基本演示
        tree.render({
            elem: '#test12'
            , data: data
            , showCheckbox: true  //是否显示复选框
            , id: 'demoId1'
            ,showLine:false
            , click: function (obj) {
                var data = obj.data;  //获取当前点击的节点数据
                layer.msg('状态：' + obj.state + '<br>节点数据：' + JSON.stringify(data));
            }
        });

        //按钮事件
        util.event('lay-demo', {
            getChecked: function (othis) {
                var checkedData = tree.getChecked('demoId1'); //获取选中节点的数据

                layer.alert(JSON.stringify(checkedData), {shade: 0});
                console.log(checkedData);
            }
            , setChecked: function () {
                tree.setChecked('demoId1', [12, 16]); //勾选指定节点
            }
            , reload: function () {
                //重载实例
                tree.reload('demoId1', {});
            }
        });

        //基础效果
        transfer.render({
            elem: '#test1'
            ,data: data
        })

    });
</script>

</body>
</html>
