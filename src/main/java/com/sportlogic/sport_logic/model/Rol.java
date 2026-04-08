package com.sportlogic.sport_logic.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="Roles")
public class Rol {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="id_rol")
private Integer id_rol;

@Column(name="nombre_rol")
private String nombre_rol;

    public String[] getNombreRol() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String[] getNombre_rol() {
        throw new UnsupportedOperationException("Not supported yet.");
    }


}