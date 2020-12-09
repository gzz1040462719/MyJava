
$(function () {
    layui.use('form', function(){
        var form = layui.form;

        //监听提交
        form.on('submit(formDemo)', function(data){
            layer.msg(JSON.stringify(data.field));
            return false;
        });
    });
    layui.use('upload', function(){
        var $ = layui.jquery
            ,upload = layui.upload;

        //选完文件后不自动上传
        upload.render({
            elem: '#test8'
            ,url: $("#path").val()+'/FileUpServlet' //改成您自己的上传接口
            ,auto: false
            ,method:'post'
            // ,multiple: true
            ,bindAction: '#uploadingBtn'
            ,accept:'file'
            ,done: function(res){
                layer.msg(res);
                console.log(res)
            }
        });
    });

});

