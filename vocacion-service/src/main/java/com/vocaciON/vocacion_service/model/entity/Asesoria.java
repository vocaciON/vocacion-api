package com.vocaciON.vocacion_service.model.entity;

import com.vocaciON.vocacion_service.model.enums.EstadoAsesoria;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "asesorias")

public class Asesoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="tema_tratar", nullable=false)
    private String temaTratar;

    @Column(name = "fecha", nullable = false)
    private Date fechaAsesoria;

    @Column(name = "link_asesoria", nullable = false)
    private String linkAsesoria;

    @Column(name = "costo")
    private double costo;






    @Enumerated(EnumType.STRING)
    @Column(name = "estado_asesoria")
    private EstadoAsesoria estadoAsesoria;


    public void setCreatedAt(LocalDateTime now) {

    }
}
