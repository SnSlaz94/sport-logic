package com.sportlogic.sport_logic.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="Personas")
public class Persona {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="id_persona")
private Integer id_persona;

@Column(name="nombre")
private String nombre;

@Column(name="apellido")
private String apellido;

@Column(name="documento")
private String documento;

@Column(name="fecha_nacimiento")
private LocalDate fecha_nacimiento;

@Column(name="telefono")
private String telefono;

@Column(name="direccion")
private String direccion;

}