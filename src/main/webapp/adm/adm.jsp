<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import = "pindorama.utils.enums.UserType" %>
<html>

<head>
    <title>First Web Application</title>
</head>

<body>

<nav>

</nav>

<div><span style="color: red; display: block; text-align: center; font-family: Poppins-Bold;">Hello</span></div>


</body>

<img src="/api/v1/getPic?email=${user.email}" >

</html>