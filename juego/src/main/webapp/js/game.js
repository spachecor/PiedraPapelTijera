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
	//comprobamos la opcion del jugador 1	
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
		//TODO PONER EL TEMPORIZADOR A 00
		resolverJuego();
	}
	//la 1º vez que entramos, ponemos 1ºturno a false, para que se sepa que ya se ha realizado la tirada del primer turno
	if(auxPrimerTurno)auxPrimerTurno = false;
}
function resolverJuego(){
	//PARA RESOLVER, HAY QUE SABER COMO VA CADA JUGADOR, SE MIRARÁ CON LAS PETICIONES AJAX, TENEMOS QUE EMPEZAR CON 3 VIDAS E IR PALANTE
}