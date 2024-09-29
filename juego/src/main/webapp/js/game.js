//fondos aleatorios
const fondos = {};
for (let i = 1; i <= 10; i++) {
	fondos[i] = `img/fondos/${i}.gif`;
}

const OPCIONES = {
	PIEDRA: '0',
	PAPEL: '1',
	TIJERA: '2'
};

const JUGADORES = {
	JUGADOR_1: '-1',
	EMPATE: '0',
	JUGADOR_2: '1'
};

const esMaquina = $('#nombrePlayer2').text() === 'Machine';
const vidaJugador1Dom = $('#vidaIzq');
const vidaJugador2Dom = $('#vidaDcha');


const piedraJugador1 = $('#piedra1');
const papelJugador1 = $('#papel1');
const tijeraJugador1 = $('#tijera1');

const piedraJugador2 = $('#piedra2');
const papelJugador2 = $('#papel2');
const tijeraJugador2 = $('#tijera2');

const temporizador = $('#temporizador');

let audioEncendido = true;

window.addEventListener('load', async () => {
	cargaAudio();
	cargarFondo();
	let hayGanador = false;
	let resultadoJugador1, resultadoJugador2;
	while (!hayGanador) {
		// Jugador 1
		resultadoJugador1 = await escogerResultado(false);
		piedraJugador1.attr('src', 'img/botones/piedra-f-des.png');
		papelJugador1.attr('src', 'img/botones/papel-f-des.png');
		tijeraJugador1.attr('src', 'img/botones/tijeras-f-des.png');

		piedraJugador2.attr('src', 'img/botones/piedra-f.png');
		papelJugador2.attr('src', 'img/botones/papel-f.png');
		tijeraJugador2.attr('src', 'img/botones/tijeras-f.png');

		temporizador.attr('src', 'img/vida/tiempo.gif');
		
		// Jugador 2
		resultadoJugador2 = await escogerResultado(esMaquina);
		piedraJugador2.attr('src', 'img/botones/piedra-f-des.png');
		papelJugador2.attr('src', 'img/botones/papel-f-des.png');
		tijeraJugador2.attr('src', 'img/botones/tijeras-f-des.png');

		temporizador.attr('src', 'img/vida/tiempoFin.png');
		await comprobarGanador(resultadoJugador1, resultadoJugador2);
		piedraJugador1.attr('src', 'img/botones/piedra-f.png');
		papelJugador1.attr('src', 'img/botones/papel-f.png');
		tijeraJugador1.attr('src', 'img/botones/tijeras-f.png');

		temporizador.attr('src', 'img/vida/tiempo.gif');

		$('#imgPlayer1').attr('src', 'img/movimientos/ryu-parado.gif');
		$('#imgPlayer2').attr('src', 'img/movimientos/ken-parado.gif');
	}
});

function cargaAudio() {
	const musica = $('#musica')[0];
	musica.play();
	$('#boton-audio').click(function(){
		audioEncendido ? musica.pause() : musica.play();
		audioEncendido = !audioEncendido;
	});
}

function cargarFondo() {
	$('body').css('background-image', `url(${fondos[(Math.floor(Math.random() * 10) + 1)]})`);
}

async function escogerResultado(esMaquina) {
	return await new Promise(resolve => {
		setTimeout(() => {
			resolve(Object.values(OPCIONES)[Math.floor(Math.random() * 2)]);
		}, esMaquina ? 2000 : 15000);
		if (!esMaquina) {
			document.addEventListener('keydown', e => {
				const teclaPulsadaAOpcion = {
					'1': OPCIONES.PIEDRA,
					'2': OPCIONES.PAPEL,
					'3': OPCIONES.TIJERA
				};
				resolve(teclaPulsadaAOpcion[e.key]);
			});
		}
	})
}

function ajustarBarrasVida(vidaJugador1, vidaJugador2) {
	console.log(vidaJugador1, vidaJugador2)
	const imagenesVidaPlayer1 = [
		'barra_izq4-4',
		'barra_izq3-4',
		'barra_izq2-4',
		'barra_izq1-4'
	];
	console.log(`img/vida/${imagenesVidaPlayer1[vidaJugador1]}.png`)
	const imagenesVidaPlayer2 = [
		'barra_der4-4',
		'barra_der3-4',
		'barra_der2-4',
		'barra_der1-4'
	];
	vidaJugador1Dom.attr('src', `img/vida/${imagenesVidaPlayer1[vidaJugador1]}.png`)
	vidaJugador2Dom.attr('src', `img/vida/${imagenesVidaPlayer2[vidaJugador2]}.png`)
}


async function comprobarGanador(resultadoJugador1, resultadoJugador2) {
	await fetch('/juego/Juego.action?accion=jugada&opcionPlayer1=' + resultadoJugador1 + '&opcionPlayer2=' + resultadoJugador2, {
		method: 'GET',
	})
	.then(async response => {
		const imagenesMovimientosJugador1 = {
			[OPCIONES.PIEDRA]: 'ryu-piedra',
			[OPCIONES.PAPEL]: 'ryu-papel',
			[OPCIONES.TIJERA]: 'ryu-tijeras'
		};

		const imagenesMovimientosJugador2 = {
			[OPCIONES.PIEDRA]: 'ken-piedra',
			[OPCIONES.PAPEL]: 'ken-papel',
			[OPCIONES.TIJERA]: 'ken-tijeras'
		};
		$('#imgPlayer1').attr('src', `img/movimientos/${imagenesMovimientosJugador1[resultadoJugador1]}.gif`);
		$('#imgPlayer2').attr('src', `img/movimientos/${imagenesMovimientosJugador2[resultadoJugador2]}.gif`);
		await new Promise(resolve => setTimeout(resolve, 4000));
		const data = await response.json();
		if (data) {
			const vidaJugador1 = data.juego.jugadorUno.vidas;
			const vidaJugador2 = data.juego.jugadorDos.vidas;
			ajustarBarrasVida(vidaJugador1, vidaJugador2);
			let jugadorGanador;
			if (vidaJugador1 === 0) {
				jugadorGanador = JUGADORES.JUGADOR_2;
				asignarGanador(jugadorGanador);
			} else if (vidaJugador2 === 0) {
				jugadorGanador = JUGADORES.JUGADOR_1;
				asignarGanador(jugadorGanador);
			}
		}
	});
}

function asignarGanador(jugadorVencedor){
	$.ajax({
		type: 'GET',
		url: '/juego/Juego.action?accion=asignarGanador&nombreGanador=' + jugadorVencedor,
		success: function(){
			window.location.href = 'http://localhost:8080/juego/Final';
		}
	});
}