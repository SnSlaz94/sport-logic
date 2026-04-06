package com.sportlogic.sport_logic.model;

import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="Horarios")
public class Horario {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id_horario;

private String dia_semana;

private LocalTime hora_inicio;

private LocalTime hora_fin;

private String lugar;

}