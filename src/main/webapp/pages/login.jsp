<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/12/1
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <script src="${pageContext.request.contextPath}/js/jquery-3.5.1.js" type="text/javascript" charset="UTF-8"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/layui/layui.all.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
</head>
<body>
<%--<form class="layui-form" action="" method="post">--%>
<input id="path" type="hidden" value="${pageContext.request.contextPath}">
<div class="container">
    <button class="close" title="关闭">X</button>
    <div class="layui-form-mid layui-word-aux">
        <img id="logoid" src="img/01.png" height="35">
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">用户名</label>
        <div class="layui-input-block">
            <input type="text" id="account" name="account" required lay-verify="required" placeholder="请输入用户名"
                   autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">密 &nbsp;&nbsp;码</label>
        <div class="layui-input-inline">
            <input type="password" id="password" name="password" required lay-verify="required" placeholder="请输入密码"
                   autocomplete="off" class="layui-input">
        </div>
        <!-- <div class="layui-form-mid layui-word-aux">辅助文字</div> -->
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">验证码</label>
        <div class="layui-input-inline">
            <input type="text" id="code" name="title" required lay-verify="required" placeholder="请输入验证码" autocomplete="off"
                   class="layui-input verity">
        </div>
    <div class="layui-form-mid layui-word-aux"> <input id="loginCode" class="layui-input codeInput"  type="button"></div>
    </div>
    <!-- 			  <div class="layui-form-item">
                        <label class="layui-form-label">记住密码</label>
                        <div class="layui-input-block">
                          <input type="checkbox" name="close" lay-skin="switch" lay-text="ON|OFF">
                        </div>
                  </div> -->
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" id="logBtn">登陆</button>
        </div>

    </div>
    <a href="" class="font-set">忘记密码?</a> <a id="butt" class="font-set">立即注册</a>
</div>
<%--</form>--%>


<%--注册页面--%>
<div style="display: none;" id="gb">
<%--    <form class="layui-form" action="">--%>
        <div class="layui-form-item">
            <label class="layui-form-label">用户账号</label>
            <div class="layui-input-inline">
                <input type="text" id="userAccount" name="account" required lay-verify="required" placeholder="请输入账号" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">用户密码</label>
            <div class="layui-input-inline">
                <input type="password"  name="password" required lay-verify="pwd" placeholder="请输入密码" autocomplete="off"
                       class="layui-input" id="userPassword">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">确认密码</label>
            <div class="layui-input-inline">
                <input type="password" name="passwords" required lay-verify="pwd" placeholder="请再次输入密码"
                       autocomplete="off" class="layui-input" id="pass2">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">邮箱</label>
            <div class="layui-input-inline">
                <input type="email" id="email" name="email" required lay-verify="emails" placeholder="请输入邮箱" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">联系方式</label>
            <div class="layui-input-inline">
                <input type="text" id="mobile" name="phone" required lay-verify="phones" placeholder="请输入手机号" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">单选框</label>
            <div class="layui-input-block">
                <input type="radio" name="sex" value="男" title="男" checked>男
                <input type="radio" name="sex" value="女" title="女">女
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">真实姓名</label>
            <div class="layui-input-inline">
                <input type="text" name="truename" id="userName" required lay-verify="truename" placeholder="请输入您的姓名"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">身份证</label>
            <div class="layui-input-inline">
                <input type="text" name="cardId" id="idNumber" required lay-verify="cardId" placeholder="请输入身份证号" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button id="register" class="layui-btn" lay-submit lay-filter="formDemo2" style="width: 100px">立即提交</button>
                <button type="reset" class="layui-btn layui-btn-primary" style="width: 100px">重置</button>
            </div>
        </div>
<%--    </form>--%>
</div>

