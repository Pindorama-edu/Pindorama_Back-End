<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html lang="pt-br" style="height: 100%;">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pindorama</title>

    <link rel="apple-touch-icon" sizes="180x180" href="../favicon/apple-touch-icon.png">
    <link rel="icon" type="image/png" sizes="32x32" href="../favicon/favicon-32x32.png">
    <link rel="icon" href="../favicon/favicon.ico" type="image/x-icon"/>
    <link rel="shortcut icon" href="../favicon/favicon.ico" type="image/x-icon"/>
    <link rel="manifest" href="../favicon/site.webmanifest">
    <link rel="mask-icon" href="../favicon/safari-pinned-tab.svg" color="#5bbad5">
    <meta name="msapplication-TileColor" content="#da532c">
    <meta name="theme-color" content="#ffffff">

    <!-- Bootstrap -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css">
    <link rel="text/javascript"
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css">

    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.11.2/css/all.css"/>
    <!-- Style.css -->


    <script type=" text/javascript " src="https://www.amcharts.com/lib/3/amcharts.js "></script>
    <script type="text/javascript " src="https://www.amcharts.com/lib/3/serial.js "></script>
    <!--Perfil-->

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="../materias/materias.css">
</head>


<body id="body-pd">
<header class="header" id="header">
    <div class="header_toggle"><i class='bx bx-menu' id="header-toggle"></i></div>

</header>
<div class="l-navbar" id="nav-bar">
    <c:url value="/perfil?id=${user.id}" var="perfil"/>
    <nav class="nav">
        <div>  <a href="/" class="nav_logo"> <img class="logo" src="https://cdn.discordapp.com/attachments/837713299763363880/864523395621978132/logoSemFundo.png"> <span class="nav_logo-name">Pindorama</span>
        </a>

            <div class="nav_list"><a href="/materias" class="nav_link active"> <i class='bx bx-grid-alt nav_icon'></i>
                <span class="nav_name">Matérias</span> </a> <a href="${perfil}" class="nav_link"> <i
                    class='bx bx-user nav_icon'></i> <span class="nav_name">Perfil</span> </a>
                <a href="/sobre" class="nav_link">
                    <i class='bx bx-bookmark nav_icon'></i>
                    <span class="nav_name">Sobre</span>
                </a>
            </div>
        </div>
        <a href="/logout" class="nav_link"> <i class='bx bx-log-out nav_icon'></i> <span class="nav_name">Sair</span>
        </a>
    </nav>
</div>
<!--Container Main start-->
<div class="height-100 bg-light">
</div>
<!--Container Main end-->
<!--Tela de matérias-->
<div class="bodyMaterias">
</div>
</div>
</div>
<footer class="rodape">
    <p>Copyright © 2021 Pindorama.edu</p>
    <p><a href="mailto:hege@example.com">hege@example.com</a></p>
</footer>


<!--JavaScript-->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js "
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj "
        crossorigin="anonymous "></script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js "
        integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns "
        crossorigin="anonymous "></script>

<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="../materias/materias.js"></script>
<script src="../internal/scripts/aulas.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"></script>
</body>


</html>