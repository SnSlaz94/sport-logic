package com.sportlogic.sport_logic.model;

import java.time.LocalDate;

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
@Table(name="Sesiones_Entrenamiento")
public class SesionEntrenamiento {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id_sesion;

@ManyToOne
@JoinColumn(name="id_horario")
private Horario horario;

private String objetivo_sesion;

private String descripcion_actividades;

private LocalDate fecha;

}
