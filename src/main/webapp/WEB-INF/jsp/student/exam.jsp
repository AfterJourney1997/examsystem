<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
    <title>省级初中信息技术结业在线考试系统 - 考试</title>
</head>
<style type="text/css">
    .back{
        background:#444 url(${pageContext.request.contextPath}/images/a.jpg) no-repeat fixed center center;
        background-size: cover;
        overflow: hidden;
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
        margin-left: auto;
        margin-right: auto;
        width:900px;
    }
    h4{
        text-align:center;
        font-weight:bold;
    }
</style>
<body>
<div class="back">
    <div class="panel panel-danger main">
        <div class="panel-heading">
            <h4>${sessionScope.examInfo.getArrName()}</h4>
        </div>
        <br><br><br>
        <form action="${pageContext.request.contextPath}/student/submit" method="POST">

            <div><h3>一、选择题</h3></div>
            <table class="table table-hover table-striped">
                <c:forEach var="item" items="${requestScope.choice}" varStatus="status">
                    <tr>
                        <td colspan="4">${status.index + 1} ${item.cqContent}</td>
                    </tr>
                    <tr>
                        <td><input type="radio" name="${status.index + 1}" value="A" checked="checked"/>${item.cqA}</td>
                        <td><input type="radio" name="${status.index + 1}" value="B"/>${item.cqB}</td>
                        <td><input type="radio" name="${status.index + 1}" value="C"/>${item.cqC}</td>
                        <td><input type="radio" name="${status.index + 1}" value="D"/>${item.cqD}</td>
                    </tr>
                </c:forEach>
            </table>

            <div><h3>二、判断题</h3></div>
            <table class="table table-hover table-striped">
                <c:forEach var="item" items="${requestScope.trueFalse}" varStatus="status">
                    <tr>
                        <td colspan="2">${status.index + 1} ${item.tfqContent}</td>
                    </tr>
                    <tr>
                        <td><input type="radio" name="${status.index + 1}" value="T" checked="checked"/>正确</td>
                        <td><input type="radio" name="${status.index + 1}" value="F"/>错误</td>
                    </tr>
                </c:forEach>

            </table>
            <div><h3>三、简答题</h3></div>
            <table class="table table-hover table-striped">
                <c:forEach var="item" items="${requestScope.shortAnswer}" varStatus="status">
                    <tr>
                        <td colspan="2">${status.index + 1} ${item.saqContent}</td>
                    </tr>
                    <tr>
                        <td colspan="2"><textarea class="form-control" rows="3" name="${status.index + 1}"></textarea></td>
                    </tr>
                </c:forEach>
            </table>

            <button type="submit" class="btn btn-success">交卷</button>
        </form>
    </div>
</div>
</body>
</html>