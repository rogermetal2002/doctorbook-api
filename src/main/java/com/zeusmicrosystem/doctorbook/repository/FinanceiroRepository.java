package com.zeusmicrosystem.doctorbook.repository;

import com.zeusmicrosystem.doctorbook.model.Financeiro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FinanceiroRepository extends JpaRepository<Financeiro,Integer> {

    @Query("SELECT p FROM Financeiro p WHERE p.nome LIKE %:termo% OR p.cpf LIKE %:termo% OR p.telefone LIKE %:termo%")
    public List<Financeiro> findByTermo(String termo);

}
