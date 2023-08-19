package com.audrey.blogreceitas.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.LocalDate;

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
