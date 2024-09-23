//recogemos la opcion del primero
let opciones = [];
let aux = 0;
let auxOpcion = null;
let auxPrimerTurno = true;
let aniadido = false;
$(document).ready(function(){
    //Ajustar el alto al alto de la pantalla
    let height = $(window).height();
    $('body').css('height', height);
	//ajustamos las barras de vida según la vida de los participantes
	switch($('#vidasplayer1').val()){
		case "0":
			$('#vidaIzq').attr('src', 'img/vida/barra_izq4-4.png');
			break;
		case "1":
			$('#vidaIzq').attr('src', 'img/vida/barra_izq3-4.png');
			break;
		case "2":
			$('#vidaIzq').attr('src', 'img/vida/barra_izq2-4.png');
			break;
		case "3":
			$('#vidaIzq').attr('src', 'img/vida/barra_izq1-4.png');
			break;
	}
	switch($('#vidasplayer2').val()){
		case "0":
			$('#vidaDcha').attr('src', 'img/vida/barra_der4-4.png');
			break;
		case "1":
			$('#vidaDcha').attr('src', 'img/vida/barra_der3-4.png');
			break;
		case "2":
			$('#vidaDcha').attr('src', 'img/vida/barra_der2-4.png');
			break;
		case "3":
			$('#vidaDcha').attr('src', 'img/vida/barra_der1-4.png');
			break;
	}
	//solo recogemos la opcion si no estaba añadida
	$(document).keydown(function(e){
		switch(e.which) {
			case 49:
				if(!aniadido){
					auxOpcion = 0;
					aniadido=true;
				}
				break;
			case 50:
				if(!aniadido){
					auxOpcion = 1;
					aniadido=true;
				}
				break;
			case 51:
				if(!aniadido){
					auxOpcion = 2;
					aniadido=true;
				}
				break;
		}
	});
	//comprobamos la opcion del jugador
	comprobarOpcionElegida();

});
/**
 * Función que revisa cada medio segundo si se ha elegido una opcion.
 */
function comprobarOpcionElegida(){
	let intervalo = setInterval(function(){
		//cuando se añade una opcion nueva, se resetea la variable que indica que se ha añadido una nueva opción, se añade y 
		if(aniadido){
			aniadido=false;
			opciones.push(auxOpcion);
			auxOpcion=null;
			opciones.forEach(function(opcion){
				console.log(opcion)
			})
			clearInterval(intervalo);
			finTurno();
		//si no se añade nada, es null
		}else if(aux===30){
			opciones.push(null);
			opciones.forEach(function(opcion){
				console.log(opcion)
			})
			clearInterval(intervalo);
			finTurno();
		}
		aux++;
	}, 500);
}
function finTurno(){
	if(auxPrimerTurno){
		$('#piedra1').attr('src', 'img/botones/piedra-f-des.png');
		$('#papel1').attr('src', 'img/botones/papel-f-des.png');
		$('#tijera1').attr('src', 'img/botones/tijeras-f-des.png');
		
		$('#piedra2').attr('src', 'img/botones/piedra-f.png');
		$('#papel2').attr('src', 'img/botones/papel-f.png');
		$('#tijera2').attr('src', 'img/botones/tijeras-f.png');
		
		$('#temporizador').attr('src', 'img/vida/tiempo.gif');
		//una vez cambiados los estilos, llamamos a volver a elegir opción
		comprobarOpcionElegida();
	}else{
		$('#piedra2').attr('src', 'img/botones/piedra-f-des.png');
		$('#papel2').attr('src', 'img/botones/papel-f-des.png');
		$('#tijera2').attr('src', 'img/botones/tijeras-f-des.png');
		$('#temporizador').attr('src', 'img/vida/tiempoFin.png')
		if(opciones[0]===null)opciones[0] = Math.floor(Math.random() * 3);
		if(opciones[1]===null)opciones[1] = Math.floor(Math.random() * 3);
		resolverJuego();
	}
	//la 1º vez que entramos, ponemos 1ºturno a false, para que se sepa que ya se ha realizado la tirada del primer turno
	if(auxPrimerTurno)auxPrimerTurno = false;
}
function resolverJuego(){
	//PARA RESOLVER, HAY QUE SABER COMO VA CADA JUGADOR, SE MIRARÁ CON LAS PETICIONES AJAX, TENEMOS QUE EMPEZAR CON 3 VIDAS E IR PALANTE
	//peticion ajax para enviar lo que han sacado ambos jugadores y recibir la jugada ganadora(en formato json)
	$.ajax({
		type: 'GET',
		dataType: 'json',
		url: '/juego/Juego.action?accion=jugada&opcionPlayer1='+opciones[0]+'&opcionPlayer2='+opciones[1],
		success: function(data){
			console.log(data)
			let src1 = null;
			let src2 = null;
			switch (opciones[0]){
				case 0:
					src1 = 'img/movimientos/ryu-piedra.gif';
					break;
				case 1:
					src1 = 'img/movimientos/ryu-papel.gif';
					break;
				case 2:
					src1 = 'img/movimientos/ryu-tijeras.gif'
			}
			switch (opciones[1]){
				case 0:
					src2 = 'img/movimientos/ken-piedra.gif';
					break;
				case 1:
					src2 = 'img/movimientos/ken-papel.gif';
					break;
				case 2:
					src2 = 'img/movimientos/ken-tijeras.gif'
			}
			$('#imgPlayer1').attr('src', src1);
			$('#imgPlayer2').attr('src', src2);
			setTimeout(function(){
				comprobarVidas(data);
			}, 4000);
		}
	});
}
function comprobarVidas(data){
	let vidasPlayer1 = data.juego.jugadorUno.vidas;
	let vidasPlayer2 = data.juego.jugadorDos.vidas;
	if(vidasPlayer1==0)asignarGanador("player2", "player1");
	else if(vidasPlayer2==0)asignarGanador("player1", "player2");
	else window.location.reload();
}
function asignarGanador(jugadorVencedor, jugadorPerdedor){
	console.log(jugadorVencedor+" "+jugadorPerdedor)
	$.ajax({
			type: 'GET',
			url: '/juego/Juego.action?accion=asignarGanador&nombreGanador='+jugadorVencedor+'&nombrePerdedor='+jugadorPerdedor,
			success: function(){
				window.location.href = 'http://localhost:8080/juego/Final';
			}
		});
}














