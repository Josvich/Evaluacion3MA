package com.josuesuarez.evaluacion3M5A.service;



import com.josuesuarez.evaluacion3M5A.model.Profesor;
import com.josuesuarez.evaluacion3M5A.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class ProfesorServiceImpl extends GenericServiceImpl<Profesor,Long> implements GenericService<Profesor,Long>{


    @Autowired
    ProfesorRepository profesorRepository;

    @Override
    public CrudRepository<Profesor, Long> getDao(){return profesorRepository;}
}
