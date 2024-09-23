<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SinCtrlAltF4</title>
    <link rel="shortcut icon" href="img/logo.png">
    <!-- jquery -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <!-- sweetalert -->
	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
	<link href="https://cdn.jsdelivr.net/npm/@sweetalert2/theme-dark/dark.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11/dist/sweetalert2.min.js"></script>
    <!-- Estilos y funcionalidad personalizada -->
    <link rel="stylesheet" href="css/index.css">
    <script src="js/index.js" defer></script>
</head>
<body>
	<div class="logo">
		<img src="img/logo/logo.png" alt="logo de street figther" width="500px">
    </div>
    <div class="opciones">
        <!--boton de 1vsmachine-->
        <form action="Entrar" method="post">
            <input type="hidden" name="accion" value="1vsMachine"/>
            <button class="botones"><img src="img/botones/1vscom.png" alt="Piedra" width="200px"></button>
        </form>
        <!--boton de 1vs1-->
        <form action="Entrar" method="post">
            <input type="hidden" name="accion" value="1vs1"/>
            <button class="botones"><img src="img/botones/1vs2.png" alt="Piedra" width="200px"></button>
        </form>
    </div>
    <div class="final">
        <button class="botones2" id="salir"><img src="img/botones/salir.png" alt="Piedra" width="75px"></button>
        <button class="botones3" id="creditos"><img src="img/botones/creditos.png" alt="Piedra" width="75px"></button>
    </div>
</body>
</html>