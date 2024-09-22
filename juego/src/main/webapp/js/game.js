//recogemos la opcion del primero
let opciones = [];
let aux = 0;
$(document).ready(function(){
    //Ajustar el alto al alto de la pantalla
    let height = $(window).height();
    $('body').css('height', height);
	//set interval con contador de 15 a 0 que en el intervalo pueda elegir la opcion pero si no la elige pues ya no se pueda
	//primero poner el codigo íntegro de selección de opción y luego el setInterval recoge la opcion y la guarda en el array. Un
	//setInterval para cada turno.
	/*IDEA:
		Puedes usar el setInterval cada segundo para que compruebe cada segundo si el jugador ha elegido una opcion
		En caso de que la haya elegido, salta de turno
		En caso qe no, sigue hasta los 15 segundos (usar una auxiliar) y si llega a 15 y nada se guarda como null y se sigue
		Al llegar a 15 se pasa al siguiente jugador y se repite la jugada
		OJO considerar usar promesas, mirarlo
	*/
	//inicio turno 1
	//MAL MUY MAL
	let interval = setInterval(function(){
		if(aux===2){
			clearInterval(interval);
		}
		console.log("elige opcion")
		$(document).keydown(function(e){
			switch(e.which) {
				case 49:
					opciones.push(0);
					break;
				case 50:
					opciones.push(1);
					break;
				case 51:
					opciones.push(2);
					break;
			    }
		});
		aux++;
	}, 15000);
	opciones.forEach(function(opcion){
		console.log(opcion);
	});
});