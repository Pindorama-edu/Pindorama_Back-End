<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="pt-br">

<head>
    <title>Pindorama</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--===============================================================================================-->
    <link rel="icon" type="image/png" href="images/icons/favicon.ico" />
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="../login/vendor/bootstrap/css/bootstrap.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="../login/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="../login/vendor/animate/animate.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="../login/vendor/css-hamburgers/hamburgers.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="../login/vendor/select2/select2.min.css">.
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="../login/css/util.css">
    <link rel="stylesheet" type="text/css" href="../login/css/main.css">
    <!--===============================================================================================-->
    <!--Bootstrap do menu -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.11.2/css/all.css" />
    <link rel="stylesheet" href="../style.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
</head>

<body>
    <main>
        <nav class="navbar navbar-expand-lg navbar-mainbg">
            <!-- Logo -->
            <a class="navbar-brand navbar-logo navbar" href="../prin.jsp">Pindorama.edu</a>
        </nav>
    </main>

    <div class="limiter">
        <div class="container-login100">
            <div class="wrap-login100">
                <div class="login100-pic js-tilt" data-tilt>
                    <img src="images/img-01.png" alt="IMG">
                </div>

                <form class="login100-form validate-form">
                    <span class="login100-form-title">
								Login
							</span>

                    <div class="wrap-input100 validate-input" data-validate="Valid email is
								required: ex@abc.xyz">
                        <input class="input100" type="email" name="email" placeholder="Email" required>
                        <span class="focus-input100"></span>
                        <span class="symbol-input100">
									<i class="fa fa-envelope" aria-hidden="true"></i>
								</span>
                    </div>

                    <div class="wrap-input100 validate-input" data-validate="Password is
								required">
                        <input class="input100" type="password" name="pass" placeholder="Senha" required>
                        <span class="focus-input100"></span>
                        <span class="symbol-input100">
									<i class="fa fa-lock" aria-hidden="true"></i>
								</span>
                    </div>

                    <div class="container-login100-form-btn">
                        <button class="login100-form-btn">
									Entrar
								</button>
                    </div>


                    <!---------------------------------------------------------------------------------------------------------------------------------------->
                    <div class="contai m-5">
                        <div class="row justify-content-around">
                            <div class="col-2 row justify-content-center ">

                                <a href="https://github.com/Felipe-ASouza" target="_blank" class="log-buttons"><img src="gitblue.png" alt=""></a>

                            </div>
                            <div class="col-2 row justify-content-center">
                                <a href="https://www.linkedin.com/in/felipe-asouza/" target="_blank" class="log-buttons"><img src="google.png" alt=""></a>
                            </div>
                            <div class="col-2 row justify-content-center">
                                <a href="https://www.instagram.com/felipe.alexandre38/" target="_blank" class="log-buttons"><img src="facebook.png" alt=""></a>
                            </div>
                        </div>

                    </div><br>


                    <div class="text-center p-t-12">
                        <span class="txt1">
									Esqueceu
								</span>
                        <a class="txt2" href="#">
									Usuário / Senha?
								</a>
                    </div>

                    <div class="text-center p-t-136">
                        <a class="txt2" href="#">
									Registre-se
									<i class="fa fa-long-arrow-right m-l-5" aria-hidden="true"></i>
								</a>

                    </div>
                </form>
            </div>
        </div>
    </div>
    <!--===============================================================================================-->
    <script src="../login/vendor/jquery/jquery-3.2.1.min.js"></script>
    <!--===============================================================================================-->
    <script src="../login/vendor/bootstrap/js/popper.js"></script>

    <script src="../login/vendor/bootstrap/js/bootstrap.min.js"></script>
    <!--===============================================================================================-->
    <script src="../login/vendor/select2/select2.min.js"></script>
    <!--===============================================================================================-->
    <script src="../login/vendor/tilt/tilt.jquery.min.js"></script>
    <script>
        $('.js-tilt').tilt({
            scale: 1.1
        })
    </script>
    <!--===============================================================================================-->
    <script src="./js/main.js"></script>

</body>

</html>
