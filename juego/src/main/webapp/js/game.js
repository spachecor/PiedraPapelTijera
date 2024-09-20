$(document).ready(function(){
    //Ajustar el alto al alto de la pantalla
    let height = $(window).height();
    $('body').css('height', height);
	
	
	
	//recogemos la opcion del primero
	let opcion1;
	$(document).keydown(function(e){
	    switch(e.which) {
	        case 49: 
			opcion1 = "PIEDRA";
	          break;
	        case 50: 
			opcion1 = "PAPEL";
	          break;
	        case 51: 
	        opcion1 = "TIJERA";
	          break;
	        default: opcion1 = null;
	    }
	});
	
	//comienza el contador:
	setTimeout
});