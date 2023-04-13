package com.zeusmicrosystem.doctorbook.service;

import com.zeusmicrosystem.doctorbook.model.Recepcao;
import com.zeusmicrosystem.doctorbook.repository.RecepcaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecepcaoService {
    @Autowired
    private RecepcaoRepository recepcaoRepository;
    public Recepcao saveRecepcao(Recepcao recepcao){
        return recepcaoRepository.save(recepcao);
    }
    public List<Recepcao> getRecepcao(){
        return recepcaoRepository.findAll();
    }

    public void deleteRecepcao(Recepcao recepcao){
        recepcaoRepository.delete(recepcao);
    }

    public Recepcao updateRecepcao(Recepcao recepcao){
        try {
            Recepcao localRecepcao = recepcaoRepository.findById(recepcao.getID()).get();
            localRecepcao.setNome(recepcao.getNome());
            localRecepcao.setCpf(recepcao.getCpf());
            localRecepcao.setTelefone(recepcao.getTelefone());
            localRecepcao.setEndereco(recepcao.getEndereco());
            localRecepcao.setNascimento(recepcao.getNascimento());
            localRecepcao.setGenero(recepcao.getGenero());
            localRecepcao.setRelatorio(recepcao.getRelatorio());
            localRecepcao.setExpediente(recepcao.getExpediente());
            recepcaoRepository.save(localRecepcao);
            return localRecepcao;
        }catch (Exception e){
            return null;
        }
    }
    public List<Recepcao> search(String termo){
        return recepcaoRepository.findByTermo(termo);
    }
}
