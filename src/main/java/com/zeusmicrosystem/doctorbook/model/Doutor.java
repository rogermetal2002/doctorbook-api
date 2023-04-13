package com.zeusmicrosystem.doctorbook.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name="doutor")
public class Doutor extends Usuario {
    //usar o generate constructor - botão direito do mouse
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer ID;
    private String crm;
  private String especialidade;
  private String assinaturaDigital;

 public Doutor(String nome, String cpf, String telefone, String endereco, String nascimento, String genero, String crm, String especialidade, String assinaturaDigital) {
        super(nome, cpf, telefone, endereco, nascimento, genero);
        this.crm = crm;
        this.especialidade = especialidade;
        this.assinaturaDigital = assinaturaDigital;
    }
}
