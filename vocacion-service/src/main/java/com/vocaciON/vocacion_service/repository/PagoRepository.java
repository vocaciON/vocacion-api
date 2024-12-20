package com.vocaciON.vocacion_service.repository;

import com.vocaciON.vocacion_service.model.entity.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PagoRepository extends JpaRepository<Pago, Long> {

    List<Pago> findByUsuarioId(Long usuarioId);
    @Query(value = "SELECT * FROM fn_list_compras_report()", nativeQuery = true)
    List<Object[]> getPagoReportByDate();
}
