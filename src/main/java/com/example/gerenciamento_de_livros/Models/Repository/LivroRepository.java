package com.example.gerenciamento_de_livros.Models.Repository;

import com.example.gerenciamento_de_livros.Models.LivroModels;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository <LivroModels, Long> {
}
