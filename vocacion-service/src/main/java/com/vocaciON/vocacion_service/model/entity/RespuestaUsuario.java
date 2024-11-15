package com.vocaciON.vocacion_service.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "respuesta_usuarios")

public class RespuestaUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "resultado_prueba_id",referencedColumnName = "id",
    foreignKey = @ForeignKey(name = "FK_respuesta_usuario_resultado_prueba"))
    private ResultadoPrueba resultadoPrueba;
    @OneToOne
    @JoinColumn(name = "pregunta_id",referencedColumnName = "id",
    foreignKey = @ForeignKey(name = "FK_respuesta_usuario_pregunta"))
    private Pregunta pregunta;
    @OneToOne
    @JoinColumn(name = "respuesta_id",referencedColumnName = "id",
    foreignKey = @ForeignKey(name = "FK_respuesta_usuario_respuesta"))
    private Respuesta respuesta;
    @Column(name = "fecha_create")
    private LocalDateTime fechaCreate;

    @Column(name = "fecha_update")
    private LocalDateTime fechaUpdate;

    public void setCreatedAt(LocalDateTime now) {

    }
}
