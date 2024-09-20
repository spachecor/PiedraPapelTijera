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
    <!--Estilos y funcionalidad personalizado-->
    <link rel="stylesheet" href="css/game.css">
    <script src="js/game.js" defer></script>
</head>
<body>
	<div class="vidas">
        <div class="nombres">
            <p><s:property value="#session.player1"/></p>
            <p><s:property value="#session.player2"/></p>
        </div>
        <div class="barra-vida">
            <img src="img/barracompleta.PNG" alt="" height="20px">
            <img src="img/ko.jpg" alt="" width="50px">
            <img src="img/barracompleta.PNG" alt="" height="20px">
        </div>
        <div class="tiempo">
            <p>00</p>
        </div>
    </div>
    <div class="juego">
        <div class="botones">
            <img src="img/gatopuño-gatito.png" alt="Piedra" width="100px">
            <img src="img/gatopapel.jpg" alt="Papel" width="100px">
            <img src="img/tijeras.jpg" alt="Tijeras" width="100px">
        </div>
        <div class="jugador">
            <img src="img/peleaestaticaizda.jpg" alt="" width="250px">
        </div>
        <div class="jugador">
            <img src="img/peleaestaticadcha.jpg" alt="" width="250px">
        </div>
        <div class="botones">
            <img src="img/gatopuño-gatito.png" alt="Piedra" width="100px">
            <img src="img/gatopapel.jpg" alt="Papel" width="100px">
            <img src="img/tijeras.jpg" alt="Tijeras" width="100px">
        </div>
    </div>
</body>
</html>