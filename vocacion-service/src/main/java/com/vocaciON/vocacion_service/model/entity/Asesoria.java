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

    @Column(name = "fecha", nullable = false)
    private LocalDateTime fecha;

    @Column(name = "estado", nullable = false)
    private String estado;

    /*@ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "idUsuario", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "experto_id", referencedColumnName = "id", nullable = false)
    private Experto experto;*/
    @ManyToOne
    @JoinColumn(name = "experto_id", referencedColumnName = "id",
    foreignKey = @ForeignKey(name = "FK_asesoria_experto"))
    private Experto experto;

    @Enumerated(EnumType.STRING)
    @Column(name = "estadoAsesoria")
    private EstadoAsesoria estadoAsesoria;







}
