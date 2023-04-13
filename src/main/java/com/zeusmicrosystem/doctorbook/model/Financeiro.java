package com.zeusmicrosystem.doctorbook.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name="financeiro")
public class Financeiro extends Usuario{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer ID;
    private String receita;
    private String despesa;

    public Financeiro(String nome, String cpf, String telefone, String endereco, String nascimento, String genero, String receita, String despesa) {
        super(nome, cpf, telefone, endereco, nascimento, genero);
        this.receita = receita;
        this.despesa = despesa;
    }
}
