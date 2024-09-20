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
		<img src="img/gato.jpg" alt="logo de street figther">
    </div>
    <div class="opciones">
        <!--boton de 1vsmachine-->
        <form action="Entrar" method="post">
            <input type="hidden" name="accion" value="1vsMachine"/>
            <button>1vsMachine</button>
        </form>
        <!--boton de 1vs1-->
        <form action="Entrar" method="post">
            <input type="hidden" name="accion" value="1vs1"/>
            <button>1vs1</button>
        </form>
    </div>
    <div class="final">
        <button id="salir">Salir</button>
        <button id="creditos">Creditos</button>
    </div>
</body>
</html>