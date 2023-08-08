package com.audrey.blogreceitas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.audrey.blogreceitas.dao.ReceitaDAO;

@RestController
@RequestMapping("/receitas")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ReceitaController {

    @Autowired
    private ReceitaDAO  minhaReceitaDao;






    
}
