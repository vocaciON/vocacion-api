package com.vocaciON.vocacion_service.service;

import com.vocaciON.vocacion_service.dto.PagoDTO;
import com.vocaciON.vocacion_service.model.entity.Pago;

import java.util.List;

public interface AdminPagoService {







    Pago createPago(Pago pago);


    List<Pago> getPagoHistoryByUsuarioId(long usuarioId);

    //Metodo para buscar mediante ID
    Pago findById(Long id);

    //Eliminacion del objeto Experto
    void delete(Long id);

}
