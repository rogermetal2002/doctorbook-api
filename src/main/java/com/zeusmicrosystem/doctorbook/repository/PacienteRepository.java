package com.zeusmicrosystem.doctorbook.repository;

import com.zeusmicrosystem.doctorbook.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente,Integer> {
    //public List<Paciente> findByName(String nome);
    @Query("SELECT p FROM Paciente p WHERE p.nome LIKE %:termo% OR p.cpf LIKE %:termo% OR p.telefone LIKE %:termo%")
    public List<Paciente> findByTermo(String termo);
}
