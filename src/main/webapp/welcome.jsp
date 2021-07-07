<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>

<head>
    <title>First Web Application</title>

        <!--  favicon  -->
    <link rel="apple-touch-icon" sizes="180x180" href="./favicon/apple-touch-icon.png">
    <link rel="icon" type="image/png" sizes="32x32" href="./favicon/favicon-32x32.png">
    <link rel="icon" href="./favicon/favicon.ico" type="image/x-icon"/>
    <link rel="shortcut icon" href="./favicon/favicon.ico" type="image/x-icon"/>
    <link rel="manifest" href="./favicon/site.webmanifest">
    <link rel="mask-icon" href="./favicon/safari-pinned-tab.svg" color="#5bbad5">
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