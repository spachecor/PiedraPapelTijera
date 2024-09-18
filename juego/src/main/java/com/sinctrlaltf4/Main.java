package com.sinctrlaltf4;

import com.sinctrlaltf4.model.entity.Juego;
import com.sinctrlaltf4.model.entity.Jugada;
import com.sinctrlaltf4.model.entity.Jugador;
import com.sinctrlaltf4.model.entity.OpcionJugada;
import com.sinctrlaltf4.model.services.repository.GenericRepositoryServiceImpl;
import com.sinctrlaltf4.model.services.repository.util.JpaUtil;
import com.sinctrlaltf4.model.services.resolucionjuego.ResolucionJuego;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        GenericRepositoryServiceImpl<Jugada> jugadaGenericRepositoryService = new GenericRepositoryServiceImpl<>(JpaUtil.getEntityManager(), Jugada.class);

        Jugador jugadorUno = new Jugador();
        jugadorUno.setNombre("Manolo");
        Jugador jugadorDos = new Jugador();
        jugadorDos.setNombre("Daniel");

        Juego juego = new Juego();
        juego.setJugadorUno(jugadorUno);
        juego.setJugadorDos(jugadorDos);
        juego.setHoraInicio(LocalDateTime.now().minusMinutes(5));
        juego.setHoraFin(LocalDateTime.now());

        Jugada jugadaPrimera = new Jugada();
        jugadaPrimera.setJuego(juego);
        jugadaPrimera.setHoraJugada(LocalDateTime.now());
        jugadaPrimera.setJugador(jugadorUno);
        jugadaPrimera.setOpcion(OpcionJugada.TIJERA.toString());

        Jugada jugadaSegunda = new Jugada();
        jugadaSegunda.setJuego(juego);
        jugadaSegunda.setHoraJugada(LocalDateTime.now());
        jugadaSegunda.setJugador(jugadorDos);
        jugadaSegunda.setOpcion(OpcionJugada.PIEDRA.toString());

        juego.setGanador(ResolucionJuego.resolverJuego(jugadaPrimera, jugadaSegunda).getJugador());
        System.out.println(juego.getGanador());

        jugadaGenericRepositoryService.guardar(jugadaPrimera);
        jugadaGenericRepositoryService.guardar(jugadaSegunda);

        System.out.println(jugadaGenericRepositoryService.listar());
    }
}