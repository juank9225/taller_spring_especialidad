package co.com.softka.biblioteca.biblioteca.controllers;

import co.com.softka.biblioteca.biblioteca.services.ServiceRecursoBisnes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recurso")
public class ControllerRecursoBisnes {

    @Autowired
    ServiceRecursoBisnes serviceRecursoBisnes;

    @GetMapping("/disponibilidad/{id}")
    public ResponseEntity<String> disponibilidadRecurso(@PathVariable("id") String id) {
        return new ResponseEntity(serviceRecursoBisnes.disponibilidad(id), HttpStatus.OK);
    }

    @GetMapping("/prestamo/{id}")
    public ResponseEntity<String> prestarRecurso(@PathVariable("id") String id){
        return new ResponseEntity(serviceRecursoBisnes.prestarRecurso(id), HttpStatus.OK);
    }

    @GetMapping("/devolver/{id}")
    public ResponseEntity<String> devolverRecurso(@PathVariable("id") String id){
        return new ResponseEntity(serviceRecursoBisnes.devolverRecurso(id),HttpStatus.OK);
    }
}
