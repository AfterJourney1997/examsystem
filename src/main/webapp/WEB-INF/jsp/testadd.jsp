<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <link href="${pageContext.request.contextPath}/css/body.css" rel="stylesheet" rev="stylesheet" type="text/css" media="all" />
    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
    <title>省级初中信息技术结业在线考试系统 - 添加试卷</title>
</head>
<body>
<%@include file="head.jsp"%>
<%@include file="leaf.jsp"%>

<div class="main">
    <form class="form-inline" action="${pageContext.request.contextPath}/addtest">
        <P>试卷难度选择： <select class="form-control" name="grade">
            <option value="1">简单</option>
            <option value="2">一般</option>
            <option value="3">困难</option>
        </select></P>
        <button type="submit" class="btn btn-default">随机生成</button>
    </form>
    <br>
    ${mg}
</div>

</body>
</html>
