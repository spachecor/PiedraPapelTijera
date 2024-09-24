$(document).ready(function(){
	if($('#ganador').val()=="player1"){
		//gana player1
		$('#player1').attr('src', 'img/personajes/ryu-win.png');
		$('#player2').attr('src', 'img/personajes/ken-lose.png');
		$('#resultado').attr('src', 'img/personajes/win-los-1.png');
	}else{
		//gana player2
		$('#player1').attr('src', 'img/personajes/ryu-lose.png');
		$('#player2').attr('src', 'img/personajes/ken-win.png');
		$('#resultado').attr('src', 'img/personajes/win-los-2.png');
	}
});