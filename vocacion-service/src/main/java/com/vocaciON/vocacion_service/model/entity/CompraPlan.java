package com.vocaciON.vocacion_service.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "compra_planes")

public class CompraPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "costo")
    private Float total;
    @Column(name = "nombre")
    private String nombrePlan;
    @Column(name = "descripcion_plan")
    private String descripcionPlan;
    @Column(name = "fecha_create")
    private LocalDateTime createdAT;



}