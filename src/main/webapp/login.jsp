<%--
  Created by IntelliJ IDEA.
  User: Masters
  Date: 2020/7/17
  Time: 16:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/user/login" method="post">
        username: <input type="text" name="username"> <br/>
        password：<input type="text" name="password"> <br/>
        <input type="submit" value="登录">
    </form>
</body>
</html>
