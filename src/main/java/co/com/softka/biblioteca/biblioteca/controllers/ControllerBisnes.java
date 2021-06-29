package co.com.softka.biblioteca.biblioteca.controllers;

import co.com.softka.biblioteca.biblioteca.services.ServiceBisnes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recurso")
public class ControllerBisnes {

    @Autowired
    ServiceBisnes serviceBisnes;

    @GetMapping("/disponibilidad/{id}")
    public ResponseEntity<String> disponibilidadRecurso(@PathVariable("id") String id) {
        return new ResponseEntity(serviceBisnes.disponibilidad(id), HttpStatus.OK);
    }

    @GetMapping("/prestamo/{id}")
    public ResponseEntity<String> prestarRecurso(@PathVariable("id") String id){
        return new ResponseEntity(serviceBisnes.prestarRecurso(id), HttpStatus.OK);
    }

    @GetMapping("/devolver/{id}")
    public ResponseEntity<String> devolverRecurso(@PathVariable("id") String id){
        return new ResponseEntity(serviceBisnes.devolverRecurso(id),HttpStatus.OK);
    }
}
