package com.zeusmicrosystem.doctorbook.controller;

import com.zeusmicrosystem.doctorbook.model.Financeiro;
import com.zeusmicrosystem.doctorbook.model.Paciente;
import com.zeusmicrosystem.doctorbook.service.FinanceiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/financeiro")
public class FinanceiroController {

    @Autowired
    private FinanceiroService service;

    @GetMapping
    public List<Financeiro> getFinanceiro(){
        return service.getFinanceiro();
    }

    @PostMapping
    public Financeiro saveFinanceiro(@RequestBody Financeiro financeiro){
        return service.saveFinanceiro(financeiro);
    }

    @DeleteMapping
    public boolean deleteFinanceiro(@RequestParam Integer id){
        Financeiro financeiro = new Financeiro();
        financeiro.setID(id);
        service.deleteFinanceiro(financeiro);
        return true;
    }
    @PutMapping
    public Financeiro updateFinanceiro(@RequestBody Financeiro financeiro){
        return service.updateFinanceiro(financeiro);
    }
    @GetMapping("/search")
    public List<Financeiro> searchFinanceiro(@RequestParam String termo){
        return service.search(termo);
    }
}
