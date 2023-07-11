package com.josuesuarez.evaluacion3M5A.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "Profesor")
@Data
public class Profesor {

    @Id
    private Long id;
    private String nombre;
    private String direccion;
    private String telefono;
    private Curso curso;
    private List<Departamento> listDepartamento;

}