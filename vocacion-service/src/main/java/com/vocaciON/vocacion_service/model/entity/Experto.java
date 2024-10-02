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
@Table(name = "expertos")


public class Experto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "estudios", nullable = false)
    private String estudios;

    //Adaptando a la nueva diagrama de clases
    @Column(name="edad_experto")
    private Date edadExperto;
    @Column(name="especialidad")
    private String especialidad;
    @Column(name="informacion_personal")
    private String informacionPersonal;
    @Column(name="calificacion")
    private String calificacion;
    @Column(name = "disponibilidad")
    private String disponibilidad;


    @OneToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "FK_experto_usuario"))
        private Usuario usuario;


    @OneToMany
    @JoinColumn(name="asesoria_id", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "FK_experto_asesoria"))
    private List<Asesoria> asesoria;







    public void setCreatedAt(LocalDateTime now) {
    }
}
