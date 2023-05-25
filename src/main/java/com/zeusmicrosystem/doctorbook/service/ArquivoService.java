package com.zeusmicrosystem.doctorbook.service;

import com.zeusmicrosystem.doctorbook.model.Arquivo;
import com.zeusmicrosystem.doctorbook.repository.ArquivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArquivoService {

    @Autowired
    private ArquivoRepository arquivoRepository;
    public Arquivo saveArquivo(Arquivo arquivo){

        return arquivoRepository.save(arquivo);
    }
    public List<Arquivo> getArquivo(){
        return arquivoRepository.findAll();
    }

    public void deleteArquivo(Arquivo arquivo){
        arquivoRepository.delete(arquivo);
    }

    public Arquivo getById(Long id){
        Optional<Arquivo> arquivo = arquivoRepository.findById(id);
        return arquivo.orElse(null);
    }
    public byte[] getPerfil(Integer pacienteId){
       List<Arquivo> arquivos = arquivoRepository.findByIdUsuarioAndPerfil(pacienteId, true);
       return arquivos.get(0).getDados();
    }
    public Arquivo alterarPerfil(Arquivo arquivoNovo){
        List<Arquivo> arquivos = arquivoRepository.findByIdUsuarioAndPerfil(arquivoNovo.getIdUsuario(), true);
        Arquivo arquivo = arquivos.get(0);
        arquivo.setDados(arquivoNovo.getDados());
        arquivo.setNome(arquivoNovo.getNome());
        return arquivoRepository.save(arquivo);
    }
}
