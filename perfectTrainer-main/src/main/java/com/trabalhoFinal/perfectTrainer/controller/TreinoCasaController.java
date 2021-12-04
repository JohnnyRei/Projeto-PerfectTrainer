package com.trabalhoFinal.perfectTrainer.controller;

import com.trabalhoFinal.perfectTrainer.domain.TreinoCasa;
import com.trabalhoFinal.perfectTrainer.service.TreinoCasaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/treinosCasa")
@CrossOrigin(origins = "http://localhost:3000")
public class TreinoCasaController {

    @Autowired
    private TreinoCasaService treinoCasaService;

    @GetMapping()
    public @ResponseBody
    List<TreinoCasa> getAll() {
        List<TreinoCasa> novaListaTreinoCasa3 = treinoCasaService.getAll();
        return novaListaTreinoCasa3;
    }

    @GetMapping(value = "/{id}")
    public @ResponseBody TreinoCasa getOne(@PathVariable(name = "id") Long id) {
        TreinoCasa treinoCasaProcurado = treinoCasaService.getOne(id);
        return treinoCasaProcurado;
    }

    @PostMapping()
    public @ResponseBody TreinoCasa saveOne(@RequestBody TreinoCasa treinoCasa) {
        TreinoCasa treinoCasaSalvo = treinoCasa;
        treinoCasaService.saveOne(treinoCasa);
        return treinoCasaSalvo;
    }

    @PutMapping(value = "/{id}")
    public void updateOne(@PathVariable(name = "id") Long id, @RequestBody TreinoCasa treinoCasa) {
        treinoCasa.setId(id);
        treinoCasaService.updateOne(id, treinoCasa);
    }

    @DeleteMapping(value = "{id}")
    public void deleteOne(@PathVariable(name = "id") Long id) {
        treinoCasaService.deleteOne(id);
    }
}
