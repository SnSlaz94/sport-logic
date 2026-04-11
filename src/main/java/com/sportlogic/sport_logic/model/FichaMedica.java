package com.sportlogic.sport_logic.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
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
@Table(name="Fichas_medicas")
public class FichaMedica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_ficha;

    @ManyToOne
    @JoinColumn(name="id_jugador")
    private Jugador jugador;

    @ManyToOne
    @JoinColumn(name="id_medico")
    private Medico medico;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @Column(length=1000)
    private String historialClinico;

    @Column(length=1000)
    private String observaciones;

    private LocalDate fechaRevision;
}