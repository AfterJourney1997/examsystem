<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.examSystem.entity.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% Teacher teacher=(Teacher) session.getAttribute("user");%>
%>
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
    <br>
    <tr valign="top">
        <td width="20%">
            <%@include file="teacherleft.jspf" %>
        </td>
        <td align="center">
            学生：${answer.SName}&emsp;&emsp;学号：${answer.SAccount}
           <table border="1">

                       <tr>
               <td>序号</td><td>选择题</td><td>选项一</td><td>选项二</td><td>选项三</td><td>选项四</td><td>答案</td>
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
                   <td>判断题编号</td><td>问题</td><td></td><td></td><td></td><td></td><td>答案</td>
               </tr>
               <c:forEach var="trueFalse" items="${listTrueFalse}" varStatus="status">
                   <tr>
                       <td>${status.count}</td>
                       <td>${trueFalse.tfqContent}</td>
                       <td></td>
                       <td></td>
                       <td></td>
                       <td></td>
                       <td>${trueFalse.tfqCorrect}</td>
                   </tr>
               </c:forEach>
               <tr>
                   <td>简答题编号</td><td>问题</td><td></td><td></td><td></td><td></td><td>答案</td>
               </tr>
               <c:forEach var="shortanswer" items="${listShort}" varStatus="status">
                   <tr>
                       <td>${status.count}</td>
                       <td>${shortanswer.saqContent}</td>
                       <td></td>
                       <td></td>
                       <td></td>
                       <td></td>
                       <td>${shortanswer.saqCorrect}</td>
                   </tr>
               </c:forEach>
           </table>
            <br>
            <br>
        </td>
        <td align="left">
            <br>
            <table border="1">
                <tr>
                    <td>学生答案选择题</td>
                </tr>
                <c:forEach items="${choiceArray}" var="resultChioce" >
                    <tr>
                        <td>${resultChioce}</td>
                    </tr>
                </c:forEach>
                <tr>
                    <td>学生答案判断题</td>
                </tr>
                <c:forEach items="${truefalseArray}" var="resultTrueFalse" >
                    <tr>
                        <td>${resultTrueFalse}</td>
                    </tr>
                </c:forEach>
                <tr>
                    <td>学生答案简答题</td>
                </tr>
                <c:forEach items="${shortAnswerArray}" var="resultShort" >
                    <tr>
                        <td>${resultShort}</td>
                    </tr>
                </c:forEach>
            </table>
        </td>
        <td align="left">
            <br>
            <table border="1">
                <tr><td>选择题得分</td></tr>
                <c:forEach items="${gradeArarry}" var="grade" begin="1" end="15">
                    <tr><td>${grade}</td></tr>
                </c:forEach>
                <tr><td>判断题得分</td></tr>
                <c:forEach items="${gradeArarry}" var="grade" begin="15" end="30">
                    <tr><td>${grade}</td></tr>
                </c:forEach>
                <tr><td>简答批改</td></tr>
                <form action="/examsystem/addgrade">
                <tr><td>
                    <select name="grade1">
                        <option value ="0">0</option>
                        <option value ="4">4</option>
                        <option value="8">8</option>
                        <option value="12">12</option>
                        <option value="16">16</option>
                        <option value="20">20</option>
                    </select>
                </td>
                </tr>
                <tr>
                    <td>
                    <select name="grade2">
                        <option value ="0">0</option>
                        <option value ="4">4</option>
                        <option value="8">8</option>
                        <option value="12">12</option>
                        <option value="16">16</option>
                        <option value="20">20</option>
                    </select>
                    </td>
                </tr>
                    <input type="text" name="ansId" style="display:none" value="${answer.answerId}"/>
                    <button type="submit">提交</button>
                </form>
            </table>
        </td>

    </tr>
</table>
</body>
</html>
