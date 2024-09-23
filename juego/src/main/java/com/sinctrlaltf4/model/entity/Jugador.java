package com.sinctrlaltf4.model.entity;

import jakarta.persistence.*;

/**
 * Clase que define la estructura y métodos de la entidad Jugador.
 * @author SinCtrlAltF4
 * @version 1.0
 */
@Entity
@Table(name = "jugador")
public class Jugador extends Entidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_jugador")
    private Integer id;
    private String nombre;
    private Integer vidas;

    public Jugador() {
    	this.vidas = 3;
    }

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", vidas='" + vidas + '\'' +
                '}';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

	public Integer getVidas() {
		return vidas;
	}

	public void setVidas(Integer vidas) {
		this.vidas = vidas;
	}
}
