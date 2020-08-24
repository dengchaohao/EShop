<%--
  Created by IntelliJ IDEA.
  User: Masters
  Date: 2020/6/2
  Time: 0:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>登录</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/login.css"/>
</head>
<body>
<!-------------------login-------------------------->
<div class="login">
    <form action="loginLogic" id="loginForm" method="post">
        <h1><a href="index"><img src="img/temp/logo.png"></a></h1>
        <p></p>
        <div class="msg-warn hide"><b></b>公共场所不建议自动登录，以防账号丢失</div>
        <p><input type="text" name="username" id="userName" placeholder="昵称/邮箱/手机号"></p>
        <p><input type="text" name="password" id="passWord" placeholder="密码"></p>
        <p><input type="submit" name="" onclick="return checkForm()" id="submit" value="登  录"></p>
        <span id="msg" style="color:red">${msg}</span>
        <p class="txt"><a class="" href="reg">免费注册</a><a href="forget">忘记密码？</a></p>
    </form>
</div>

<script>
    function checkForm() {
        var userName = $("#userName").val();
        var passWord = $("#passWord").val();
        if (userName == null || userName == "") {
            $("#msg").html("*账号不能为空");
            return false;
        }
        if (passWord == null || passWord == "") {
            $("#msg").html("*密码不能为空");
            return false;
        }
        return true;
    }
</script>
<script src="js/jquery-1.12.4.min.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>
