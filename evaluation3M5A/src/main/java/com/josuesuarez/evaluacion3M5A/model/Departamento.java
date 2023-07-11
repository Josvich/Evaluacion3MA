package com.josuesuarez.evaluacion3M5A.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "departamento")
@Data
public class Departamento {

    @Id
    private long idDepartamento;
    private String nombreDepartamento;
    private String director;
    private String descripcion;
}
