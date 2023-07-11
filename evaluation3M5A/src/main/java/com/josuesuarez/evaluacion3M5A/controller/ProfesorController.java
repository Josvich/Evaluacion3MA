package com.josuesuarez.evaluacion3M5A.controller;



import com.josuesuarez.evaluacion3M5A.model.Profesor;
import com.josuesuarez.evaluacion3M5A.service.ProfesorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profesor")
public class ProfesorController {

    @Autowired
    ProfesorServiceImpl personaService;

    @GetMapping("/listar")
    public ResponseEntity<List<Profesor>> listarProductos() {
        return new ResponseEntity<>(personaService.findByAll(),
                HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Profesor> crearProducto(
            @RequestBody Profesor p) {
        return new ResponseEntity<>(personaService.save(p),
                HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Profesor> actualizarProducto(@PathVariable Long id, @RequestBody Profesor p) {
        Profesor profesorENcontrada = personaService.findById(id);
        if (profesorENcontrada == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                profesorENcontrada.setNombre(p.getNombre());
                profesorENcontrada.setDireccion(p.getDireccion());
                profesorENcontrada.setTelefono(p.getTelefono());
                profesorENcontrada.setCurso(p.getCurso());
                profesorENcontrada.setListDepartamento(p.getListDepartamento());
                return new ResponseEntity<>(personaService.save(p), HttpStatus.OK);
            } catch (DataAccessException e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Profesor> eliminarProducto(@PathVariable Long id) {
        personaService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
