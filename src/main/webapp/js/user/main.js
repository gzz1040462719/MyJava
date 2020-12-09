

//初始化
$(document).ready(function () {

    $.sendAjax("MenuServlet","initMenu","",null,function (data) {
        var map=JSON.parse(data);
        for (var pMenu in map) {
            $("#myMenu").append(
                "<li class='layui-nav-item' href='javascript:;'>" +
                "<a class=''>"+map[pMenu][0].menuName+"</a>" +
                "<dl class='layui-nav-child' id='"+map[pMenu][0].menuId+"'> " +
                "</dl>" +
                "</li>");
            for (var sunMenu in map[pMenu]) {
                if (sunMenu!=0){
                    $("#"+map[pMenu][0].menuId+"").append(
                        "<dd><a href='"+$("#path").val()+map[pMenu][sunMenu].menuUrl+"' target='myFrameName'>"+map[pMenu][sunMenu].menuName+"</a></dd>"
                    );
                }
            }
        }
    });

    setTimeout(function () {
        //JavaScript代码区域
        layui.use('element', function(){
            var element = layui.element;
        });
    }, 500);

});

