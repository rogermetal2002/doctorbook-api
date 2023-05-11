package com.zeusmicrosystem.doctorbook.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ArquivoResponse {

    private Long id;
    private String nome;
    private String msg;
}
