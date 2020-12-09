
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
        , url: $("#path").val()+'/loginServlet?methodName=userList'
        , cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
        , cols: [[
            {checkbox: true, fixed: true}
            , {field: 'registerTimeName', title: '操作时间', sort: true, fixed: true}
            , {field: 'userName', title: '操作人'}
            , {field: 'userName', title: '操作事项'}
        ]]
        , id: 'testReload'
        , page: true
        // ,height: 310
        , limits: [5, 10, 15, 20]
        , limit: 5
    });

    var $ = layui.$, active = {
        reload: function () {
            var stateTime = $('#stateTime');
            var entTime = $('#entTime');
            var userName = $('#userName');
            //执行重载
            table.reload('testReload', {
                page: {
                    curr: 1 //重新从第 1 页开始
                }
                , where: {
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
        // console.log(obj);
        if (obj.event === 'forbid') {
            layer.confirm('确定禁用吗？', function (index) {
                $.sendAjax("loginServlet","userState","userId="+obj.data.userId+"&userState=2",null,function (date) {
                    layer.alert(date);
                    if (date=='修改成功'){
                        var eq = $(obj.tr[0].cells[7].childNodes[0].childNodes[1]);
                        $(eq).text('启用');
                        $(obj.tr[0].cells[6].childNodes[0]).text('禁用');
                        $(eq).attr("class","layui-btn layui-btn-normal layui-btn-xs");
                        $(eq).attr("lay-event","start");
                    }
                });
            });
        } else if (obj.event === 'start') {
            layer.confirm('确定启用吗？', function (index) {
                $.sendAjax("loginServlet","userState","userId="+obj.data.userId+"&userState=1",null,function (date) {
                    layer.alert(date);
                    if (date=='修改成功'){
                        var eq = $(obj.tr[0].cells[7].childNodes[0].childNodes[1]);
                        $(eq).text('禁用');
                        $(obj.tr[0].cells[6].childNodes[0]).text('启用');
                        $(eq).attr("lay-event","forbid");
                        $(eq).attr("class","layui-btn layui-btn-danger layui-btn-xs");

                    }
                });
            });
        }
    });
});



});