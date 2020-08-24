<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>注册</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/login.css"/>
</head>
<body>
<!-------------------reg-------------------------->
<div class="reg">
    <form action="userReg" method="post">
        <h1><a href="index"><img src="img/temp/logo.png"></a></h1>
        <p>用户注册</p>
        <p><input type="text" id="username" name="username" value="" placeholder="请输入用户名"></p>
        <p><input type="text" id="tel" name="phone" value="" placeholder="请输入手机号"></p>
        <p><input type="text" id="email" name="email" value="" placeholder="请输入要绑定的邮箱"></p>
        <p><input type="text" id="upwd1" name="password" value="" placeholder="请输入密码"></p>
        <p><input type="text" id="upwd2" name="" value="" placeholder="请确认密码"></p>
        <p class="txtL txt"><input id="code" class="code" type="text" name="" value="" placeholder="验证码">
            <canvas id="canvas" width="100" height="30"></canvas>
        </p>
        <p><input type="submit" name="" onclick="return checkForm()" value="注册"></p>
        <p class="txtL txt">完成此注册，即表明您同意了我们的<a href="#">
            使用条款和隐私策略</a></p>
        <span id="msg" style="color:red">${msg}</span>
        <p class="txt"><a href="login.html"><span></span>已有账号登录</a></p>
        <!--<a href="#" class="off"><img src="img/temp/off.png"></a>-->
    </form>
</div>
</body>
<%--<script type="text/javascript" src="statics/js/jquery-3.5.1.min.js" ></script>--%>
<script src="js/jquery-1.12.4.min.js" type="text/javascript" charset="utf-8"></script>

<script>
    var show_num = [];
    $(function () {
        draw(show_num);
        $("#canvas").on('click', function () {
            draw(show_num);
        })
    })

    function checkForm() {
        var username = $("#username").val();
        var mailbox = $("#tel").val();
        var email = $("#email").val();
        var upwd1 = $("#upwd1").val();
        var upwd2 = $("#upwd2").val();
        var code = $("#code").val();
        var val = $(".code").val().toLowerCase();
        var num = show_num.join("");
        var reg = new RegExp("^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$"); //正则表达式

        if (username == null || username == "") {
            $("#msg").html("*用户名不能为空");
            return false;
        }
        if (mailbox == null || mailbox == "") {
            $("#msg").html("*手机号不能为空");
            return false;
        }
        if (email == null || email == "") {
            $("#msg").html("*邮箱不能为空");
            return false;
        }
        if(!reg.test(email)){ //正则验证不通过，格式不对
            $("#msg").html("*邮箱格式不正确");
            return false;
        }
        if (upwd1 == null || upwd1 == "") {
            $("#msg").html("*密码不能为空");
            return false;
        }
        if (!(upwd1 == upwd2)) {
            $("#msg").html("*两次输入的密码不一致");
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
</html>