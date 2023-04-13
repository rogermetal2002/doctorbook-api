package com.zeusmicrosystem.doctorbook.service;

import com.zeusmicrosystem.doctorbook.model.Financeiro;
import com.zeusmicrosystem.doctorbook.repository.FinanceiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinanceiroService {

    @Autowired
    private FinanceiroRepository financeiroRepository;
    public Financeiro saveFinanceiro(Financeiro financeiro){
        return financeiroRepository.save(financeiro);
    }

    public List<Financeiro> getFinanceiro(){
        return financeiroRepository.findAll();
    }
    public void deleteFinanceiro(Financeiro financeiro){
        financeiroRepository.delete(financeiro);
    }

    public Financeiro updateFinanceiro(Financeiro financeiro){
        try {
            Financeiro localFinanceiro = financeiroRepository.findById(financeiro.getID()).get();
            localFinanceiro.setReceita(financeiro.getReceita());
            localFinanceiro.setDespesa(financeiro.getDespesa());
            localFinanceiro.setNome(financeiro.getNome());
            localFinanceiro.setCpf(financeiro.getCpf());
            localFinanceiro.setTelefone(financeiro.getTelefone());
            localFinanceiro.setEndereco(financeiro.getEndereco());
            localFinanceiro.setNascimento(financeiro.getNascimento());
            localFinanceiro.setGenero(financeiro.getGenero());
            financeiroRepository.save(localFinanceiro);
            return localFinanceiro;
        }catch (Exception e){
            return null;
        }
    }
    public List<Financeiro> search(String termo){
        return financeiroRepository.findByTermo(termo);
    }
}
