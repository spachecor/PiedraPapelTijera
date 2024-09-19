<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>¡Ponle nombre al personaje!</title>
	<!-- jquery -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<!-- Estilo y funcionalidad personalizados -->
    <link rel="stylesheet" href="css/pre-game.css">
    <script src="js/pre-game.js" defer></script>
</head>
<body>
    <div class="columna1">
        <form action="Jugar" method="post">
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
        <button>Salir</button>
    </div>
</body>
</html>