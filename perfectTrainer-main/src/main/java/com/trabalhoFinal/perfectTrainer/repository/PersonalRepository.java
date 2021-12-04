package com.trabalhoFinal.perfectTrainer.repository;

import com.trabalhoFinal.perfectTrainer.domain.Personal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonalRepository {

    @Autowired
    private PersonalRepositoryJPA personalRepositoryJPA;

    public List<Personal> getAll() {
        List<Personal> listaPersonal = personalRepositoryJPA.findAll();
        return listaPersonal;
    }

    public Personal getOne(Long id) {
       Personal personalProcurado = personalRepositoryJPA.findById(id).orElseGet(null);
       return personalProcurado;
    }

    public Personal saveOne(Personal personal) {
        Personal personalCadastrado = personal;
        personalRepositoryJPA.save(personalCadastrado);
        return personalCadastrado;
    }

    public void updateOne(Long id, Personal personal) {
        personal.setId(id);
        personalRepositoryJPA.save(personal);
    }

    public void deleteOne(Long id) {
        personalRepositoryJPA.deleteById(id);
    }
}
