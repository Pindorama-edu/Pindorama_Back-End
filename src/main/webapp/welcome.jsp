<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>

<head>
    <title>First Web Application</title>
</head>
<c:if test="${user == null}">
    <%Thread.sleep(2000);%>
    <c:redirect url="/"/>
</c:if>

<%Thread.sleep(2000);%>
<body>
Welcome ${user.username}!! <a href="/api/v1/redirect/adm">Click here</a> to manage your todo's.
</body>

</html>