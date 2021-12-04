package com.trabalhoFinal.perfectTrainer.repository;

import com.trabalhoFinal.perfectTrainer.domain.Portifolio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PortifolioRepository {

    @Autowired
    private PortifolioRepositoryJPA portifolioRepositoryJPA;

    public List<Portifolio> getAll() {
        List<Portifolio> listaPortifolio = portifolioRepositoryJPA.findAll();
        return listaPortifolio;
    }

    public Portifolio getOne(Long id) {
        Portifolio portifolioProcurado = portifolioRepositoryJPA.findById(id).orElseGet(null);
        return portifolioProcurado;
    }

    public Portifolio saveOne(Portifolio portifolio) {
        Portifolio portifolioSalvo = portifolio;
        portifolioRepositoryJPA.save(portifolioSalvo);
        return portifolioSalvo;
    }

    public void updateOne(Long id, Portifolio portifolio) {
        portifolio.setId(id);
        portifolioRepositoryJPA.save(portifolio);
    }

    public void deleteOne(Long id) {
        portifolioRepositoryJPA.deleteById(id);
    }
}
