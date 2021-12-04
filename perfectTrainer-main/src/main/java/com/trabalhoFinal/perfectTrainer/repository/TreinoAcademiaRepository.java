package com.trabalhoFinal.perfectTrainer.repository;

import com.trabalhoFinal.perfectTrainer.domain.TreinoAcademia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TreinoAcademiaRepository {

    @Autowired
    private TreinoAcademiaRepositoryJPA treinoAcademiaRepositoryJPA;

    public List<TreinoAcademia> getAll() {
        List<TreinoAcademia> listaTreinoAcademia = treinoAcademiaRepositoryJPA.findAll();
        return listaTreinoAcademia;
    }

    public TreinoAcademia getOne(Long id) {
        TreinoAcademia treinoAcademiaProcurado = treinoAcademiaRepositoryJPA.findById(id).orElseGet(null);
        return treinoAcademiaProcurado;
    }

    public TreinoAcademia saveOne(TreinoAcademia treinoAcademia) {
        TreinoAcademia treinoAcademiaSalvo = treinoAcademia;
        treinoAcademiaRepositoryJPA.save(treinoAcademiaSalvo);
        return treinoAcademiaSalvo;

    }

    public void updateOne(Long id, TreinoAcademia treinoAcademia) {
        treinoAcademia.setId(id);
        treinoAcademiaRepositoryJPA.save(treinoAcademia);
    }

    public void deleteOne(Long id) {
        treinoAcademiaRepositoryJPA.deleteById(id);
    }
}
