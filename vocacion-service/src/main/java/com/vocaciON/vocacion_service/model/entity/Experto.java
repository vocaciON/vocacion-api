package com.vocaciON.vocacion_service.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
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


    @Column(name = "estudios", nullable = false)
    private String estudios;

    //Adaptando a la nueva diagrama de clases
    @Column(name="edadExperto")
    private Date edadExperto;
    @Column(name="especialidad")
    private String especialidad;
    @Column(name="informacionPersonal")
    private String informacionPersonal;
    @Column(name="calificacion")
    private String calificacion;
    @Column(name = "disponibilidad")
    private String disponibilidad;


    @OneToMany(mappedBy = "experto", cascade = CascadeType.ALL)
    private List<Asesoria> asesoria;

    public void setCreatedAt(LocalDateTime now) {
    }
}
