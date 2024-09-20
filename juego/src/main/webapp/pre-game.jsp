<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>¡Ponle nombre al personaje!</title>
    <link rel="shortcut icon" href="img/logo.png">
	<!-- bootstrap -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
	<!-- jquery -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<!-- sweetalert -->
	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
	<link href="https://cdn.jsdelivr.net/npm/@sweetalert2/theme-dark/dark.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11/dist/sweetalert2.min.js"></script>
	<!-- Estilo y funcionalidad personalizados -->
    <link rel="stylesheet" href="css/pre-game.css">
    <script src="js/pre-game.js" defer></script>
</head>
<body>
    <div class="columna1">
        <form action="Jugar" method="post" id="nombreJugadoresForm">
            <div class="contenedor-filas">
                <div class="fila-jugador">
                    <img src="img/gatito1.jpg" alt="player1" width="250px">
                    <input type="text" name="player1" id="player1">
                </div>
                <div class="fila">
                    <img src="img/versus.jpg" alt="versus" width="250px">
                </div>
                <div class="fila-jugador">
                    <img src="img/gatito2.jpg" alt="player2" width="250px">
                    <input type="text" name="player2" id="player2">
                </div>
            </div>
            <button>¡¡Jugar!!</button>
        </form>
    </div>
    <div class="columna2">
        <form action="Jugar" method="post">
        	<input type="hidden" name="accion" value="salir"/>
        	<button>Salir</button>
        </form>
    </div>
    <input type="hidden" id="opcionJuego" name="opcionJuego" value="<s:property value="#session.opcionJuego"/>"/>
</body>
</html>