package com.vocaciON.vocacion_service.api;

import com.vocaciON.vocacion_service.model.entity.PruebaVocacion;
import com.vocaciON.vocacion_service.service.AdminPruebaVocacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/pruebavocaciones")

public class AdminPruebaVocacionController {

    private final AdminPruebaVocacionService adminPruebaVocacionService;
    //vamos con los metodos
    // Responder las listas
    @GetMapping
    public ResponseEntity<List<PruebaVocacion>> getListaPruebaVocacion(){
        List<PruebaVocacion> pruebaVocacion = adminPruebaVocacionService.getAll();
        return new ResponseEntity<List<PruebaVocacion>>(pruebaVocacion, HttpStatus.OK); //ok = 200
    }

    //Metodo para obtener por medio del id
    @GetMapping("/{id}")
    public ResponseEntity<PruebaVocacion> getPruebaVocacioanlById(@PathVariable("id") Long id){
        PruebaVocacion pruebaVocacional = adminPruebaVocacionService.findById(id);
        return new ResponseEntity<PruebaVocacion>(pruebaVocacional, HttpStatus.OK);
    }


    //Ahora haremos el regististro, Postmappin

    @PostMapping
    public ResponseEntity<PruebaVocacion> createPruebaVocacional(@RequestBody PruebaVocacion pruebaVocacional){

        PruebaVocacion newPruebaVocacional = adminPruebaVocacionService.create(pruebaVocacional);
        return new ResponseEntity<PruebaVocacion>(newPruebaVocacional, HttpStatus.CREATED);

    }

    //Put metodo para la actualizacion
    @PutMapping("/{id}")
    public ResponseEntity<PruebaVocacion> updatePruebaVocacional(@PathVariable("id") Long id,
                                                          @RequestBody PruebaVocacion pruebaVocacional){

        PruebaVocacion updatePruebavocacion = adminPruebaVocacionService.update(id,pruebaVocacional);
        return new ResponseEntity<PruebaVocacion>(updatePruebavocacion, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PruebaVocacion> deleteExperto(@PathVariable("id") Long id,
                                                          @RequestBody PruebaVocacion pruebaVocacion){

        adminPruebaVocacionService.delete(id);
        return new ResponseEntity<PruebaVocacion>(HttpStatus.NO_CONTENT);

    }
}
