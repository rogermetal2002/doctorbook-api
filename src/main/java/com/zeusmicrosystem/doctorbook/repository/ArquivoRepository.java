package com.zeusmicrosystem.doctorbook.repository;

import com.zeusmicrosystem.doctorbook.model.Arquivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArquivoRepository extends JpaRepository<Arquivo, Long> {
    List<Arquivo> findByIdUsuarioAndPerfil(Integer idUsuario, boolean perfil);
}