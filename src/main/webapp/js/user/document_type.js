$(function () {
    $.ajax({
        url: $("#path").val() + "/DocumentServlet?methodName=initPage",
        type: "post",
        data: "",
        dataType: "text",
        //收到服务器响应信息
        success: function (data) {
            var select = JSON.parse(data);
            for (var i = 0; i < select.length; i++) {
                var documentTypesId = select[i].documentTypesId;
                var documentTypesName = select[i].documentTypesName;
                var documentTypesScore = select[i].documentTypesScore;
                var documentTypesState = select[i].documentTypesState;
                // ordArr.push({"documentTypesId": documentTypesId, "documentTypesScore": documentTypesScore});
                $("#myForm").append("<div class='layui-form-item'>" +
                    "<div class='layui-input-block myDemo"+documentTypesId+"'>" +
                    "</div>" +
                    "</div>");
                $(".myDemo"+documentTypesId+"").append("<input id='"+documentTypesId+"' value='"+documentTypesId+"' type='checkbox' title='" + documentTypesName + "'>");

                if (documentTypesState == 6) {
                    $("#" + documentTypesId + "").attr("checked", "checked");
                }
                if (++i < select.length) {
                    $(".myDemo"+documentTypesId+"").append("<input id='" + select[i].documentTypesId + "' value='"+select[i].documentTypesId+"'  type='checkbox' title='" + select[i].documentTypesName + "'>");
                    if (select[i].documentTypesState == 6) {
                        $("#" + select[i].documentTypesId + "").attr("checked", "checked");
                    }
                }
                if (++i < select.length) {
                    $(".myDemo"+documentTypesId+"").append("<input id='" + select[i].documentTypesId + "' value='"+select[i].documentTypesId+"' type='checkbox' title='" + select[i].documentTypesName + "'>");
                    if (select[i].documentTypesState == 6) {
                        $("#" + select[i].documentTypesId + "").attr("checked", "checked");
                    }
                }
            }

            $("#myForm").append("<div class='layui-form-item'>" +
                "<div class='layui-input-block'>" +
                "<button type='button' class='layui-btn' lay-submit lay-filter='formDemo' onclick='updateScore()'>提交</button>" +
                "</div>" +
                "</div>");
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

//修改文档类型状态
function updateScore() {
    var list=[];
    //获取所有被选中的复选框
    $("input[type=checkbox]:checked").each(function () {
        console.log($(this).val());
        var documentTypesId = $(this).val();
        list.push({"documentTypesId":documentTypesId,"documentTypesState":6})
    })
    //获取所有未被选中的复选框
    $("input[type=checkbox]:not(:checked)").each(function () {
        console.log($(this).val());
        var documentTypesId = $(this).val();
        list.push({"documentTypesId":documentTypesId,"documentTypesState":7})
    })
    console.log(list);
    $.sendAjax("DocumentServlet","updateDocumentTypes","list="+JSON.stringify(list),null,function (data) {
        layer.msg(data);
    })
}