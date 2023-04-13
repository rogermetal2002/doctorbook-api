package com.zeusmicrosystem.doctorbook.controller;

import com.zeusmicrosystem.doctorbook.model.Paciente;
import com.zeusmicrosystem.doctorbook.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    private PacienteService service;

    @GetMapping
    public List<Paciente> getPaciente(){
        return service.getPaciente();
    }

    @PostMapping
    public Paciente savePaciente(@RequestBody Paciente paciente){
        return service.savePaciente(paciente);
    }

    @DeleteMapping
    public boolean deletePaciente(@RequestParam Integer id){
        Paciente paciente=new Paciente();
        paciente.setID(id);
        service.deletePaciente(paciente);
        return true;
    }
    @PutMapping
    public Paciente updatePaciente(@RequestBody Paciente paciente){
        return service.updatePaciente(paciente);
    }

   @GetMapping("/search")
   public List<Paciente> searchPaciente(@RequestParam String termo){
       return service.search(termo);
    }
}
