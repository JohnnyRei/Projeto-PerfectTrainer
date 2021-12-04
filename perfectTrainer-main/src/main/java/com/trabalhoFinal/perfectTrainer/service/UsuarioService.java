package com.trabalhoFinal.perfectTrainer.service;

import com.trabalhoFinal.perfectTrainer.domain.Usuario;
import com.trabalhoFinal.perfectTrainer.repository.UsuarioRepository;
import com.trabalhoFinal.perfectTrainer.service.expections.UsuarioNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional(readOnly = true)
    public Usuario getOne(Long id) {
        Usuario usuarioBuscado = usuarioRepository.getOne(id);
        if (usuarioBuscado == null) {
            throw new UsuarioNotFoundException("Usuário não encontrado.");
        }
        return usuarioBuscado;
    }

    @Transactional(readOnly = true)
    public List<Usuario> getAll() {
        List<Usuario> listaUsuario2 = usuarioRepository.getAll();
        return listaUsuario2;
    }

    @Transactional
    public Usuario saveOne(Usuario usuario) {
        Usuario usuarioSalvo = usuario;
        if (usuarioSalvo.getId() != null) {
            throw new IllegalArgumentException("O id deve ser nulo, pois será autoincrementado.");
        }
        if (usuarioSalvo.getNome() == null) {
            throw new IllegalArgumentException("O nome não deve ser nulo.");
        }
        usuarioRepository.saveOne(usuarioSalvo);
        return usuarioSalvo;
    }

    @Transactional
    public void updateOne(Long id, Usuario usuario) {
        if (id == null) {
            throw new IllegalArgumentException("O id não pode ser nulo.");
        }
        usuario.setId(id);
        usuarioRepository.updateOne(id, usuario);
    }

    @Transactional
    public void deleteOne(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("O id não pode ser nulo.");
        }
        usuarioRepository.deleteOne(id);
    }
}
