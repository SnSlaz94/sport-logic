package com.sportlogic.sport_logic.model;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
@Table(name="personas") // Coincidiendo con el SQL (minúsculas)
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_persona")
    private Integer id_persona;

    private String nombre;
    private String apellido;
    
    @Column(unique = true)
    private String documento;

    private LocalDate fecha_nacimiento;
    private String telefono;
    private String direccion;

    // Relación inversa para verificar si la persona ya es usuario
    @OneToOne(mappedBy = "persona", cascade = CascadeType.ALL)
    @ToString.Exclude // Evita bucles infinitos en el toString de Lombok
    @EqualsAndHashCode.Exclude
    private Usuario usuario;
}