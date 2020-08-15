<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<h1>流程定义列表</h1>
<table width="600" border="1" align="center" cellpadding="1" cellspacing="0">
    <tr>
        <td>流程定义ID</td>
        <td>流程KEY</td>
        <td>流程Vesrion</td>
        <td>申请</td>
    </tr>
    <c:forEach items="${definitionList}" var="defi">
        <tr>
            <td>&nbsp;${defi.definitionId}</td>
            <td>&nbsp;${defi.key}</td>
            <td>&nbsp;${defi.version} </td>
            <td><a href="/activiti/startTask.json?key=${defi.key}">服务器申请</a></td>
        </tr>
    </c:forEach>
</table>

<h1>流程任务列表</h1>
<table width="600" border="1" align="center" cellpadding="1" cellspacing="0">
    <tr>
        <td>任务ID</td>
        <td>任务名称</td>
        <td>申请时间</td>
        <td>审批</td>
    </tr>
    <c:forEach items="${taskList}" var="dto">
    <tr>
        <td>&nbsp;${dto.taskId}</td>
        <td>&nbsp;${dto.taskName}</td>
        <td>&nbsp;${dto.taskTime} </td>
        <td><a href="/activiti/completeTask.json?taskId=${dto.taskId}">完成任务</a></td>
    </tr>
    </c:forEach>
</table>
</body>
</html>
