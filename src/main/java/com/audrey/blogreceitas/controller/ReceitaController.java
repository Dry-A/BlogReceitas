package com.audrey.blogreceitas.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.audrey.blogreceitas.repository.ReceitaRepository;
import jakarta.validation.Valid;
import com.audrey.blogreceitas.model.Receita;

@RestController
@RequestMapping("/receitas")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ReceitaController {

    @Autowired
    private ReceitaRepository bananinhaRepository;

    @GetMapping
    public ResponseEntity<List<Receita>> getAll() {

        return ResponseEntity.ok(bananinhaRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Receita> getById(@PathVariable Long id) {

        return bananinhaRepository.findById(id).map(resposta -> ResponseEntity.ok(resposta))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());

    }

    @GetMapping("/titulo/{titulo}")
    public ResponseEntity<List<Receita>> getByTitulo(@PathVariable String titulo) {

        return ResponseEntity.ok(bananinhaRepository.findAllByTituloContainingIgnoreCase(titulo));
    }

    @PostMapping
    public ResponseEntity<Receita> post(@Valid @RequestBody Receita receita) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(bananinhaRepository.save(receita));
    }

    @PutMapping
    public ResponseEntity<Receita> put(@Valid @RequestBody Receita receita) {

        return bananinhaRepository.findById(receita.getId())
                .map(resposta -> ResponseEntity.status(HttpStatus.OK)
                        .body(bananinhaRepository.save(receita)))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

}
