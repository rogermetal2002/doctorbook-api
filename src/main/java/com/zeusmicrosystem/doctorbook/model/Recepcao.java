package com.zeusmicrosystem.doctorbook.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name="recepcao")
public class Recepcao extends Usuario{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer ID;
    private String relatorio;
    private String expediente;

    public Recepcao(String nome, String cpf, String telefone, String endereco, String nascimento, String genero, String relatorio, String expediente) {
        super(nome, cpf, telefone, endereco, nascimento, genero);
        this.relatorio = relatorio;
        this.expediente = expediente;
    }
}
