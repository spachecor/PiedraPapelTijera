$(document).ready(function(){
	if($('#nombreGanador').val()=="player1"){
		$('#player1').attr('src', 'img/personajes/ryu-win.png')
		$('#player2').attr('src', 'img/personajes/ken-lose.png')
	}else{
		$('#player1').attr('src', 'img/personajes/ryu-lose.png')
		$('#player2').attr('src', 'img/personajes/ken-win.png')
	}
});