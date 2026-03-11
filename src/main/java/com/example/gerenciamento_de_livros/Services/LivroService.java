package com.example.gerenciamento_de_livros.Services;
import com.example.gerenciamento_de_livros.Models.LivroModels;
import com.example.gerenciamento_de_livros.Repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public LivroModels adicionar(LivroModels livroModels){
        return livroRepository.save(livroModels);
    }

    public List<LivroModels> buscarTudo(){
        return livroRepository.findAll();
    }

    public Optional<LivroModels> buscarId(Long id){
        return livroRepository.findById(id);
    }

    public void deletar(Long id){
        livroRepository.deleteById(id);
    }

    public void atulizar(Long id, LivroModels livroModels){
       LivroModels novoLivro = livroRepository.findById(id).get();
       novoLivro.setTitulo(livroModels.getTitulo());
       livroRepository.save(novoLivro);
    }

}
