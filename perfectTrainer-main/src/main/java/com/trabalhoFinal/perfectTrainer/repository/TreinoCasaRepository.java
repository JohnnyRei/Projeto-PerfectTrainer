package com.trabalhoFinal.perfectTrainer.repository;

import com.trabalhoFinal.perfectTrainer.domain.TreinoCasa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TreinoCasaRepository {

    @Autowired
    private TreinoCasaRepositoryJPA treinoCasaRepositoryJPA;

    public List<TreinoCasa> getAll() {
        List<TreinoCasa> listaTreinoCasas = treinoCasaRepositoryJPA.findAll();
        return listaTreinoCasas;
    }

    public TreinoCasa getOne(Long id) {
        TreinoCasa treinoCasaProcurado = treinoCasaRepositoryJPA.findById(id).orElseGet(null);
        return treinoCasaProcurado;
    }

    public TreinoCasa saveOne(TreinoCasa treinoCasa) {
        TreinoCasa treinoCasaSalvo = treinoCasa;
        treinoCasaRepositoryJPA.save(treinoCasaSalvo);
        return treinoCasaSalvo;
    }

    public void updateOne(Long id, TreinoCasa treinoCasa) {
        treinoCasa.setId(id);
        treinoCasaRepositoryJPA.save(treinoCasa);
    }

    public void deleteOne(Long id) {
        treinoCasaRepositoryJPA.deleteById(id);
    }
}
