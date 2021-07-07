<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import = "pindorama.utils.enums.UserType" %>
<html>

<head>
    <title>First Web Application</title>

    <!-- favincon  -->
    <link rel="apple-touch-icon" sizes="180x180" href="../favicon/apple-touch-icon.png">
    <link rel="icon" type="image/png" sizes="32x32" href="../favicon/favicon-32x32.png">
    <link rel="icon" href="../favicon/favicon.ico" type="image/x-icon"/>
    <link rel="shortcut icon" href="../favicon/favicon.ico" type="image/x-icon"/>
    <link rel="manifest" href="../favicon/site.webmanifest">
    <link rel="mask-icon" href="../favicon/safari-pinned-tab.svg" color="#5bbad5">

</head>

<body>

<nav>

</nav>


<div><span style="color: #00c6ff; display: block; text-align: center; font-family: Poppins-Bold;">Hello</span></div>


<img src="/api/v1/getPicture?email=${user.email}" width="300px" height="300px">

<div>

</body>

</html>