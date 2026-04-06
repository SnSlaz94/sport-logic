package com.sportlogic.sport_logic.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="Usuarios")
public class Usuario {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id_usuario;

private String username;
private String password;
private String email;

@ManyToOne
@JoinColumn(name="id_persona")
private Persona persona;

@ManyToOne
@JoinColumn(name="id_rol")
private Rol rol;

}
