package com.trabalhoFinal.perfectTrainer.controller;

import com.trabalhoFinal.perfectTrainer.domain.Portifolio;
import com.trabalhoFinal.perfectTrainer.service.PortifolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/portifolios")
@CrossOrigin(origins = "http://localhost:3000")
public class PortifolioController {

    @Autowired
    private PortifolioService portifolioService;

    @GetMapping()
    public @ResponseBody
    List<Portifolio> getAll() {
        List<Portifolio> novaListaPortifolio3 = portifolioService.getAll();
        return novaListaPortifolio3;
    }

    @GetMapping(value = "/{id}")
    public @ResponseBody Portifolio getOne(@PathVariable(name = "id") Long id) {
        Portifolio portifolioProcurado = portifolioService.getOne(id);
        return portifolioProcurado;
    }

    @PostMapping()
    public @ResponseBody Portifolio saveOne(@RequestBody Portifolio portifolio) {
        Portifolio portifolioSalvo = portifolio;
        portifolioService.saveOne(portifolioSalvo);
        return portifolioSalvo;
    }

    @PutMapping(value = "/{id}")
    public void updateOne(@PathVariable(name = "id") Long id, @RequestBody Portifolio portifolio) {
        portifolio.setId(id);
        portifolioService.updateOne(id, portifolio);
    }

    @DeleteMapping(value = "{id}")
    public void deleteOne(@PathVariable(name = "id") Long id) {
        portifolioService.deleteOne(id);
    }
}
