package com.zeusmicrosystem.doctorbook.controller;

import com.zeusmicrosystem.doctorbook.model.Doutor;
import com.zeusmicrosystem.doctorbook.service.DoutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doutor")
public class DoutorController {
    @Autowired
    private DoutorService service;

    @GetMapping
    public List<Doutor> getDoutor(){
        return service.getDoutor();
    }

    @PostMapping
    public Doutor saveDoutor(@RequestBody Doutor doutor){
        return service.saveDoutor(doutor);
    }

    @DeleteMapping
    public boolean deleteDoutor(@RequestParam Integer id){
        Doutor doutor = new Doutor();
        doutor.setID(id);
     service.deleteDoutor(doutor);
     return true;
    }

    @PutMapping
    public Doutor updateDoutor(@RequestBody Doutor doutor){
        return service.updateDoutor(doutor);
    }

    @GetMapping("/search")
    public List<Doutor> searchDoutor(@RequestParam String termo){
        return service.search(termo);
    }
}
