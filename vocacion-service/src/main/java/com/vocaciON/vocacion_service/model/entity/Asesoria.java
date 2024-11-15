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

    @Column(name = "fecha_asesoria", nullable = false)
    private Date fechaAsesoria;

    @Column(name = "fecha_create")
    private LocalDateTime fechaCreate;

    @Column(name = "fecha_update")
    private LocalDateTime fechaUpdate;

    @Column(name = "link_asesoria", nullable = false)
    private String linkAsesoria;

    @Column(name = "costo")
    private double costo;






    @Enumerated(EnumType.STRING)
    @Column(name = "estado_asesoria")
    private EstadoAsesoria estadoAsesoria;

    @OneToOne
    @JoinColumn(name = "experto_id",referencedColumnName = "id",
            foreignKey =@ForeignKey(name = "FK_asesoria_experto") )
    private Experto experto;

    @OneToOne
    @JoinColumn(name = "perfil_id",referencedColumnName = "id",
    foreignKey = @ForeignKey(name = "FK_asesoria_perfil"))
    private Perfil perfil;





}
