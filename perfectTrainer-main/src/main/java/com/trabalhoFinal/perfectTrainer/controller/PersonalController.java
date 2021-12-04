package com.trabalhoFinal.perfectTrainer.controller;

import com.trabalhoFinal.perfectTrainer.domain.Personal;
import com.trabalhoFinal.perfectTrainer.service.PersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RestController
@RequestMapping(value = "/personais")
@CrossOrigin(origins = "http://localhost:3000")
public class PersonalController {

    @Autowired
    private PersonalService personalService;

    @GetMapping()
    public @ResponseBody List<Personal> getAll() {
        List<Personal> novaListaPersonal3 = personalService.getAll();
        return novaListaPersonal3;
    }

    @GetMapping(value = "/{id}")
    public @ResponseBody Personal getOne(@PathVariable(name = "id") Long id) {
        Personal personalProcurado = personalService.getOne(id);
        return personalProcurado;
    }

    @PostMapping()
    public @ResponseBody Personal saveOne(@RequestBody Personal personal) {
        Personal personalSalvo = personal;
        personalService.saveOne(personal);
        return personalSalvo;
    }

    @PutMapping(value = "/{id}")
    public void updateOne(@PathVariable(name = "id") Long id, @RequestBody Personal personal) {
        personal.setId(id);
        personalService.updateOne(id, personal);
    }

    @DeleteMapping(value = "{id}")
    public void deleteOne(@PathVariable(name = "id") Long id) {
        personalService.deleteOne(id);
    }
}
