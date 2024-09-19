$(document).ready(function(){
//Ajustar el alto al alto de la pantalla
    let height = $(window).height();
    $('body').css('height', height);
//cerrar ventana al salir
	$('#salir').click(function(){
		Swal.fire({
		  title: "Por favor, cierra esta pestaña manualmente.",
		  text: "Desgraciadamente, muchos navegadores no dejan cerrar pestañas así como así, por lo que necesitamos que la cierres tú. ¡Gracias por jugar!",
		  icon: "warning",
		  confirmButtonText: "¡Voy!",
		  confirmButtonColor: "#FF0000"
		});
	});
});