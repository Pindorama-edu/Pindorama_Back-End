<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">

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

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
          integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.11.2/css/all.css"/>
    <!-- Style.css -->


    <script type=" text/javascript " src="https://www.amcharts.com/lib/3/amcharts.js "></script>
    <script type="text/javascript " src="https://www.amcharts.com/lib/3/serial.js "></script>
    <!--Perfil-->


    <link rel="stylesheet" href="../materias/materias.css">
</head>


<body>
<div class="row">

    <div class="col-12 col-md-8 con">
        <div class="nav-a">
            <img src="../Hamburger_icon.svg.png" width="50" height="50" alt="" class="ham" id="ham">

            <span style="text-align: center;">Bem vindo ${user != null ? user.username : ''}</span>
        </div>


        <div class="w-100 h-100 menu-exit" id="screen" style="display:none"></div>
        <!--Tela de matérias-->
        <div class="bodyMaterias">
            <div class="titulo">
                <strong class="nomeMateria">
                    <header>
                        <h1>Matérias</h1>
                    </header>
                    <div class="iconeMaterias d-flex">
                        Tecnologia

                    </div>
                </strong>
            </div>
            <div class="d-flex" style="gap: 20px; padding: 10px">
                <a class="modlink1 card d-flex flex-column justify-content-between" href="#Quimica">
                        <span class="card d-flex flex-column justify-content-between">
        
                            <span class="body">
                                Body
                            </span>
                        <span class="modulosQuimica">
                                <p>24 módulos</p>
        
                            </span>
                        <span class="footer1" href="/materias/1/modulos">
                                Ver Módulos
                            </span>
                        </span>
                </a>
                <a class="modlink1 card d-flex flex-column justify-content-between" href="#">
                        <span class="card d-flex flex-column justify-content-between">
        
                            <span class="body">
                                Body
                            </span>
                        <span class="modulosQuimica">
                                <p>24 módulos</p>
        
                            </span>
                        <span class="footer1" href="/materias/1/modulos">
                                Ver Módulos
                            </span>
                        </span>
                </a>
            </div>
            <!--Segunda tela de matérias-->
            <div class="titulo">
                <strong class="nomeMateria">
                    <div class="iconeMaterias2 d-flex">
                        Ciências da Natureza

                    </div>
                </strong>
            </div>

            <div class="d-flex" style="gap: 20px; padding: 10px">
                <a class="modlink2 card d-flex flex-column justify-content-between" href="#Quimica">
                        <span class="card d-flex flex-column justify-content-between">
        
                            <span class="body">
                                Body
                            </span>
                        <span class="modulosQuimica">
                                <p>24 módulos</p>
        
                            </span>
                        <span class="footer2" href="/materias/1/modulos">
                                Ver Módulos
                            </span>
                        </span>
                </a>
                <a class="modlink2 card d-flex flex-column justify-content-between" href="#">
                        <span class="card d-flex flex-column justify-content-between">
        
                            <span class="body">
                                Body
                            </span>
                        <span class="modulosQuimica">
                                <p>24 módulos</p>
        
                            </span>
                        <span class="footer2" href="/materias/1/modulos">
                                Ver Módulos
                            </span>
                        </span>
                </a>
            </div>
            <!--Terceira tela de materias-->
            <div class="titulo">
                <strong class="nomeMateria">
                    <div class="iconeMaterias3 d-flex">
                        Ciências humanas
                    </div>
                </strong>
            </div>
            <div class="d-flex" style="gap: 20px; padding: 10px">
                <a class="modlink3 card d-flex flex-column justify-content-between" href="#Quimica">
                        <span class="card d-flex flex-column justify-content-between">
                            <span class="body">
                                Body
                            </span>
                        <span class="modulosQuimica">
                                <p>24 módulos</p>
        
                            </span>
                        <span class="footer3" href="/materias/1/modulos">
                                Ver Módulos
                            </span>
                        </span>
                </a>
                <a class="modlink3 card d-flex flex-column justify-content-between" href="#">
                        <span class="card d-flex flex-column justify-content-between">
                            <span class="body">
                                Body
                            </span>
                        <span class="modulosQuimica">
                                <p>24 módulos</p>
        
                            </span>
                        <span class="footer3" href="/materias/1/modulos">
                                Ver Módulos
                            </span>
                        </span>
                </a>
            </div>
            <!--Quarta tela de materias-->
            <div class="titulo">
                <strong class="nomeMateria">
                    <div class="iconeMaterias4 d-flex">
                        Linguagens
                    </div>
                </strong>
            </div>

            <div class="d-flex" style="gap: 20px; padding: 10px">
                <a class="modlink4 card d-flex flex-column justify-content-between" href="#Quimica">
                        <span class="card d-flex flex-column justify-content-between">
        
                            <span class="body">
                                Body
                            </span>
                        <span class="modulosQuimica">
                                <p>24 módulos</p>
        
                            </span>
                        <span class="footer4" href="/materias/1/modulos">
                                Ver Módulos
                            </span>
                        </span>
                </a>
                <a class="modlink4 card d-flex flex-column justify-content-between" href="#">
                        <span class="card d-flex flex-column justify-content-between">
        
                            <span class="body">
                                Body
                            </span>
                        <span class="modulosQuimica">
                                <p>24 módulos</p>
        
                            </span>
                        <span class="footer4" href="/materias/1/modulos">
                                Ver Módulos
                            </span>
                        </span>
                </a>
                <!--Quinta telade materias-->
            </div>
            <div class="titulo">
                <strong class="nomeMateria">
                    <div class="iconeMaterias5 d-flex">
                        Matemática
                    </div>
                </strong>
            </div>

            <div class="d-flex" style="gap: 20px; padding: 10px">
                <a class="modlink5 card d-flex flex-column justify-content-between" href="#Quimica">
                        <span class="card d-flex flex-column justify-content-between">
        
                            <span class="body">
                                Body
                            </span>
                        <span class="modulosQuimica">
                                <p>24 módulos</p>
        
                            </span>
                        <span class="footer5" href="/materias/1/modulos">
                                Ver Módulos
                            </span>
                        </span>
                </a>
                <a class="modlink5 card d-flex flex-column justify-content-between" href="#">
                        <span class="card d-flex flex-column justify-content-between">
        
                            <span class="body">
                                Body
                            </span>
                        <span class="modulosQuimica">
                                <p>24 módulos</p>
        
                            </span>
                        <span class="footer5" href="/materias/1/modulos">
                                Ver Módulos
                            </span>
                        </span>
                </a>
            </div>
        </div>
    </div>
</div>


<!--JavaScript-->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js "
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj "
        crossorigin="anonymous "></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js "
        integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns "
        crossorigin="anonymous "></script>
<script src="../materias/materias.js"></script>
</body>


</html>