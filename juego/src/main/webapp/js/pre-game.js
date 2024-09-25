$(document).ready(function(){
	
	//audio de la pg
	let audioEncendido = false;
	const audio = $('<audio></audio>');
	audio.attr('src', 'audio/pantalla2.mp3');
	audio.attr('loop', 'loop');
	$('body').append(audio);
	$('#boton-audio').click(function(){
		if(!audioEncendido){
			audio[0].play();
			audioEncendido=true;
		}else{
			audio[0].pause();
			audioEncendido=false;
		}
	});
	
	if($('#opcionJuego').val()==="1vsMachine"){
		$('#player2').attr('disabled', 'true');
		$('#player2').val("Machine");
	}
	//interceptar el formulario para que no haya valores nullos o vacíos
	$('#nombreJugadoresForm').on('submit', function(event){
		const form = event.currentTarget;
		//detenemos el comportamiento
		event.preventDefault();
		let player1Correcto = $('#player1').val()!=null&&$('#player1').val().length>0;
		let player2Correcta = $('#player2').val()!=null&&$('#player2').val().length>0;
		if(player1Correcto&&player2Correcta){
			event.currentTarget.submit();
		}else{
			Swal.fire({
				title: "¡Terrible!",
				text: "Por favor, rellene todos los campos",
				icon: "error",
				confirmButtonText: "¡Voy!",
				confirmButtonColor: "#FF0000"
			});
		}
	});
});