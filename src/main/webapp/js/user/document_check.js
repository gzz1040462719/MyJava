
$(function () {
//渲染时间
layui.use('laydate', function () {
    var laydate = layui.laydate;
    //日期时间选择器
    laydate.render({
        elem: '#stateTime'
        , type: 'datetime'
    });

    //日期时间选择器
    laydate.render({
        elem: '#entTime'
        , type: 'datetime'
    });
});
layui.use('table', function () {
    var table = layui.table;
    var $ = layui.$ //重点处
    //方法级渲染
    table.render({
        elem: '#LAY_table_user'
        , url: $("#path").val()+'/DocumentServlet?methodName=conditionFindAll'
        , cellMinWidth: 60 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
        , page: true
        , limit: 5
        , limits: [5, 10, 15, 20]
        , cols: [[
            {checkbox: false, fixed: false}
            , {field: 'documentName', title: '文档名称', sort: true, fixed: true}
            , {templet:'<div>{{createrFormat(d.user.userName)}}</div>', title: '上传人'}
            , {field: 'startTimeName', title: '上传时间', sort: true}
            , {templet:'<div>{{createrFormat(d.documentTypes.documentTypesScore)}}</div>', title: '下载积分'}
            , {templet:'<div>{{createrFormat(d.documentTypes.documentTypesName)}}</div>', title: '文档类型'}
            , {templet:'<div>{{createrFormat(d.parameter.parameterName)}}</div>', title: '文档状态'}
            , {fixed: 'right', title: '操作', toolbar: '#barDemo',width:300}
        ]]
        , id: 'testReload'
    });

    var $ = layui.$, active = {
        reload: function () {
            var documentName = $('#documentName');
            var userName = $('#userName');
            var documentType = $('#documentType');
            var stateTime = $('#stateTime');
            var entTime = $('#entTime');
            //执行重载
            table.reload('testReload', {
                page: {
                    curr: 1 //重新从第 1 页开始
                }
                , where: {
                    documentName: documentName.val(),
                    documentType: documentType.val(),
                    stateTime: stateTime.val(),
                    entTime: entTime.val(),
                    userName: userName.val()
                }
            }, 'data');
        }
    };

    $('.demoTable .layui-btn').on('click', function () {
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
    });

    //监听行工具事件
    table.on('tool(user)', function (obj) {
        var data = obj.data;
        if (obj.event === 'win') {
            layer.confirm('确定通过改文档？', function (index) {
                $.sendAjax("DocumentServlet","checkDocument","documentId="+obj.data.documentId+"&documentState=4",null,function (date) {
                    layer.alert(date);
                    if (date=='修改成功'){
                        var eq = $(obj.tr[0].cells[7].childNodes[0].childNodes[3]);
                        var eq2 = $(obj.tr[0].cells[7].childNodes[0].childNodes[5]);
                        $(eq).css("display","none");
                        $(eq2).css("display","none");
                        $(obj.tr[0].cells[6].childNodes[0]).text('审核通过');
                    }
                });
            });
        } else if (obj.event === 'defeated') {
            layer.confirm('该文档将不通过，是否继续？', function (index) {
                $.sendAjax("DocumentServlet","checkDocument","documentId="+obj.data.documentId+"&documentState=5",null,function (date) {
                    layer.alert(date);
                    if (date=='修改成功'){
                        var eq = $(obj.tr[0].cells[7].childNodes[0].childNodes[3]);
                        var eq2 = $(obj.tr[0].cells[7].childNodes[0].childNodes[5]);
                        $(eq).css("display","none");
                        $(eq2).css("display","none");
                        $(obj.tr[0].cells[6].childNodes[0]).text('审核不通过');
                    }
                });
            });
        }
    });
});





//初始化下拉框
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
               $("#documentType").append("<option value='"+documentTypesId+"'>"+documentTypesName+"</option>")
           })
        },
    })


});

//模板方法
function createrFormat(o){
    return o;
}