package com.audrey.blogreceitas.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.audrey.blogreceitas.model.Receita;

@Repository
public interface ReceitaRepository extends JpaRepository<Receita, Long> {

    public List<Receita> findAllByTituloContainingIgnoreCase(@Param("titulo") String titulo);

}
