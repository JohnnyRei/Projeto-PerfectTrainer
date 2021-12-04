package com.trabalhoFinal.perfectTrainer.service;

import com.trabalhoFinal.perfectTrainer.domain.TreinoAcademia;
import com.trabalhoFinal.perfectTrainer.repository.PersonalRepository;
import com.trabalhoFinal.perfectTrainer.repository.TreinoAcademiaRepository;
import com.trabalhoFinal.perfectTrainer.repository.UsuarioRepository;
import com.trabalhoFinal.perfectTrainer.service.expections.TreinoAcademiaNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TreinoAcademiaService {

    @Autowired
    private TreinoAcademiaRepository treinoAcademiaRepository;

    @Autowired
    private PersonalRepository personalRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional(readOnly = true)
    public TreinoAcademia getOne(Long id) {
        TreinoAcademia treinoAcademiaBuscado = treinoAcademiaRepository.getOne(id);
        if (treinoAcademiaBuscado == null) {
            throw new TreinoAcademiaNotFoundException("Treino na academia não encontrado.");
        }
        return treinoAcademiaBuscado;
    }

    @Transactional(readOnly = true)
    public List<TreinoAcademia> getAll() {
        List<TreinoAcademia> novaListaTreinoAcademia2 = treinoAcademiaRepository.getAll();
        return novaListaTreinoAcademia2;
    }

    @Transactional
    public TreinoAcademia saveOne(TreinoAcademia treinoAcademia) {
        TreinoAcademia treinoAcademiaSalvo = treinoAcademia;
        if (treinoAcademiaSalvo.getId() != null) {
            throw new IllegalArgumentException("O id deve ser nulo, para ser autoincrmentado.");
        }
        if (treinoAcademia.getPersonal() != null && treinoAcademia.getPersonal().getId() != null) {
            treinoAcademia.setPersonal(personalRepository.getOne(treinoAcademia.getPersonal().getId()));
        }
        if (treinoAcademia.getUsuario() != null && treinoAcademia.getUsuario().getId() != null) {
            treinoAcademia.setUsuario(usuarioRepository.getOne(treinoAcademia.getUsuario().getId()));
        }
        treinoAcademiaRepository.saveOne(treinoAcademiaSalvo);
        return treinoAcademia;
    }

    @Transactional
    public void updateOne(Long id, TreinoAcademia treinoAcademia) {
        if (id == null) {
            throw new IllegalArgumentException("O id não pode ser nulo.");
        }
        treinoAcademia.setId(id);
        treinoAcademiaRepository.saveOne(treinoAcademia);
    }

    @Transactional
    public void deleteOne(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("O id não pode ser nulo.");
        }
        treinoAcademiaRepository.deleteOne(id);
    }

}
