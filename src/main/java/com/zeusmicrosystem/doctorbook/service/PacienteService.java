package com.zeusmicrosystem.doctorbook.service;

import com.zeusmicrosystem.doctorbook.model.Paciente;
import com.zeusmicrosystem.doctorbook.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;
    public Paciente savePaciente(Paciente paciente){
        return pacienteRepository.save(paciente);
    }
    public List<Paciente> getPaciente(){

        return pacienteRepository.findAll();
    }
    public void deletePaciente(Paciente paciente){
       pacienteRepository.delete(paciente);
    }
    public Paciente updatePaciente(Paciente paciente){
        try {
            Paciente localPaciente = pacienteRepository.findById(paciente.getID()).get();
            localPaciente.setNome(paciente.getNome());
            localPaciente.setCpf(paciente.getCpf());
            localPaciente.setTelefone(paciente.getTelefone());
            localPaciente.setEndereco(paciente.getEndereco());
            localPaciente.setNascimento(paciente.getNascimento());
            localPaciente.setGenero(paciente.getGenero());
            localPaciente.setEvolucao(paciente.getEvolucao());
            localPaciente.setAgenda(paciente.getAgenda());
            localPaciente.setDescricaoAgenda(paciente.getDescricaoAgenda());
            pacienteRepository.save(localPaciente);
            return localPaciente;
        }catch (Exception e){
            return null;
        }
    }
    public List<Paciente> search(String termo){
        return pacienteRepository.findByTermo(termo);
    }

}
