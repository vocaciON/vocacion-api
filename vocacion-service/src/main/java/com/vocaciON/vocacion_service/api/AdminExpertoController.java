package com.vocaciON.vocacion_service.api;


import com.vocaciON.vocacion_service.model.entity.Experto;
import com.vocaciON.vocacion_service.service.AdminExpertoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/admin/expertos") // identificador de recurso universar o unico
public class AdminExpertoController {

    //Dato importante
    //En un controlador no se inyectan los repositorys
    // controlador resive inyeccion de los servicios y el servicio recibe la inyeccion de los repositorys

    //Aqui tengo que inyectar las interface
    private final AdminExpertoService adminExpertoService;

    //vamos con los metodos
    // Responder las listas
    @GetMapping
    public ResponseEntity<List<PruebaVocacional>>getListaExpertos(){
        List<PruebaVocacional> expertos = adminExpertoService.getAll();
        return new ResponseEntity<List<PruebaVocacional>>(expertos, HttpStatus.OK); //ok = 200
    }

    //Metodo para obtener por medio del id
    @GetMapping("/{id}")
    public ResponseEntity<PruebaVocacional> getExpertoById(@PathVariable("id") Long id){
        PruebaVocacional experto = adminExpertoService.findById(id);
        return new ResponseEntity<PruebaVocacional>(experto, HttpStatus.OK);
    }


    //Ahora haremos el regististro, Postmappin

    @PostMapping
    public ResponseEntity<PruebaVocacional> createExperto(@RequestBody PruebaVocacional experto){

        PruebaVocacional newExperto = adminExpertoService.create(experto);
        return new ResponseEntity<PruebaVocacional>(newExperto, HttpStatus.CREATED);

    }

    //Put metodo para la actualizacion
    @PutMapping("/{id}")
    public ResponseEntity<PruebaVocacional> updateExperto(@PathVariable("id") Long id,
                                                          @RequestBody PruebaVocacional experto){

        PruebaVocacional updateExperto = adminExpertoService.update(id,experto);
        return new ResponseEntity<PruebaVocacional>(updateExperto, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PruebaVocacional> deleteExperto(@PathVariable("id") Long id,
                                                          @RequestBody PruebaVocacional experto){

        adminExpertoService.delete(id);
        return new ResponseEntity<PruebaVocacional>(HttpStatus.NO_CONTENT);

    }
}
