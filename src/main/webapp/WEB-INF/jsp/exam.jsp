<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>省级初中信息技术结业在线考试系统 - 考试</title>
</head>
<body>
    <p><%=request.getAttribute("choice") %></p>
    <p><%=request.getAttribute("trueFalse") %></p>
    <p><%=request.getAttribute("shortAnswer") %></p>
</body>
</html>
