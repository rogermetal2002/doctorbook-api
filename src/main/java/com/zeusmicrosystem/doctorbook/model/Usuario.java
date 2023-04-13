package com.zeusmicrosystem.doctorbook.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.MappedSuperclass;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public abstract class Usuario {

    private String nome;
    private String cpf;
    private String telefone;
    private String endereco;
    private String nascimento;
    private String genero;

}
