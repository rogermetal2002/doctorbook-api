package com.zeusmicrosystem.doctorbook.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name="paciente")
public class Paciente extends Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer ID;
    private String evolucao;
    private String agenda;
    private String descricaoAgenda;

    public Paciente(String nome, String cpf, String telefone, String endereco, String nascimento, String genero, String evolucao, String agenda, String descricaoAgenda) {
        super(nome, cpf, telefone, endereco, nascimento, genero);
        this.evolucao = evolucao;
        this.agenda = agenda;
        this.descricaoAgenda = descricaoAgenda;
    }
}
