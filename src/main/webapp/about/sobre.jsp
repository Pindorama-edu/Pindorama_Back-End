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

    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet"
          id="bootstrap-css">

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
    <link rel="stylesheet" href="../materias/materias.css">
    <link rel="stylesheet" href="../about/sobre.css">
</head>

<body id="body-pd">
<header class="header" id="header">
    <div class="header_toggle"><i class='bx bx-menu' id="header-toggle"></i></div>
</header>
<div class="l-navbar" id="nav-bar">
    <nav class="nav">
        <div>
            <a href="/" class="nav_logo"> <i class='bx bx-layer nav_logo-icon'></i> <span
                    class="nav_logo-name">Pindorama</span> </a>
            <div class="nav_list"><a href="/materias" class="nav_link">
                <i class='bx bx-grid-alt nav_icon'></i>
                <span class="nav_name">Matérias</span>
            </a>
                <c:url value="/perfil?id=${user.id}" var="perfil"/>
                <a href="${perfil}" class="nav_link">
                    <i class='bx bx-user nav_icon'></i>
                    <span class="nav_name">Perfil</span>
                </a>
                <a href="#" class="nav_link" hidden>
                    <i class='bx bx-message-square-detail nav_icon'></i>
                    <span class="nav_name">Forum</span>
                </a> <a href="/sobre" class="nav_link active">
                    <i class='bx bx-bookmark nav_icon'></i>
                    <span class="nav_name">Sobre</span>
                </a>
            </div>
        </div>
        <a href="/logout" class="nav_link">
            <i class='bx bx-log-out nav_icon'></i>
            <span class="nav_name">Sair</span>
        </a>
    </nav>
</div>
<!------ Include the above in your HEAD tag ---------->
<img class="logo-pindoroma" src="../Images/logo.png">
<h1 class="text-center">Sobre</h1>

<p class="aboutText">
    Esta é a nossa plataforma PINDORAMA. Aqui você irá se deparar com diversos assuntos, por exemplo: vídeo aulas,
    materiais em pdf, gráficos de comparação, entre outros. Explore abaixo alguns dos tópicos que nosso site proporciona
    de maneira totalmente gratuita
</p>

<div class="container">
    <div class="row">

        <!--team-1-->
        <div class="col-lg-4">
            <div class="our-team-main">

                <div class="team-front">
                    <img src="../Images/sobre/humanas.jpg" class="img-fluid"/>
                    <h3>Humanas</h3>
                    <p>Web Designer</p>
                </div>

                <div class="team-back">
                        <span>
                            Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor.
                            Aenean massa. Cum sociis
                            natoque penatibus et magnis dis parturient montes,
                            Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor.
                            Aenean massa. Cum sociis
                            natoque.
                        </span>
                </div>

            </div>
        </div>
        <!--team-1-->

        <!--team-2-->
        <div class="col-lg-4">
            <div class="our-team-main">

                <div class="team-front">
                    <img src="../Images/sobre/linguagens.jpg" class="img-fluid"/>
                    <h3>Linguagens</h3>
                    <p>Web Designer</p>
                </div>

                <div class="team-back">
                        <span>
                            Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor.
                            Aenean massa. Cum sociis
                            natoque penatibus et magnis dis parturient montes,
                            Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor.
                            Aenean massa. Cum sociis
                            natoque.
                        </span>
                </div>

            </div>
        </div>
        <!--team-2-->

        <!--team-3-->
        <div class="col-lg-4">
            <div class="our-team-main">

                <div class="team-front">
                    <img src="../Images/sobre/matematica.jpg" class="img-fluid"/>
                    <h3>Matematica</h3>
                    <p>Web Designer</p>
                </div>

                <div class="team-back">
                        <span>
                            Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor.
                            Aenean massa. Cum sociis
                            natoque penatibus et magnis dis parturient montes,
                            Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor.
                            Aenean massa. Cum sociis
                            natoque.
                        </span>
                </div>

            </div>
        </div>
        <!--team-3-->

        <!--team-4-->
        <div class="col-lg-4">
            <div class="our-team-main">

                <div class="team-front">
                    <img src="../Images/sobre/natureza.jpg" class="img-fluid"/>
                    <h3>Natureza</h3>
                    <p>Web Designer</p>
                </div>

                <div class="team-back">
                        <span>
                            Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor.
                            Aenean massa. Cum sociis
                            natoque penatibus et magnis dis parturient montes,
                            Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor.
                            Aenean massa. Cum sociis
                            natoque.
                        </span>
                </div>

            </div>
        </div>
        <!--team-4-->

        <!--team-5-->
        <div class="col-lg-4">
            <div class="our-team-main">

                <div class="team-front">
                    <img src="../Images/sobre/programacao.jpg" class="img-fluid"/>
                    <h3>Programação</h3>
                    <p>Web Designer</p>
                </div>

                <div class="team-back">
                        <span>
                            Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor.
                            Aenean massa. Cum sociis
                            natoque penatibus et magnis dis parturient montes,
                            Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor.
                            Aenean massa. Cum sociis
                            natoque.
                        </span>
                </div>

            </div>
        </div>
        <!--team-5-->

        <!--team-6-->
        <div class="col-lg-4">
            <div class="our-team-main">

                <div class="team-front">
                    <img src="../Images/sobre/tecnologia.jpg" class="img-fluid"/>
                    <h3>Tecnologia</h3>
                    <p>Web Designer</p>
                </div>

                <div class="team-back">
                        <span>
                            Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor.
                            Aenean massa. Cum sociis
                            natoque penatibus et magnis dis parturient montes,
                            Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor.
                            Aenean massa. Cum sociis
                            natoque.
                        </span>
                </div>

            </div>
        </div>
        <!--team-6-->
    </div>
</div>

<div id="social">
    <a id="instagram" href="https://www.instagram.com/pindorama.edu_/" target="_blank"><img
            src="../Images/Icons/instagram.png"/></a>
    <a id="email" href="mailto:ajuda@pindorama.com.br"><img src="../Images/Icons/e-mail.png"></a>
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
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
</body>

</html>