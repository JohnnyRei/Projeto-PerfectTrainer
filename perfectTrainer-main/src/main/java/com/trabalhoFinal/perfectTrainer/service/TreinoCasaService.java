package com.trabalhoFinal.perfectTrainer.service;

import com.trabalhoFinal.perfectTrainer.domain.TreinoCasa;
import com.trabalhoFinal.perfectTrainer.repository.PersonalRepository;
import com.trabalhoFinal.perfectTrainer.repository.TreinoCasaRepository;
import com.trabalhoFinal.perfectTrainer.repository.UsuarioRepository;
import com.trabalhoFinal.perfectTrainer.service.expections.TreinoCasaNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TreinoCasaService {

    @Autowired
    private TreinoCasaRepository treinoCasaRepository;

    @Autowired
    private PersonalRepository personalRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional(readOnly = true)
    public TreinoCasa getOne(Long id) {
        TreinoCasa treinoCasaBuscado = treinoCasaRepository.getOne(id);
        if (treinoCasaBuscado == null) {
            throw new TreinoCasaNotFoundException("Treino na academia não encontrado.");
        }
        return treinoCasaBuscado;
    }

    @Transactional(readOnly = true)
    public List<TreinoCasa> getAll() {
        List<TreinoCasa> novaListaTreinoCasa2 = treinoCasaRepository.getAll();
        return novaListaTreinoCasa2;
    }

    @Transactional
    public TreinoCasa saveOne(TreinoCasa treinoCasa) {
        TreinoCasa treinoCasaSalvo = treinoCasa;
        if (treinoCasaSalvo.getId() != null) {
            throw new IllegalArgumentException("O id deve ser nulo, para ser autoincrementado.");
        }
        if (treinoCasa.getPersonal() != null && treinoCasa.getPersonal().getId() != null) {
            treinoCasa.setPersonal(personalRepository.getOne(treinoCasa.getPersonal().getId()));
        }
        if (treinoCasa.getUsuario() != null && treinoCasa.getUsuario().getId() != null) {
            treinoCasa.setUsuario(usuarioRepository.getOne(treinoCasa.getUsuario().getId()));
        }
        treinoCasaRepository.saveOne(treinoCasa);
        return treinoCasa;
    }

    @Transactional
    public void updateOne(Long id, TreinoCasa treinoCasa) {
        if (id == null) {
            throw new IllegalArgumentException("O id não pode ser nulo.");
        }
        treinoCasa.setId(id);
        treinoCasaRepository.saveOne(treinoCasa);
    }

    @Transactional
    public void deleteOne(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("O id não pode ser nulo.");
        }
        treinoCasaRepository.deleteOne(id);
    }
}
