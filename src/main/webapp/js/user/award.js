$(function () {
    init();
});

var ordArr=[];

function init() {
    //初始化积分奖励页面
    $.ajax({
        url:$("#path").val()+"/DocumentServlet?methodName=initPage",
        type: "post",
        data: "",
        dataType: "text",
        //收到服务器响应信息
        success: function (data) {
            var select= JSON.parse(data);
            $(select).each(function () {
                var documentTypesId=$(this)[0].documentTypesId;
                var documentTypesName=$(this)[0].documentTypesName;
                var documentTypesScore=$(this)[0].documentTypesScore;
                ordArr.push({"documentTypesId":documentTypesId,"documentTypesScore":documentTypesScore});
                $("#myForm").append("<div class='layui-form-item'>" +
                    " <label class='layui-form-label'>"+documentTypesName+"</label>" +
                    "<div class='layui-input-inline'>" +
                    "<input type='text'  documentTypesId='"+documentTypesId+"' name='title' required  lay-verify='required' value='"+documentTypesScore+"' autocomplete='off' class='layui-input score'>" +
                    "</div>" +
                    "</div>")
            });
            $("#myForm").append("<div class='layui-form-item'>" +
                "<div class='layui-input-block'>" +
                "<button type='button' class='layui-btn' lay-submit lay-filter='formDemo' onclick='updateScore()'>提交</button>"+
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
}


//修改积分奖励
function updateScore() {
    var list=[];
    var newList=[];
    $(".score").each(function () {
        var documentTypesId = $(this)[0].attributes.documentTypesId.nodeValue;
        var documentTypesScore = $(this).val();
        //判断是否有修改过，如果有则存入积分
        for (var i = 0; i < ordArr.length; i++) {
            if (ordArr[i].documentTypesId==documentTypesId){
                    if (ordArr[i].documentTypesScore!=documentTypesScore){
                        if (parseInt(documentTypesScore)<1){
                            layer.msg('值不能小于1');
                            return;
                        }
                        list.push({"documentTypesId":documentTypesId,"documentTypesScore":documentTypesScore});
                    }
            }
        }
        newList.push({"documentTypesId":documentTypesId,"documentTypesScore":documentTypesScore});
    });

    if (list.length<1){
        return layer.msg('暂无数据变化');
    }

    $.sendAjax("DocumentServlet","updateDocumentTypes","list="+JSON.stringify(list),null,function (data) {
        layer.msg(data);
        if (data=='修改成功'){
            //存入新的集合，用户判断是否有发生改变
            ordArr=newList;
        }
    })




}