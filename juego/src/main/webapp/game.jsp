<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>¡Piedra, Papel o Tijera!</title>
    <link rel="shortcut icon" href="img/logo.png">
    <!--jquery-->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <!-- Fuente -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Jacquarda+Bastarda+9&display=swap" rel="stylesheet">
    <!--Estilos y funcionalidad personalizado-->
    <link rel="stylesheet" href="css/game.css">
    <script src="js/game.js" defer></script>
</head>
<body>
    <div class="nombres">
        <p class="jacquarda-bastarda-9-regular">
            <b><s:property value="#session.player1" /></b>
        </p>
        <p class="jacquarda-bastarda-9-regular">
            <b><s:property value="#session.player2" /></b>
        </p>
    </div>
    <div class="barra-vida">
        <img src="img/vida/barra_izq1-4.png" height="30px">
        <img src="img/vida/ko-inicio.png" width="70px">
        <img src="img/vida/barra_der1-4.png" height="30px">
    </div>
    <div class="tiempo">
        <img src="img/vida/tiempo.gif" id="temporizador" height="30px">
    </div>
    <div class="juego">
        <div class="botones1">
            <img src="img/botones/piedra-f.png" id="piedra1" alt="Piedra" width="75px">
            <img src="img/botones/papel-f.png" id="papel1" alt="Papel" width="75px">
            <img src="img/botones/tijeras-f.png" id="tijera1" alt="Tijeras" width="75px">
        </div>

        <div class="botones2">
            <img src="img/botones/piedra-f-des.png" id="piedra2" alt="Piedra" width="75px">
            <img src="img/botones/papel-f-des.png" id="papel2" alt="Papel" width="75px">
            <img src="img/botones/tijeras-f-des.png" id="tijera2" alt="Tijeras" width="75px">
        </div>

        <div class="jugador1">
            <img src="img/movimientos/ryu-parado.gif" width="500px">
        </div>
        <div class="jugador2">
            <img src="img/movimientos/ken-parado.gif" width="500px">
        </div>
    </div>
</body>
</html>