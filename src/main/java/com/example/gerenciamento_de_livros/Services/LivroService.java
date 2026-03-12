package com.example.gerenciamento_de_livros.Services;
import com.example.gerenciamento_de_livros.Models.LivroModels;
import com.example.gerenciamento_de_livros.Repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public LivroModels buscarId(Long id){
        return livroRepository.findById(id).orElse(null);
    }

    public void deletar(Long id){
        livroRepository.deleteById(id);
    }

    public LivroModels atulizar(Long id, LivroModels livroModels){
       LivroModels novoLivro = livroRepository.findById(id).orElse(null);
       novoLivro.setTitulo(livroModels.getTitulo());
       return livroRepository.save(novoLivro);
    }

}
