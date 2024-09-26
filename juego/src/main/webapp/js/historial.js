$(document).ready(function(){
    $.ajax({
        type: 'GET',
        dataType: 'json',
        url: '/juego/Historial.action?accion=obtenerDatos',
        success: function(data){
            console.log(data);
			//AQUI PONER QUE SI DATA == NULL PONER NO DATA EN LAS COLUMNAS
			const tbody = $('tbody');
			data.forEach(function(juego){				
				const tr = $('<tr></tr>');
				const tdPlayer1 = $('<td></td>');
				const pPlayer1 = $('<p class="jacquarda-bastarda-9-regular"></p>').text(juego.jugadorUno.nombre);
				tdPlayer1.append(pPlayer1);

				const tdPlayer2 = $('<td></td>');
				const pPlayer2 = $('<p class="jacquarda-bastarda-9-regular"></p>').text(juego.jugadorDos.nombre);
				tdPlayer2.append(pPlayer2);
				
				const tdTime = $('<td></td>');
				const pTime = $('<p class="jacquarda-bastarda-9-regular"></p>').text(juego.hora);
				tdTime.append(pTime);
				
				const tdWinner = $('<td></td>');
				const pWinner = $('<p class="jacquarda-bastarda-9-regular"></p>').text(juego.ganador.nombre);
				tdWinner.append(pWinner);
				
				tr.append(tdPlayer1).append(tdPlayer2).append(tdTime).append(tdWinner);
				tbody.append(tr);
			});
			
        },
        error: function(jqXHR, textStatus, errorThrown){
            console.log("Error: " + textStatus + " " + errorThrown);
			//AQUI PONER QUE PONGA NO DATA SI HAY UN FALLO EN LAS COLUMNAS
        }
    });
});