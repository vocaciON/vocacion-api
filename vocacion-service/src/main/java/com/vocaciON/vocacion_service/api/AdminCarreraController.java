package com.vocaciON.vocacion_service.api;

import com.vocaciON.vocacion_service.model.entity.Carrera;
import com.vocaciON.vocacion_service.service.AdminCarreraService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/carreras")

public class AdminCarreraController {

    private final AdminCarreraService adminCarreraService;

    //vamos con los metodos
    // Responder las listas
    @GetMapping
        public ResponseEntity<List<Carrera>> getListaCarrera(){
        List<Carrera> carreras = adminCarreraService.getAll();
        return new ResponseEntity<List<Carrera>>(carreras, HttpStatus.OK); //ok = 200
    }

    //Metodo para obtener por medio del id
    @GetMapping("/{id}")
    public ResponseEntity<Carrera> getCarreraById(@PathVariable("id") Long id){
        Carrera carrera = adminCarreraService.findById(id);
        return new ResponseEntity<Carrera>(carrera, HttpStatus.OK);
    }


    //Ahora haremos el regististro, Postmappin

    @PostMapping
    public ResponseEntity<Carrera> createCarrera(@RequestBody Carrera carrera){

        Carrera newCarrera = adminCarreraService.create(carrera);
        return new ResponseEntity<Carrera>(newCarrera, HttpStatus.CREATED);

    }

    //Put metodo para la actualizacion
    @PutMapping("/{id}")
    public ResponseEntity<Carrera> updateCarrera(@PathVariable("id") Long id,
                                                   @RequestBody Carrera carrera){

        Carrera updateCarrera = adminCarreraService.update(id,carrera);
        return new ResponseEntity<Carrera>(updateCarrera, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Carrera> deleteCarrera(@PathVariable("id") Long id,
                                                   @RequestBody Carrera carrera){

        adminCarreraService.delete(id);
        return new ResponseEntity<Carrera>(HttpStatus.NO_CONTENT);

    }
}
