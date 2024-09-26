$(document).ready(function(){
    $.ajax({
        type: 'GET',
        dataType: 'json',
        url: '/juego/Historial.action?accion=obtenerDatos',
        success: function(data){
            console.log(data);
			//AQUI PONER QUE SI DATA == NULL PONER NO DATA EN LAS COLUMNAS
        },
        error: function(jqXHR, textStatus, errorThrown){
            console.log("Error: " + textStatus + " " + errorThrown);
			//AQUI PONER QUE PONGA NO DATA SI HAY UN FALLO EN LAS COLUMNAS
        }
    });
});