<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pindorama</title>
    <link rel="shortcut icon" href="https://genfavicon.com/tmp/icon_efc276fd18c522bfadd69faa1d6853b8.ico"
        type="image/x-icon">

    <!-- Bootstrap -->

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
        integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.11.2/css/all.css" />
    <!-- Style.css -->
    <link rel="stylesheet" href="style.css">

</head>

<body>
    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg navbar-mainbg">
        <!-- Logo -->
        <a class="navbar-brand navbar-logo" href="#">
            <img style="width:25px;height:30px" src="./pindorama_logo.png" alt=""> Pindorama
        </a>
        <!-- Collapse Button -->
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <i class="fas fa-bars text-white"></i>
        </button>
        <!-- Links -->
        <div class="collapse navbar-collapse pl-4" id="navbarSupportedContent">
            <ul class="navbar-nav">
                <!-- For Styling -->
                <div class="hori-selector">
                    <div class="left"></div>
                    <div class="right"></div>
                </div>
                <!-- Nav Links -->
                <li class="nav-item active">
                    <a class="nav-link" href="#Dashboard">
                        <i class="fas fa-home">
                            Início
                        </i>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#Address">
                        <i class="far fa-address-book">
                            Sobre
                        </i>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#Components">
                        <i class="far fa-clone">
                            Matérias
                        </i>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#Calender">
                        <i class="fas fa-chart-pie">
                            Gráficos
                        </i>
                    </a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="#Documents">
                        <i class="fas fa-user-edit">
                            Perfil
                        </i>
                    </a>
                </li>
            </ul>
        </div>
        <div class="row pr-4 cad" style="margin: 0;">

            <div class="col row">
                <a href="#" class="col align-self-center text-white botoes">Cadastrar</a>
            </div>

            <div class="botoes col btn btn-success botoes">
                <a href="login/logue.jsp" type="href" class="text-white">Login</a>
            </div>

        </div>
        </div>
    </nav>

    <!-- Header -->
    <main class="pindorama">
        <div id="mydiv">

            <div class="mydivback w-100 h-100">
                <div class="row align-items-center w-100 h-100 m-0 justify-content-center">

                    <div class="col-6">
                        <img src="./pindorama_img.png" alt="Logo Pindorama" class="img-fluid">
                        <div class="slogan">Conhecimento de todo Brasil<br>reunido em um só portal</div>

                    </div>

                </div>
                <div class="mouse text-light">aassad</div>
            </div>
        </div>


        <header class="mt-5 pt-5">
            <div class="container">
                <div class="row justify-content-center">
                    <!-- Column 1-->
                    <div class="col-md-6">
                        <h1 class="mb-4 font-weight-bold">Bem-vindo ao
                            <span class="text-info">Pindorama,</span><br>o portal educacional gratuito.
                        </h1>
                        <p class="mb-4 pb-2 ">
                            Embarque nesta jornada rumo ao conhecimento!
                        </p>
                        <div>
                            <a href="#contact" class="text-center btn btn-outline-dark btn-lg btn-block">Contato</a>
                        </div>
                    </div>
                    <!-- Column 1 -->


                    <!-- Column 2 -->
                </div>
            </div>
        </header>

    </main>

    <!-- Scripts -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns"
        crossorigin="anonymous"></script>
    <!-- Custom Script -->
    <script src="script.js"></script>

    <!--Quadros -->
    <article>
        <h1 class="text-center">Team Design Section with Pure CSS Effect</h1>


        <div class="container">
            <div class="row">

                <!--team-1-->
                <div class="col-lg-4">
                    <div class="our-team-main">

                        <div class="team-front">
                            <img src="http://placehold.it/110x110/9c27b0/fff?text=Dilip" class="img-fluid" />
                            <h3>Dilip Kevat</h3>
                            <p>Web Designer</p>
                        </div>

                        <div class="team-back">
                            <span>
                                Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget
                                dolor. Aenean massa. Cum sociis
                                natoque penatibus et magnis dis parturient montes,
                                Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget
                                dolor. Aenean massa. Cum sociis
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
                            <img src="http://placehold.it/110x110/336699/fff?text=Dilip" class="img-fluid" />
                            <h3>Dilip Kevat</h3>
                            <p>Web Designer</p>
                        </div>

                        <div class="team-back">
                            <span>
                                Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget
                                dolor. Aenean massa. Cum sociis
                                natoque penatibus et magnis dis parturient montes,
                                Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget
                                dolor. Aenean massa. Cum sociis
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
                            <img src="http://placehold.it/110x110/607d8b/fff?text=Dilip" class="img-fluid" />
                            <h3>Dilip Kevat</h3>
                            <p>Web Designer</p>
                        </div>

                        <div class="team-back">
                            <span>
                                Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget
                                dolor. Aenean massa. Cum sociis
                                natoque penatibus et magnis dis parturient montes,
                                Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget
                                dolor. Aenean massa. Cum sociis
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
                            <img src="http://placehold.it/110x110/4caf50/fff?text=Dilip" class="img-fluid" />
                            <h3>Dilip Kevat</h3>
                            <p>Web Designer</p>
                        </div>

                        <div class="team-back">
                            <span>
                                Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget
                                dolor. Aenean massa. Cum sociis
                                natoque penatibus et magnis dis parturient montes,
                                Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget
                                dolor. Aenean massa. Cum sociis
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
                            <img src="http://placehold.it/110x110/e91e63/fff?text=Dilip" class="img-fluid" />
                            <h3>Dilip Kevat</h3>
                            <p>Web Designer</p>
                        </div>

                        <div class="team-back">
                            <span>
                                Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget
                                dolor. Aenean massa. Cum sociis
                                natoque penatibus et magnis dis parturient montes,
                                Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget
                                dolor. Aenean massa. Cum sociis
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
                            <img src="http://placehold.it/110x110/2196f3/fff?text=Dilip" class="img-fluid" />
                            <h3>Dilip Kevat</h3>
                            <p>Web Designer</p>
                        </div>

                        <div class="team-back">
                            <span>
                                Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget
                                dolor. Aenean massa. Cum sociis
                                natoque penatibus et magnis dis parturient montes,
                                Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget
                                dolor. Aenean massa. Cum sociis
                                natoque.
                            </span>
                        </div>

                    </div>
                </div>
                <!--team-6-->
            </div>
        </div>
    </article>
    <footer>
        <div class="rodape row justify-content-between">

            <hr>
            <div class="footerDisclaimer col text-light p-2">Copyright © 2021 - <span>Pindorama.edu</span></div>
            <div class="footerNote col text-light text-right p-2">John Do - <span>Email me</span></div>
        </div>
    </footer>
</body>

</html>