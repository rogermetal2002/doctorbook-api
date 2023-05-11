package com.zeusmicrosystem.doctorbook.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name="arquivo")
public class Arquivo{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;
    private String nome;

    @Lob
    private byte[] dados;

    //Atributo de vinculação de arquivos ao tipo de dado
    private Integer idUsuario;

    private UserType tipoUsuario;
    private boolean perfil;

}
