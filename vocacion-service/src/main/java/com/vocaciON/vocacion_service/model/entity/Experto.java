package com.vocaciON.vocacion_service.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "Expertos")


public class Experto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "area", nullable = false)
    private String area;

    @Column(name = "disponibilidad")
    private String disponibilidad;


    @OneToMany(mappedBy = "experto", cascade = CascadeType.ALL)
    private List<Asesoria> asesoria;
}
