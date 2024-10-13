package com.vocaciON.vocacion_service.service;

import com.vocaciON.vocacion_service.model.entity.Pago;
import java.util.List;

public interface AdminPagoService {

    //Listar
    List<Pago> getAll();

    //Crear objeto
    Pago create(Pago pago);

    //Buscar por ID
    Pago findById(Long id);

    //Actualiacion iformación
    Pago update(Long id, Pago updatePago);

    //Eliminar objeto
    void delete(Long id);

}