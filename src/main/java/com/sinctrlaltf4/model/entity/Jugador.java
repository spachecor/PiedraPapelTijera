package com.sinctrlaltf4.model.entity;

import jakarta.persistence.*;

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
