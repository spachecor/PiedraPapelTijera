$(document).ready(function(){
	//audio de la pg
	let audioEncendido = false;
	const audio = $('<audio></audio>');
	audio.attr('src', 'audio/creditos.mp3');
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
});