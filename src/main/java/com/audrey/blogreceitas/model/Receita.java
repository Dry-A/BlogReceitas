package com.audrey.blogreceitas.model;


import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "tb_receitas")
public class Receita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Título é obrigatório! ")
    private String titulo;

    @NotBlank(message = "Descrever os ingredientes é brigatório! ")
    private String ingredientes;

    @NotBlank(message = "Modo de Preparo é obrigatório! ")
    private String modoPreparo;

    private String infoAdicionais;

    @UpdateTimestamp
    private LocalDate data;

    @ManyToOne
    @JsonIgnoreProperties("receita")
    private Categoria categoria;

    public Long getId() {

        return this.id;
    }

    @ManyToOne
    @JsonIgnoreProperties("receita")
    private Usuario usuario;

}
