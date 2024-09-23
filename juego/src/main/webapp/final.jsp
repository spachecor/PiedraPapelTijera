<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SinCtrlAltF4</title>
    <link rel="shortcut icon" href="img/logo.png">
    <!-- Estilos y funcionalidad personalizada -->
    <link rel="stylesheet" href="css/final.css">
    <script src="js/final.js" defer></script>
</head>
<body>
    <div class="columna1">
        <form action="Jugar" method="post" id="nombreJugadoresForm">
            <div class="contenedor-filas">
                <div class="fila-jugador">
                    <img src="img/personajes/ryu-win.png" id="player1" alt="player1" width="250px">
                </div>
                <div class="fila">
                    <img src="img/personajes/win-los-1.png" alt="versus" width="250px">
                </div>
                <div class="fila-jugador">
                    <img src="img/personajes/ken-lose.png" id="player2" alt="player2" width="250px">
                </div>
            </div>
            
        </form>
    </div>
    <div class="columna2">
        <form action="Final" method="post">
        	<input type="hidden" name="accion" value="jugar"/>
        	<button class="botones"><img src="img/botones/jugar.png" alt="Piedra" width="100px"></button>
        </form>
        <form action="Final" method="post">
        	<input type="hidden" name="accion" value="salir"/>
            <button class="botones"><img src="img/botones/salir.png" alt="Piedra" width="100px"></button>
        </form>
    </div>
    <input type="hidden" id="nombreGanador" name="nombreGanador" value="<s:property value="#session.nombreGanador" />"/>
</body>
</html>