$(document).ready(function(){
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