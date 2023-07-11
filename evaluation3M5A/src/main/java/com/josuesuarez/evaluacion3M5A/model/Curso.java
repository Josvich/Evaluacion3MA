package com.josuesuarez.evaluacion3M5A.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Curso")
@Data
public class Curso {

    @Id
    private Long idCurso;
    private String nombreCurso;
    private String nivel;
    private String descripcion;
}
