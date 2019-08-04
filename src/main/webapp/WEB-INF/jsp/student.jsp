<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>省级初中信息技术结业在线考试系统 - 学生页面</title>
</head>
<body>
    <h1>hello student！</h1>
    <p><%=session.getAttribute("user") %></p>
    <p><%=session.getAttribute("school") %></p>
    <p><%=request.getAttribute("exam") %></p>
    <p><%=request.getAttribute("result") %></p>
    <a href="<%=request.getContextPath() %>/student/examInfo">
        <button>考试查询</button>
    </a><br>
    <a href="<%=request.getContextPath() %>/student/result">
        <button>成绩查询</button>
    </a><br>
</body>
</html>
