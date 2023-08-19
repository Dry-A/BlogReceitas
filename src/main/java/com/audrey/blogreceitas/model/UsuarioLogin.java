package com.audrey.blogreceitas.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioLogin {

    private Long id;
    private String nome;
    private String foto;
    private String usuario;
    private String senha;
    private String token;

}
