<%--
  Created by IntelliJ IDEA.
  User: Masters
  Date: 2020/6/2
  Time: 17:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head lang="en">
    <meta charset="utf-8"/>
    <title>forget</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/proList.css"/>
    <link rel="stylesheet" type="text/css" href="css/forget.css"/>
</head>
<body>
<!----------------------------------------order------------------>
<div class="order cart">
    <!-----------------logo------------------->
    <div class="logo">
        <h1 class="wrapper clearfix">
            <a href="index.html"><img class="fl" src="img/temp/logo.png"></a>
        </h1>
    </div>
    <div class="forCon">
        <p>安全设置-找回密码</p>
        <ul>
            <li class="on"><span>01/</span>输入登录名</li>
            <li><span>02/</span>验证信息</li>
            <li><span>03/</span>重置密码</li>
        </ul>
        <div class="formCon">
            <!--步骤1-->
            <form action="#" method="post" class="one">
                <input type="text" id="mailbox" value="" placeholder="昵称/邮箱"><label>请输入邮箱</label><br/>
                <input type="text" id="code" class="code" value="" placeholder="验证码"><label>请输入验证码</label><br/>
                <canvas id="canvas" width="97" height="37" style="margin-top: 10px;"></canvas><br/>
                <p style="margin-top: 10px"><span id="msg" style="color:red">${msg}</span></p>
                <input type="button" onclick="return checkForm()" value="下一步" class="next">
            </form>
            <!--步骤2-->
            <form action="#" method="post" class="two">
                <p>电子邮箱：<span id="span">114081*****qq.com</span></p>
                <p class="tip">验证邮件已发往你的电子邮箱，请输入验证码完成验证</p>
                <input type="text" id="verifyCode" value="" placeholder="验证码"><label>请输入验证码</label><br/>
                <p style="margin-top: 10px"><span id="msgTwo" style="color:red">${msgTwo}</span></p>
                <input type="button" onclick="return checkFormTwo()" value="邮箱验证" class="next1">
            </form>
            <!--步骤3-->
            <form action="#" method="post" class="three">
                <label>新密码：</label><input type="text" id="upwd1" name="password" value=""><br/>
                <label>确认密码：</label><input type="text" id="upwd2" value=""><br/>
                <input id="email" type="hidden" name="email" value=""/>
                <p style="margin-top: 10px;margin-left: 90px"><span id="msgThree" style="color:red">${msgThree}</span></p>
                <input type="button" onclick="return checkFormThree()"  value="完成">
            </form>
        </div>
    </div>
</div>

<script src="js/jquery-1.12.4.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/public.js" type="text/javascript" charset="utf-8"></script>
<script src="js/pro.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">

    var show_num = [];
    $(function () {
        draw(show_num);
        $("#canvas").on('click', function () {
            draw(show_num);
        })
    })

