package com.zeusmicrosystem.doctorbook.repository;

import com.zeusmicrosystem.doctorbook.model.Doutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoutorRepository extends JpaRepository <Doutor, Integer> {
    @Query("SELECT p FROM Doutor p WHERE p.nome LIKE %:termo% OR p.cpf LIKE %:termo% OR p.telefone LIKE %:termo%")
    public List<Doutor> findByTermo(String termo);
}
