<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.examSystem.entity.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<% Teacher teacher=(Teacher) session.getAttribute("user");%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <style>
        *{
            margin:0;
            padding:0;
        }
        ul,li{
            list-style: none;
        }
        .closed{
            display: block;
            width: 200px;
            background-color: coral;
        }
        #manager ul li{
            width: 200px;
            line-height: 30px;
            text-align: center;
            cursor: pointer;
        }
        .hide{
            display: none;
        }
        .show{
            display: block;
        }
        .open{
            display: block;
            background-color: coral;
        }
        .hide{
            display: none;
        }
        #manager ul li.pro{
            border:1px solid #fff;
        }
        #manager ul li ul li{
            padding:3px 0;
            border: 0;
            color:lightgray;
            line-height: 20px;
            border-top:1px solid #fff;
            background-color: darkorchid;
        }
        #manager ul li ul li:hover{
            color: #fff;
        }
        #manager ul li ul li:last-child{
            border-bottom:1px solid #fff;
        }
    </style>
    <title>TeacherHome</title>
</head>
<script src="js/jquery-3.2.1.min.js"></script>
<script>
    function toggleTable(span){
//            如果span的class为open
        if(span.className=="open"){
//                将span的class设为closed
            span.className="closed";
//                将span的下一个兄弟元素的class改为hide
            span.nextElementSibling.className="hide";
        }else{//否则
//                查找class为tree的元素下的一个class为open的span,保存在open中
            var open=document.querySelector("[class=tree] span[class=open]");
            if(open!=null){
//                    设置open的class为closed
                open.className="closed";
//                    设置open的下一个兄弟元素的class为hide
                open.nextElementSibling.className="hide";
            }
            span.className="open";
            span.nextElementSibling.className="show";
        }
    }
</script>
<body>
<table>
    <tr>
        <td colspan="2" align="right">欢迎<%=teacher.getTName()%>老师</td>
    </tr>
    <tr valign="top">
        <td width="20%">
            <%@include file="teacherleft.jspf" %>
        </td>
        <td align="center">
            试卷编号：${test.testId} <button type="button"><a href="/examsystem/testdel">取消删除</a></button>
            <table border="1">
                <tr>
                    <td>选择题编号</td><td>问题</td><td>选项一</td><td>选项二</td><td>选项三</td><td>选项四</td><td>答案</td>
                    <td style="vertical-align:middle;text-align:center;">
                        <form action="/examsystem/deltest">
                       删除试卷编号为： <input name="testId" type="text" readonly="readonly" value="${test.testId}"/><br>
                        <button type="submit" >删除 </button>
                    </form>
                    </td>
                </tr>
                <c:forEach var="choice" items="${listChoice}" varStatus="status">
                    <tr>
                        <td>${status.count}</td>
                        <td>${choice.cqContent}</td>
                        <td>${choice.cqA}</td>
                        <td>${choice.cqB}</td>
                        <td>${choice.cqC}</td>
                        <td>${choice.cqD}</td>
                        <td>${choice.cqCorrect}</td>
                    </tr>
                </c:forEach>
                <tr>
                    <td>判断题编号</td><td>问题</td><td>答案</td>
                </tr>
                <c:forEach var="trueFalse" items="${listTrueFalse}" varStatus="status">
                    <tr>
                        <td>${status.count}</td>
                        <td>${trueFalse.tfqContent}</td>
                        <td>${trueFalse.tfqCorrect}</td>
                    </tr>
                </c:forEach>
                <tr>
                    <td>简答题编号</td><td>问题</td><td>答案</td>
                </tr>
                <c:forEach var="shortanswer" items="${listShort}" varStatus="status">
                    <tr>
                        <td>${status.count}</td>
                        <td>${shortanswer.saqContent}</td>
                        <td>${shortanswer.saqCorrect}</td>
                    </tr>
                </c:forEach>
            </table>

        </td>

    </tr>
</table>
</body>
</html>