/*    $(".next").click(function () {
        $(".two").show();
        $(".one").hide();
        $(".forCon ul li").eq(1).addClass("on").siblings("li").removeClass("on");
    });
    */
    function checkForm() {
        var mailbox = $("#mailbox").val();
        var code = $("#code").val();
        var val = $(".code").val().toLowerCase();
        var num = show_num.join("");
        var reg = new RegExp("^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$"); //正则表达式
        if (mailbox == null || mailbox == "") {
            $("#msg").html("*邮箱不能为空");
            return false;
        }
        if(!reg.test(mailbox)){ //正则验证不通过，格式不对
            $("#msg").html("*邮箱格式不正确");
            return false;
        }
        if (code == null || code == "") {
            $("#msg").html("*验证码不能为空");
            return false;
        }
        if (!(val == num)) {
            $("#msg").html("*验证码错误");
            $(".code").val('');
            draw(show_num);
            return false;
        }

        //收件人邮箱
        var toEmailAddress= mailbox;

        $.ajax({
            type:"post",
            url:"sendEmailSystem",
            data:{
                toEmailAddress: toEmailAddress
            },
            dataType:"json",
            success:function(data){
                if(0 == data.code){
                    $("#span").html(mailbox);
                    $(".two").show();
                    $(".one").hide();
                    $(".forCon ul li").eq(1).addClass("on").siblings("li").removeClass("on");
                    return true;
                } else {
                    $("#msg").html(data.msg);
                    return false;
                }
            },
            error:function(){
                alert("数据传送失败！");
                return false;
            }
        });
    }

    function checkFormTwo() {
        var mail = $("#span").html();
        var verifyCode = $("#verifyCode").val();

        if (mail == null || mail == "") {
            $("#msgTwo").html("*邮箱不能为空");
            return false;
        }
        if (verifyCode == null || verifyCode == "") {
            $("#msgTwo").html("*验证码不能为空");
            return false;
        }

        //收件人邮箱
        var toEmailAddress= mail;

        $.ajax({
            type:"post",
            url:"verifyMailCode",
            data:{
                toEmailAddress: toEmailAddress,
                verifyCode:verifyCode
            },
            dataType:"text",
            success:function(data){
                if(data=='success'){
                    $(".three").show();
                    $(".two").hide();
                    $(".forCon ul li").eq(2).addClass("on").siblings("li").removeClass("on");
                    return true;
                }else if(data == 'emailEmpty'){
                    $("#msgTwo").html("*邮箱不能为空");
                    return false;
                }else if(data == 'verifyCodeEmpty'){
                    $("#msgTwo").html("*验证码不能为空");
                    return false;
                }else if (data == 'verifyCodeError'){
                    $("#msgTwo").html("*验证码错误！");
                    return false;
                }else {

                }
            },
            error:function(){
                alert("数据传送失败！");
                return false;
            }
        });
    }

    function checkFormThree() {
        var mail = $("#span").html();
        var upwd1 = $("#upwd1").val();
        var upwd2 = $("#upwd2").val();

        if (upwd1 == null || upwd1 == "") {
            $("#msgThress").html("*新密码不能为空");
            return false;
        }
        if (!(upwd1 == upwd2)) {
            $("#msgThree").html("*两次输入的密码不一致");
            return false;
        }

        $.ajax({
            type:"post",
            url:"updatePwdByEmail",
            data:{
                email: mail,
                password:upwd1
            },
            dataType:"text",
            success:function(data){
                if(data=='success'){
                    window.location.href = "login.html";
                } else if(data == 'emailEmpty'){
                    $("#msgThree").html("*邮箱不能为空");
                    return false;
                }else if (data == 'passwordEmpty'){
                    $("#msgThree").html("*密码不能为空");
                    return false;
                }else{

                }
            },
            error:function(){
                alert("数据传送失败！");
                return false;
            }
        });

        return true;
    }
    //生成并渲染出验证码图形
    function draw(show_num) {
        var canvas_width = $('#canvas').width();
        var canvas_height = $('#canvas').height();
        var canvas = document.getElementById("canvas");//获取到canvas的对象，演员
        var context = canvas.getContext("2d");//获取到canvas画图的环境，演员表演的舞台
        canvas.width = canvas_width;
        canvas.height = canvas_height;
        var sCode = "a,b,c,d,e,f,g,h,i,j,k,m,n,p,q,r,s,t,u,v,w,x,y,z,A,B,C,E,F,G,H,J,K,L,M,N,P,Q,R,S,T,W,X,Y,Z,1,2,3,4,5,6,7,8,9,0";
        var aCode = sCode.split(",");
        var aLength = aCode.length;//获取到数组的长度
        for (var i = 0; i < 4; i++) { //这里的for循环可以控制验证码位数（如果想显示6位数，4改成6即可）
            var j = Math.floor(Math.random() * aLength);//获取到随机的索引值
            // var deg = Math.random() * 30 * Math.PI / 180;//产生0~30之间的随机弧度
            var deg = Math.random() - 0.5; //产生一个随机弧度
            var txt = aCode[j];//得到随机的一个内容
            show_num[i] = txt.toLowerCase();
            var x = 10 + i * 20;//文字在canvas上的x坐标
            var y = 20 + Math.random() * 8;//文字在canvas上的y坐标
            context.font = "bold 23px 微软雅黑";
            context.translate(x, y);
            context.rotate(deg);
            context.fillStyle = randomColor();
            context.fillText(txt, 0, 0);
            context.rotate(-deg);
            context.translate(-x, -y);
        }
        for (var i = 0; i <= 5; i++) { //验证码上显示线条
            context.strokeStyle = randomColor();
            context.beginPath();
            context.moveTo(Math.random() * canvas_width, Math.random() * canvas_height);
            context.lineTo(Math.random() * canvas_width, Math.random() * canvas_height);
            context.stroke();
        }
        for (var i = 0; i <= 30; i++) { //验证码上显示小点
            context.strokeStyle = randomColor();
            context.beginPath();
            var x = Math.random() * canvas_width;
            var y = Math.random() * canvas_height;
            context.moveTo(x, y);
            context.lineTo(x + 1, y + 1);
            context.stroke();
        }
    }
    //得到随机的颜色值
    function randomColor() {
        var r = Math.floor(Math.random() * 256);
        var g = Math.floor(Math.random() * 256);
        var b = Math.floor(Math.random() * 256);
        return "rgb(" + r + "," + g + "," + b + ")";
    }
</script>
</body>
</html>

