package com.vocaciON.vocacion_service.api;


import com.vocaciON.vocacion_service.model.entity.ResultadoPrueba;
import com.vocaciON.vocacion_service.service.AdminResultadoPruebaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/admin/restuldatoPruebas")

public class AdminResultadoPruebaController {

    private final AdminResultadoPruebaService adminResultadoPruebaService;

    //vamos con los metodos
    // Responder las listas
    @GetMapping
    public ResponseEntity<List<ResultadoPrueba>> getListaResultadoPruebas() {
        List<ResultadoPrueba> resultadoPruebas = adminResultadoPruebaService.getAll();
        return new ResponseEntity<List<ResultadoPrueba>>(resultadoPruebas, HttpStatus.OK); //ok = 200
    }

    //Metodo para obtener por medio del id
    @GetMapping("/{id}")
    public ResponseEntity<ResultadoPrueba> getResultadoPruebaById(@PathVariable("id") Long id){
        ResultadoPrueba resultadoPrueba = adminResultadoPruebaService.findById(id);
        return new ResponseEntity<ResultadoPrueba>(resultadoPrueba, HttpStatus.OK);
    }


    //Ahora haremos el regististro, Postmappin

    @PostMapping
    public ResponseEntity<ResultadoPrueba> createResultadoPrueba(@RequestBody ResultadoPrueba resultadoPrueba){

        ResultadoPrueba newResultadoPrueba = adminResultadoPruebaService.create(resultadoPrueba);
        return new ResponseEntity<ResultadoPrueba>(newResultadoPrueba, HttpStatus.CREATED);

    }

    //Put metodo para la actualizacion
    @PutMapping("/{id}")
    public ResponseEntity<ResultadoPrueba> updateResultadoPrueba(@PathVariable("id") Long id,
                                                 @RequestBody ResultadoPrueba resultadoPrueba){

        ResultadoPrueba updateResultadoPrueba = adminResultadoPruebaService.update(id,resultadoPrueba);
        return new ResponseEntity<ResultadoPrueba>(updateResultadoPrueba, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResultadoPrueba> deleteResultadoPrueba(@PathVariable("id") Long id,
                                                 @RequestBody ResultadoPrueba resultadoPrueba){

        adminResultadoPruebaService.delete(id);
        return new ResponseEntity<ResultadoPrueba>(HttpStatus.NO_CONTENT);

    }
}
