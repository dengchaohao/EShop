$(function () {

//	订单页面  修改地址
    $(".edit").click(function () {
        $(".mask").show();
        $(".adddz").show();
    });

    $(".bc>input").click(function () {
        if ($(this).val() == "保存") {
            $(".mask").hide();
            $(".adddz").hide();
            $(".bj").hide();
            $(".xg").hide();
            $(".remima").hide();
            $(".pj").hide();
            $(".chak").hide();
        } else {
            $(".mask").hide();
            $(".adddz").hide();
            $(".bj").hide();
            $(".xg").hide();
            $(".remima").hide();
            $(".pj").hide();
            $(".chak").hide();
        }
    });


//	我的订单tab切换
    $("#wa li").click(function () {
        $(this).addClass("on").siblings().removeClass("on");
        var txt1 = $(this).find("a").text();
        $(".dkuang").find("p.one").each(function () {
            var txt2 = $(this).text();
            if (txt1 == txt2) {
                $(this).parent(".dkuang").show().siblings(".dkuang").hide();
            }
            $("#wa li").eq(0).click(function () {
                $(".dkuang").show();
            })
        });
    });

//	评价 tab切换

    $(".sx div:gt(0)").hide();
    $(".sx div").each(function (i) {
        if ($(this).html() == '') {
            var str = $("#pro li").eq(i).find("a").text();
            var txt = '';
            txt = '<div class="noz">当前没有' + str + '。</div>';
            $(this).html(txt);
        }
    });
    $("#pro li").click(function () {
        $(this).addClass("on").siblings().removeClass("on");
        var index = $(this).index();
        $(".sx > div").eq(index).show().siblings().hide();
    });


//		评价打心
    $(".sx dl dd").find("a").click(function () {
        if ($(this).text() == "评价") {
            $(".mask").show();
            $(".pj").show();
            var orderItemId = $(this).parent("dd").parent(".fl").children(".orderItemId").val();
            //alert(orderItemId);
            $(".pj").find(".form").find(".orderItemId").attr("value",orderItemId);

        } else if ($(this).text() == "查看评价") {
            $(".mask").show();
            $(".chak").show();
            var orderItemId = $(this).parent("dd").parent(".fl").children(".orderItemId").val();
            var content = $(this).parent("dd").parent(".fl").children(".content").val();
            $(".chak").find(".form").find(".orderItemId").attr("value",orderItemId);
            $(".chak").find(".form").find("textarea").html(content);

        } else {
            $(".mask").hide();
            $(".pj").hide();
            $(".chak").hide();
        }

    });
//	评价打心
    $("#xin").each(function (i) {
        $("#xin").eq(i).children("a").click(function () {
            var index = $(this).index();
            for (var j = 0; j < 5; j++) {
                if (j <= index) {
                    $("#xin").eq(i).find("a").eq(j).find("img").attr("src", "img/hxin.png");
                } else {
                    $("#xin").eq(i).find("a").eq(j).find("img").attr("src", "img/xin.png");
                }

            }
        })
    })


//	个人信息 编辑
    $("#edit1").click(function () {
        $(".mask").show();
        $(".bj").show();
    });
    $("#edit2").click(function () {
        $(".mask").show();
        $(".xg").show();
    });

//修改头像
    $("#avatar").click(function () {
        $(".mask").show();
        $(".avatar").show();
    });

//	弹框关闭按钮
    $(".gb").click(function () {
        $(".mask").hide();
        $(".bj").hide();
        $(".xg").hide();
        $(".remima").hide();
        $(".avatar").hide();
        $(".pj").hide();
        $(".chak").hide();
    });


/*
//	address
    $("#addxad").click(function () {
        $(".mask").show();
        $(".adddz").show();
    });
    $(".dizhi").hover(function () {
        /!*var txt = "";
        txt = ''*!/
        /!*$(this).append(txt);*!/
        $("#readd").click(function () {
            $(".mask").show();
            $(".readd").show();
        });
        $("#deladd").click(function () {
            /!*$.ajax({
                type: "post",
                url: "delAddress.do",
                data: {
                    id: $("#id").innerText
                },
                dataType: "text",
                success: function (result) {

                    if (result == 'success') {
                        alert("删除成功");
                    }
                    if (result == 'false') {
                        alert("删除失败");
                    }
                },
                error: function () {
                    alert("删除失败");
                }
            });*!/
            //alert($("#id").innerText);
            $(this).parents(".dizhi").remove();
        });
    }, function () {
        $(".bc>input").click(function () {
            if ($(this).val() == "保存") {
                $(".mask").hide();
                $(".readd").hide();
            } else {
                $(".mask").hide();
                $(".readd").hide();
            }
        });
        //$(".addp").remove();
    });
*/
//	address
/*    $("#addxad").click(function () {
        $(".mask").show();
        $(".adddz").show();
    });
    $(".dizhi").hover(function () {
        $(".readda").click(function () {
            $(".mask").show();
            $(".readd").show();
        });
        $(".deladd").click(function () {
            $(this).parents(".dizhi").remove();
        });
    }, function () {
        $(".bc>input").click(function () {
            if ($(this).val() == "保存") {
                $(".mask").hide();
                $(".readd").hide();
            } else {
                $(".mask").hide();
                $(".readd").hide();
            }
        });
        //$(".addp").remove();
    });*/

//	address
    $("#addxad").click(function(){
        $(".mask").show();
        $(".adddz").show();
    });
    $(".dizhi").hover(function(){
        var txt="";
        txt='<p class="addp"><a href="#" style="color: #A10000;display: inline-block;margin-right:10px;" class="re">修改</a><a href="#" style="color: #A10000;display: inline-block;margin-right:10px;" class="del">删除</a></p>'
        $(this).append(txt);
        $(".re").click(function(){
            var idcode = $(this).parents(".dizhi").children(".id").val();
            var action = "updateAddress?id=" + idcode;
            $(".mask").show();
            $(".readd").show();
            $(".readd").children(".form").attr("action",action);
        });
        $(".del").click(function(){
            var id = $(this).parents(".dizhi").children(".id").val();
            alert(id);
            $.ajax({
                url:'delAddress',
                data:{id:id},
                //dataType:'json',
                dataType: "text",
                type:'get',
                traditional:true,//必须设置
                success:function(data){
                    if (data == 'success') {
                        window.location.href = "address.html";
                    }
                    if (data == 'false') {
                        window.location.href = "address.html";
                    }
                }
            });
            //$(this).parents(".dizhi").remove();
        });
    },function(){
        $(".bc>input").click(function(){
            if($(this).val()=="保存"){
                $(".mask").hide();
                $(".readd").hide();
            }else{
                $(".mask").hide();
                $(".readd").hide();
            }
        });
        $(".addp").remove();
    });
//	查看物流
    $(".vewwl").hover(function () {
        $(this).children(".wuliu").fadeIn(100);
    }, function () {
        $(this).children(".wuliu").fadeOut(100);
    });

})


