package com.audrey.blogreceitas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.audrey.blogreceitas.repository.ReceitaRepository;
import com.audrey.blogreceitas.model.Receita;

@RestController
@RequestMapping("/receitas")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ReceitaController {

    @Autowired
    private ReceitaRepository bananinhaRepository ;

    @GetMapping
    public ResponseEntity<List<Receita>> getAll(){

        return ResponseEntity.ok(bananinhaRepository.findAll());
    }

    
}
