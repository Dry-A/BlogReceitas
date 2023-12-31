package com.audrey.blogreceitas.controller;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.audrey.blogreceitas.repository.CategoriaRepository;
import com.audrey.blogreceitas.repository.ReceitaRepository;

import com.audrey.blogreceitas.model.Receita;

@RestController
@RequestMapping("/receitas")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ReceitaController {

    @Autowired
    private ReceitaRepository receitaRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping
    public ResponseEntity<List<Receita>> getAll() {

        return ResponseEntity.ok(receitaRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Receita> getById(@PathVariable Long id) {

        return receitaRepository.findById(id).map(resposta -> ResponseEntity.ok(resposta))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());

    }

    @GetMapping("/titulo/{titulo}")
    public ResponseEntity<List<Receita>> getByTitulo(@PathVariable String titulo) {

        return ResponseEntity.ok(receitaRepository.findAllByTituloContainingIgnoreCase(titulo));
    }

    @PostMapping
    public ResponseEntity<Receita> post(@Valid @RequestBody Receita receita) {

        if (categoriaRepository.existsById(receita.getCategoria().getId()))

            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(receitaRepository.save(receita));

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PutMapping
    public ResponseEntity<Receita> put(@Valid @RequestBody Receita receita) {

        if (receitaRepository.existsById(receita.getId())) {

            if (categoriaRepository.existsById(receita.getCategoria().getId()))

                return ResponseEntity.status(HttpStatus.OK)
                        .body(receitaRepository.save(receita));

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {

        Optional<Receita> receita = receitaRepository.findById(id);

        if (receita.isEmpty())

            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        receitaRepository.deleteById(id);

    }

}
