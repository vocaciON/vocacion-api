package com.vocaciON.vocacion_service.service.impl;


import com.vocaciON.vocacion_service.mapper.PagoMapper;
import com.vocaciON.vocacion_service.model.entity.Pago;
import com.vocaciON.vocacion_service.model.enums.EstadoPago;
import com.vocaciON.vocacion_service.repository.PagoRepository;
import com.vocaciON.vocacion_service.service.AdminPagoService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
@Data
@Service
@RequiredArgsConstructor
public class AdminPagoServiceImpl implements AdminPagoService {
    private final PagoRepository pagoRepository;

    private final PagoMapper pagoMapper;

    @Override
    @Transactional
    public Pago createPago(Pago pago) { //registro de una compra
        //Establecer una fecha de creacion

        pago.setFechaCreate(LocalDateTime.now());
        //Asignar un estado de pago
        pago.setEstadoPago(EstadoPago.PENDING);
        //Calcular el pago
        Float monto=pago.getMonto();
        pago.setMonto(monto);
        //ahora guardare en la DB
        return pagoRepository.save(pago);
    }

    @Override
    public List<Pago> getPagoHistoryByUsuarioId(long usuarioId) { // listado
        return pagoRepository.findByUsuarioId(usuarioId);
    }

    @Override
    public Pago findById(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
