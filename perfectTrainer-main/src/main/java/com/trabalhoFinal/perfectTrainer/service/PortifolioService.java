package com.trabalhoFinal.perfectTrainer.service;

import com.trabalhoFinal.perfectTrainer.domain.Portifolio;
import com.trabalhoFinal.perfectTrainer.repository.*;
import com.trabalhoFinal.perfectTrainer.service.expections.PortifolioNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PortifolioService {

    @Autowired
    private PortifolioRepository portifolioRepository;

    @Autowired
    private PersonalRepository personalRepository;

    @Autowired
    private TreinoCasaRepository treinoCasaRepository;

    @Autowired
    private TreinoAcademiaRepository treinoAcademiaRepository;

    @Transactional(readOnly = true)
    public Portifolio getOne(Long id) {
        Portifolio portifolioBuscado = portifolioRepository.getOne(id);
        if (portifolioBuscado == null) {
            throw new PortifolioNotFoundException("Portifólio não encontrado.");
        }
        return portifolioBuscado;
    }

    @Transactional(readOnly = true)
    public List<Portifolio> getAll() {
        List<Portifolio> novaListaPortifolio2 = portifolioRepository.getAll();
        return novaListaPortifolio2;
    }

    @Transactional
    public Portifolio saveOne(Portifolio portifolio) {
        Portifolio portifolioSalvo = portifolio;
        if (portifolioSalvo.getId() != null) {
            throw new IllegalArgumentException("O id deve ser nulo, para ser autoincrmentado.");
        }
        if (portifolio.getPersonal() != null && portifolio.getPersonal().getId() != null) {
            portifolio.setPersonal(personalRepository.getOne(portifolio.getPersonal().getId()));
        }
        if (portifolio.getTreinoAcademia() != null && portifolio.getTreinoAcademia().getId() != null) {
            portifolio.setTreinoAcademia(treinoAcademiaRepository.getOne(portifolio.getTreinoAcademia().getId()));
        }
        if (portifolio.getTreinoCasa() != null && portifolio.getTreinoCasa().getId() != null) {
            portifolio.setTreinoCasa(treinoCasaRepository.getOne(portifolio.getTreinoCasa().getId()));
        }
        portifolioRepository.saveOne(portifolioSalvo);
        return portifolioSalvo;
    }

    @Transactional
    public void updateOne(Long id, Portifolio portifolio) {
        if (id == null) {
            throw new IllegalArgumentException("O id não pode ser nulo.");
        }
        portifolio.setId(id);
        portifolioRepository.saveOne(portifolio);
    }

    @Transactional
    public void deleteOne(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("O id não pode ser nulo.");
        }
        portifolioRepository.deleteOne(id);
    }
}
