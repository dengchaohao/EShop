<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ page pageEncoding="utf-8"%>
<html>
<body>
<h2>Hello World!</h2>
<hr/>
<%--每一个标签都对应一个具体的类--%>
<%-- 已登录 --%>
欢迎您，
<shiro:authenticated> <%--只有已登录的用户才显示标签的内容--%>
    <shiro:principal/>
    <a href="/user/logout">登出</a> <%-- 登出会抹除一切痕迹，包括记住我 --%>
</shiro:authenticated>

欢迎您，
<shiro:user> <%--只有已登录或记住我的用户才显示标签的内容--%>
    <shiro:principal/>
    <a href="/user/logout">登出</a>
</shiro:user>

<shiro:guest>
    <a href="/user/login">请登录</a>
</shiro:guest>
<shiro:guest>
    游客...
</shiro:guest>
<hr>
<shiro:hasRole name="banzhang">
    <a href="#">班长的操作</a>
</shiro:hasRole>
<shiro:lacksRole name="banzhang">
    <a href="#">学生的操作</a>
</shiro:lacksRole>
<shiro:hasAnyRoles name="banzhang,student">
    <a href="#">学习</a>
</shiro:hasAnyRoles>
<hr>
<shiro:hasPermission name="student:yq">
    <a href="#">要钱</a>
</shiro:hasPermission>
<shiro:lacksPermission name="student:yq">
    <a href="#">学习</a>
</shiro:lacksPermission>
</body>
</html>
