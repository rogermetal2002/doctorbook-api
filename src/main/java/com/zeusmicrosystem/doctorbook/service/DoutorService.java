package com.zeusmicrosystem.doctorbook.service;
import com.zeusmicrosystem.doctorbook.model.Doutor;
import com.zeusmicrosystem.doctorbook.model.Paciente;
import com.zeusmicrosystem.doctorbook.repository.DoutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoutorService {
    @Autowired
    private DoutorRepository doutorRepository;
    public List<Doutor> getDoutor(){
        return doutorRepository.findAll();
    }
    public Doutor saveDoutor(Doutor doutor){
      return doutorRepository.save(doutor);
    }
    public void deleteDoutor(Doutor doutor){
         doutorRepository.delete(doutor);
    }
    public Doutor updateDoutor(Doutor doutor){
        try {
            Doutor localDoutor = doutorRepository.findById(doutor.getID()).get();
            localDoutor.setCrm(doutor.getCrm());
            localDoutor.setEspecialidade(doutor.getEspecialidade());
            localDoutor.setAssinaturaDigital(doutor.getAssinaturaDigital());
            localDoutor.setNome(doutor.getNome());
            localDoutor.setCpf(doutor.getCpf());
            localDoutor.setTelefone(doutor.getTelefone());
            localDoutor.setEndereco(doutor.getEndereco());
            localDoutor.setNascimento(doutor.getNascimento());
            localDoutor.setGenero(doutor.getGenero());
            doutorRepository.save(localDoutor);
            return localDoutor;
        }catch (Exception e){
            return null;
        }
    }

    public List<Doutor> search(String termo){
        return doutorRepository.findByTermo(termo);
    }
}
