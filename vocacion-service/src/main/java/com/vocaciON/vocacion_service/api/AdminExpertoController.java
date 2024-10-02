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
    public ResponseEntity<List<Experto>>getListaExpertos(){
        List<Experto> expertos = adminExpertoService.getAll();
        return new ResponseEntity<List<Experto>>(expertos, HttpStatus.OK); //ok = 200
    }

    //Metodo para obtener por medio del id
    @GetMapping("/{id}")
    public ResponseEntity<Experto> getExpertoById(@PathVariable("id") Long id){
        Experto experto = adminExpertoService.findById(id);
        return new ResponseEntity<Experto>(experto, HttpStatus.OK);
    }


    //Ahora haremos el regististro, Postmappin

    @PostMapping
    public ResponseEntity<Experto> createExperto(@RequestBody Experto experto){

        Experto newExperto = adminExpertoService.create(experto);
        return new ResponseEntity<Experto>(newExperto, HttpStatus.CREATED);

    }

    //Put metodo para la actualizacion
    @PutMapping("/{id}")
    public ResponseEntity<Experto> updateExperto(@PathVariable("id") Long id,
                                                          @RequestBody Experto experto){

        Experto updateExperto = adminExpertoService.update(id,experto);
        return new ResponseEntity<Experto>(updateExperto, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Experto> deleteExperto(@PathVariable("id") Long id,
                                                          @RequestBody Experto experto){

        adminExpertoService.delete(id);
        return new ResponseEntity<Experto>(HttpStatus.NO_CONTENT);

    }
}
