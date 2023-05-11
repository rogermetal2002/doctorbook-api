package com.zeusmicrosystem.doctorbook.controller;
import com.zeusmicrosystem.doctorbook.model.Arquivo;
import com.zeusmicrosystem.doctorbook.model.ArquivoResponse;
import com.zeusmicrosystem.doctorbook.model.Paciente;
import com.zeusmicrosystem.doctorbook.model.UserType;
import com.zeusmicrosystem.doctorbook.service.ArquivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@RestController
@RequestMapping("/arquivo")
public class ArquivoController {

    @Autowired
    private ArquivoService service;
    @GetMapping
    public List<Arquivo> getArquivo(){
        return service.getArquivo();
    }

    @PostMapping
    public ArquivoResponse saveArquivo(@RequestParam("file") MultipartFile file,
                                       @RequestParam("idUsuario") Integer idUsuario,
                                       @RequestParam("tipoUsuario") UserType tipoUsuario,
                                       @RequestParam("perfil") boolean perfil){
        try {
            Arquivo arquivo = new Arquivo();
            arquivo.setNome(file.getOriginalFilename());
            arquivo.setDados(file.getBytes());
            arquivo.setIdUsuario(idUsuario);
            arquivo.setTipoUsuario(tipoUsuario);
            arquivo.setPerfil(perfil);
            Arquivo response = service.saveArquivo(arquivo);
            return new ArquivoResponse(response.getID(), response.getNome(), "Arquivo salvo com sucesso!!!");
        } catch (Exception e){
            return new ArquivoResponse(null, null, "Arquivo não pode ser salvo, erro: "+e.getMessage());
        }
    }

    @DeleteMapping
    public boolean deleteArquivo(@RequestParam Long id){
        Arquivo arquivo = new Arquivo();
        arquivo.setID(id);
        service.deleteArquivo(arquivo);
        return true;
    }
    @GetMapping("/get")
    public Arquivo getById(@RequestParam Long id){
        return service.getById(id);
    }

    @GetMapping("/get-perfil")
    public Arquivo getByPerfil(@RequestParam Integer id){
        return service.getPerfil(id);
    }

}
