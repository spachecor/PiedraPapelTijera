package com.sinctrlaltf4.model.entity;

import jakarta.persistence.*;

/**
 * Clase que define la estructura y métodos de la entidad Jugador.
 * @author Juan-Cumpli-Manuel-Selene
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

    public Jugador() {}

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
