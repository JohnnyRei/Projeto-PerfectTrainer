package com.trabalhoFinal.perfectTrainer.repository;

import com.trabalhoFinal.perfectTrainer.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UsuarioRepository {

    @Autowired
    private UsuarioRepositoryJPA usuarioRepositoryJPA;

    public List<Usuario> getAll() {
        List<Usuario> listaUsuarios = usuarioRepositoryJPA.findAll();
        return listaUsuarios;
    }

    public Usuario getOne(Long id) {
        Usuario usuarioSalvo = usuarioRepositoryJPA.findById(id).orElseGet(null);
        return usuarioSalvo;
    }

    public Usuario saveOne(Usuario usuario) {
        Usuario usuarioSalvo = usuario;
        usuarioRepositoryJPA.save(usuarioSalvo);
        return usuarioSalvo;
    }

    public void updateOne(Long id, Usuario usuario) {
        usuario.setId(id);
        usuarioRepositoryJPA.save(usuario);
    }

    public void deleteOne(Long id) {
        usuarioRepositoryJPA.deleteById(id);
    }
}
