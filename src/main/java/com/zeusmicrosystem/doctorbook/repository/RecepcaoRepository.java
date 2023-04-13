package com.zeusmicrosystem.doctorbook.repository;

import com.zeusmicrosystem.doctorbook.model.Recepcao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecepcaoRepository extends JpaRepository<Recepcao,Integer> {

    @Query("SELECT p FROM Recepcao p WHERE p.nome LIKE %:termo% OR p.cpf LIKE %:termo% OR p.telefone LIKE %:termo%")
    public List<Recepcao> findByTermo(String termo);
}
