package com.trabalhoFinal.perfectTrainer.service;

import com.trabalhoFinal.perfectTrainer.domain.Personal;
import com.trabalhoFinal.perfectTrainer.repository.PersonalRepository;
import com.trabalhoFinal.perfectTrainer.service.expections.PersonalNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonalService {

    @Autowired
    private PersonalRepository personalRepository;

    @Transactional(readOnly = true)
    public Personal getOne(Long id) {
        Personal personalBuscado = personalRepository.getOne(id);
        if (personalBuscado == null) {
            throw new PersonalNotFoundException("Personal não encontrado.");
        }
        return personalBuscado;
    }

    @Transactional(readOnly = true)
    public List<Personal> getAll() {
        List<Personal> listaPersonal2 = personalRepository.getAll();
        return listaPersonal2;
    }

    @Transactional
    public Personal saveOne(Personal personal) {
        Personal personalSalvo = personal;
        if (personalSalvo.getId() != null) {
            throw new IllegalArgumentException("O id deve ser nulo, o sistema irá auto-incrementar.");
        }
        if (personalSalvo.getNome() == null) {
            throw new IllegalArgumentException("O nome não pode ser nulo.");
        }
        personalRepository.saveOne(personalSalvo);
        return personalSalvo;
    }

    @Transactional
    public void updateOne(Long id, Personal personal) {
        personal.setId(id);
        if (personal.getId() == null) {
            throw new IllegalArgumentException("O id deve ser passado para o update do personal.");
        }
        personalRepository.saveOne(personal);
    }

    @Transactional
    public void deleteOne(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("O id deve ser passado para deletar o personal.");
        }
        personalRepository.deleteOne(id);
    }
}
