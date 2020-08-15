<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<div class="container-fluid">
<!--控制按钮-->
<div class="clearfix cloud-cdn-block2">
    <form class="form-horizontal" enctype="multipart/form-data" method="post" role="form"
          action="/activiti/deploy.json">
        <!-- 相对路径 -->
        <div class="form-group">
            <label for="profile" class="col-sm-2 control-label">文件：</label>
            <div class="col-sm-6">
                <input type="file" class="form-control" name="profile" id="profile" placeholder="选择要发布的流程文件">
            </div>
        </div>

        <div class="form-group">
            <label for="name" class="col-sm-2 control-label">流程名：</label>
            <div class="col-sm-5">
                <input type="text" class="form-control" name="name" id="name" placeholder="请输入流程名">
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-5  control-label">
                <button type="submit" class="btn btn-default" >发布流程</button>
            </div>
        </div>

    </form>
    <div>
    <%@include file="gdlist.jsp"  %>
    </div>
</div>
</div>
</body>
</html>