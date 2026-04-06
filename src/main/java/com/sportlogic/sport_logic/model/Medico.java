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
@Table(name="Medicos")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_medico;

    @ManyToOne(optional = false)
    @JoinColumn(name="id_persona")
    private Persona persona;

    private String especialidad;
}