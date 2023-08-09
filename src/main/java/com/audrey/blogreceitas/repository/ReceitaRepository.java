package com.audrey.blogreceitas.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.audrey.blogreceitas.model.Receita;

@Repository
public interface ReceitaRepository extends JpaRepository <Receita, Long> {


}
