package com.zeusmicrosystem.doctorbook.controller;

import com.zeusmicrosystem.doctorbook.model.Recepcao;
import com.zeusmicrosystem.doctorbook.service.RecepcaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recepcao")
public class RecepcaoController {

    @Autowired
    private RecepcaoService service;

    @GetMapping
    public List<Recepcao> getRecepcao() {
        return service.getRecepcao();
    }

    @PostMapping
    public Recepcao saveRecepcao(@RequestBody Recepcao recepcao) {
        return service.saveRecepcao(recepcao);
    }

    @DeleteMapping
    public boolean deleteRecepcao(@RequestParam Integer id) {
        Recepcao recepcao = new Recepcao();
        recepcao.setID(id);
        service.deleteRecepcao(recepcao);
        return true;
    }
    @PutMapping
    public Recepcao updateRecepcao(@RequestBody Recepcao recepcao) {
        return service.updateRecepcao(recepcao);
    }

    @GetMapping("/search")
    public List<Recepcao> searchPaciente(@RequestParam String termo){
        return service.search(termo);
    }
}
