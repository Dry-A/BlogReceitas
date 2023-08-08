package com.audrey.blogreceitas.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.audrey.blogreceitas.model.Receita;

@Repository
public interface ReceitaDAO extends JpaRepository <Receita, Long> {


}