<script type="text/javascript" src="layui/layui.js"></script>
<script>
    //注册按钮
    $(function () {
        layui.use(['form', 'layedit', 'laydate'], function () {
            var form = layui.form
                , layer = layui.layer
                , layedit = layui.layedit
                , laydate = layui.laydate;
            $("#loginCode").css("width","100px");
            //登录事件
            $("#logBtn").click(function () {
                login(layer);
            });

            // 页面初始化生成验证码
            window.onload = createCode('#loginCode');
            // 验证码切换
            $('#loginCode').click(function () {
                createCode('#loginCode');
            });

            //日期
            /* laydate.render({
               elem: '#date'
             });
             laydate.render({
               elem: '#date1'
             });

             //创建一个编辑器
             var editIndex = layedit.build('LAY_demo_editor');

             //自定义验证规则
             form.verify({
               title: function(value){
                 if(value.length < 5){
                   return '标题至少得5个字符啊';
                 }
               }
               ,pass: [
                 /^[\S]{6,12}$/
                 ,'密码必须6到12位，且不能出现空格'
               ]
               ,content: function(value){
                 layedit.sync(editIndex);
               }
             });

             //监听指定开关
             form.on('switch(switchTest)', function(data){
               layer.msg('开关checked：'+ (this.checked ? 'true' : 'false'), {
                 offset: '6px'
               });
               layer.tips('温馨提示：请注意开关状态的文字可以随意定义，而不仅仅是ON|OFF', data.othis)
             });*/

            // //监听提交
            // form.on('submit(formDemo)', function(data){
            //     // layer.alert(JSON.stringify(data.field), {
            //     //     title: '最终的提交信息'
            //     // });
            //     return false;
            // });
            //表单初始赋值
            /* form.val('example', {
               "username": "贤心" // "name": "value"
               ,"password": "123456"
               ,"interest": 1
               ,"like[write]": true //复选框选中状态
               ,"close": true //开关状态
               ,"sex": "女"
               ,"desc": "我爱 layui"
             })*/
            $("#butt").click(function () {
                layer.open({
                    type: 1,
                    title: "注册页面",
                    area: ['600px', '600px'],
                    offset: '20px',
                    content: $("#gb"),
                    cancel: function () {
                        // 你点击右上角 X 取消后要做什么
                        // setTimeout('window.location.reload()', 1);
                        $("#gb").css("display", "none")
                    },
                    success: function () {
                        form.on('submit(formDemo2)', function (data) {
                        });
                    }
                });
                form.render();
            });

            //注册
            $("#register").click(function () {
                var userPassword = $("#userPassword").val();
                var pass2 = $("#pass2").val();
                if (userPassword !== pass2) {
                    layer.msg("两次输入的密码不一致", {
                        "icon": 2,
                        "time": 2000
                    });
                    $("#pass2").val("");
                    return;
                }
                register(layer);
            });


            // //验证输入的密码是否相同；
            // $("#pass2").blur(function () {
            //
            //
            //     return true;
            // });

            //创建一个编辑器
            var editIndex = layedit.build('LAY_demo_editor');
            //自定义验证规则
            form.verify({
                title: function (value) {
                    if (value.length < 5) {
                        return '标题至少得5个字符啊';
                    }
                },
                pwd: [
                    /^(\w){6,20}$/, '只能输入6-20个字母、数字、下划线'
                ],
                emails: [
                    /^([a-zA-Z]|[0-9])(\w|\-)+@[a-zA-Z0-9]+\.([a-zA-Z]{2,4})$/, '请输入正确的邮箱格式：<br>如：xxx@qq.com<br>xxx@163.com等格式'
                ],
                phones: [
                    /^1([38][0-9]|4[579]|5[0-3,5-9]|6[6]|7[0135678]|9[89])\d{8}$/, '您的输入有误，请重新输入(中国11位手机号)'
                ],
                truename: [
                    /^[\u4e00-\u9fa5]{2,4}$/, '您的输入有误，请输入2-4位中文'
                ],
                cardId: [
                    /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/, '请输入正确的身份证号'
                ],
                content: function (value) {
                    layedit.sync(editIndex);
                }
            });
        });

    });

    // 生成验证码
    function createCode() {
        var code = "";
        // 验证码长度
        var codeLength = 4;
        // 验证码dom元素
        var checkCode = $("#loginCode");
        // 验证码随机数
        var random = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
            'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'];
        for (var i = 0; i < codeLength; i++) {
            // 随机数索引
            var index = Math.floor(Math.random() * 36);
            code += random[index];
        }
        // 将生成的随机验证码赋值
        checkCode.val(code);

    }
    //登录
    function login(layer) {
        $.sendAjax("loginServlet", "login", "account=" + $("#account").val() + "&password=" + $("#password").val(), function () {
            // if ($("#code").val().toUpperCase!=$("#loginCode").val().toUpperCase){
            //     layer.msg("验证码错误", {
            //         "icon": 2,
            //         "time": 2000
            //     });
            //     return false;
            // }
            return true;
        }, function (date) {
            layer.open({
                type: 1
                , offset: '100px' //具体配置参考：http://www.layui.com/doc/modules/layer.html#offset
                , id: 'layerDemo' //防止重复弹出
                ,content: '<div style="padding: 20px 100px;">'+ date +'</div>'
                ,area: ['300px', '200px']
                ,shade: 0.8
                ,moveType: 1
                , btn: '确定'
                , btnAlign: 'c' //按钮居中
                , shade: 0 //不显示遮罩
                , yes: function () {
                    if (date == "登录成功") {
                        location.href = $("#path").val()+"/pages/main.jsp";
                    }
                    layer.closeAll();
                }
            });

        });
    }

    //注册
    function register(layer) {
        var sex = $("input[name=sex]:checked").val();
        var data={"userAccount":$("#userAccount").val(),"userPassword":$("#userPassword").val(),"userName":$("#userName").val(),"email":$("#email").val(),
            "mobile":$("#mobile").val(),"sex":sex,"idNumber":$("#idNumber").val()};
        $.sendAjax("loginServlet", "register", data, function () {
        }, function (date) {
            layer.open({
                type: 1
                , offset: '100px' //具体配置参考：http://www.layui.com/doc/modules/layer.html#offset
                , id: 'layerDemo' //防止重复弹出
                ,content: '<div style="padding: 20px 100px;">'+ date +'</div>'
                ,area: ['300px', '200px']
                ,shade: 0.8
                ,moveType: 1
                , btn: '确定'
                , btnAlign: 'c' //按钮居中
                , shade: 0 //不显示遮罩
                , yes: function () {
                    if (date == "注册成功") {
                        $("#gb").css("display", "none")
                    }
                    layer.closeAll();
                }
            });

        });
    }


</script>
</body>
</html>
