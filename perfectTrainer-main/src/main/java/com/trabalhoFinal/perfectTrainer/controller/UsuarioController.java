package com.trabalhoFinal.perfectTrainer.controller;

import com.trabalhoFinal.perfectTrainer.domain.Usuario;
import com.trabalhoFinal.perfectTrainer.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/usuarios")
@CrossOrigin(origins = "http://localhost:3000")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping()
    public @ResponseBody List<Usuario> getAll() {
        List<Usuario> novaListaUsuario3 = usuarioService.getAll();
        return novaListaUsuario3;
    }

    @GetMapping(value = "/{id}")
    public @ResponseBody Usuario getOne(@PathVariable(name = "id") Long id) {
        Usuario usuarioProcurado = usuarioService.getOne(id);
        return usuarioProcurado;
    }

    @PostMapping()
    public @ResponseBody Usuario saveOne(@RequestBody Usuario usuario) {
        Usuario usuarioSalvo = usuario;
        usuarioService.saveOne(usuario);
        return usuarioSalvo;
    }

    @PutMapping(value = "/{id}")
    public void updateOne(@PathVariable(name = "id") Long id, @RequestBody Usuario usuario) {
        usuario.setId(id);
        usuarioService.updateOne(id, usuario);
    }

    @DeleteMapping(value = "{id}")
    public void deleteOne(@PathVariable(name = "id") Long id) {
        usuarioService.deleteOne(id);
    }
}
