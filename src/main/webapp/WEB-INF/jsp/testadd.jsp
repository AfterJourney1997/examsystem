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
    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
    <title>省级初中信息技术结业在线考试系统 - 添加试卷</title>
</head>
<style>
    body {
        padding-top: 50px;
        padding-left: 221px;
    }
    .main {
        padding: 20px;
    }
    @media (min-width: 768px) {
        .main {
            padding-right: 40px;
            padding-left: 40px;
        }
    }
    .main {
        margin-top: 0;
    }
</style>
<body>
<%@include file="head.jsp"%>
<%@include file="leaf.jsp"%>

<div class="main">
    <form class="form-inline" action="${pageContext.request.contextPath}/addtest">
        <button type="submit" class="btn btn-default">随机生成</button>
    </form>
    <br>
    ${mg}
</div>

</body>
</html>
