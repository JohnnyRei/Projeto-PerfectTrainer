package com.trabalhoFinal.perfectTrainer.controller;

import com.trabalhoFinal.perfectTrainer.domain.TreinoAcademia;
import com.trabalhoFinal.perfectTrainer.service.TreinoAcademiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/treinosAcademia")
@CrossOrigin(origins = "http://localhost:3000")
public class TreinoAcademiaController {

    @Autowired
    private TreinoAcademiaService treinoAcademiaService;

    @GetMapping()
    public @ResponseBody
    List<TreinoAcademia> getAll() {
        List<TreinoAcademia> novaListaTreinoAcademia3 = treinoAcademiaService.getAll();
        return novaListaTreinoAcademia3;
    }

    @GetMapping(value = "/{id}")
    public @ResponseBody TreinoAcademia getOne(@PathVariable(name = "id") Long id) {
        TreinoAcademia treinoAcademiaProcurado = treinoAcademiaService.getOne(id);
        return treinoAcademiaProcurado;
    }

    @PostMapping()
    public @ResponseBody TreinoAcademia saveOne(@RequestBody TreinoAcademia treinoAcademia) {
        TreinoAcademia treinoAcademiaSalvo = treinoAcademia;
        treinoAcademiaService.saveOne(treinoAcademia);
        return treinoAcademiaSalvo;
    }

    @PutMapping(value = "/{id}")
    public void updateOne(@PathVariable(name = "id") Long id, @RequestBody TreinoAcademia treinoAcademia) {
        treinoAcademia.setId(id);
        treinoAcademiaService.updateOne(id, treinoAcademia);
    }

    @DeleteMapping(value = "{id}")
    public void deleteOne(@PathVariable(name = "id") Long id) {
        treinoAcademiaService.deleteOne(id);
    }
}
