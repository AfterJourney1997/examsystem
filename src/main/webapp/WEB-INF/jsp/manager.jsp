<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>省级初中信息技术结业在线考试系统 - 管理员页面</title>
</head>
<body>
<h1>Hello Manager！</h1>
<p><%=session.getAttribute("user") %></p>
<p><%=session.getAttribute("school") %></p>
</body>
</html>
