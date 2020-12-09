var parameterId;
var parameterName;
$(function () {
    $.ajax({
        url: $("#path").val() + "/loginServlet?methodName=initScorePage",
        type: "post",
        data: "",
        dataType: "text",
        //收到服务器响应信息
        success: function (data) {
            if (data != null && data.length > 1) {
                var select = JSON.parse(data);
                parameterId = select.parameterId;
                 parameterName = select.parameterName;
                var parameterType = select.parameterType;

                $("#myForm").append("<div class='layui-form-item'>" +
                    " <label class='layui-form-label'>"+parameterType+":</label>" +
                    "<div class='layui-input-inline'>" +
                    " <input type='text' id='score' name='title' required  lay-verify='required' placeholder='当前积分为:" + parameterName + "' autocomplete='off' class='layui-input'>" +
                    "</div>" +
                    "</div>");
                // 追加按钮
                $("#myForm").append("<div class='layui-form-item'>" +
                    "<div class='layui-input-block'>" +
                    "<button type='button' class='layui-btn' lay-submit lay-filter='formDemo' onclick='updateScore()'>提交</button>" +
                    "</div>" +
                    "</div>");
            }
        },
    });

    layui.use('form', function () {
        var form = layui.form; //只有执行了这一步，部分表单元素才会自动修饰成功
        //……
        //但是，如果你的HTML是动态生成的，自动渲染就会失效
        //因此你需要在相应的地方，执行下述方法来手动渲染，跟这类似的还有 element.init();
        form.render();
    });
});


//修改注册积分奖励
function updateScore(){
    var score=$("#score").val();
    if (parameterName==score)
    {
        return layer.msg('积分未改变');
    }
    if(score.length<1){
      return layer.msg('请输入积分');
    }
    $.sendAjax("loginServlet","updateScore","score="+score,null,function (data) {
        layer.msg(data);
        if (data=='修改成功'){
            $("#score").attr("placeholder","当前积分为:"+score+"");
            $("#score").val(score);
            parameterName=score;
        }
    })

}