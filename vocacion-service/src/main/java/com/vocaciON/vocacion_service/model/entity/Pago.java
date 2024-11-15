package com.vocaciON.vocacion_service.model.entity;

import com.vocaciON.vocacion_service.model.enums.EstadoPago;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "pagos")
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "monto", nullable = false)
    private Float monto;

    @Column(name = "fecha_create")
    private LocalDateTime fechaCreate;
    @Column(name = "fecha_update")
    private LocalDateTime fechaUpdate;
// verificando si se agregocomo clave forania , aun esta para modificar
    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id",
    foreignKey = @ForeignKey(name = "FK_pago_usuario"))
    private Usuario usuario;

    @Enumerated(EnumType.STRING)
    @Column(name = "estadoPago")
    private EstadoPago estadoPago;
}
