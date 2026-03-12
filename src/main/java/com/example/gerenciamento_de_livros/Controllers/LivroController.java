package com.example.gerenciamento_de_livros.Controllers;

import com.example.gerenciamento_de_livros.Models.LivroModels;
import com.example.gerenciamento_de_livros.Repository.LivroRepository;
import com.example.gerenciamento_de_livros.Services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/livraria")
public class LivroController {

    @Autowired
    private LivroService livroService;

    //Criar livro

    @PostMapping
    public ResponseEntity<LivroModels> cadastrar(@RequestBody LivroModels livroModels){
        LivroModels livro =  livroService.adicionar(livroModels);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(livro.getId())
                .toUri();

        return ResponseEntity.created(uri).body(livro);
    }

    // Listar todos livros
    @GetMapping
    public ResponseEntity<List<LivroModels>> buscarTudo(){
        List<LivroModels> request = livroService.buscarTudo();
        return ResponseEntity.ok(request);
    }

    // Buscar livro por id
    @GetMapping("/{id}")
    public ResponseEntity<LivroModels> buscarId(@PathVariable Long id) {
        LivroModels livros  = livroService.buscarId(id);
        return ResponseEntity.ok(livros);
    }

    // Atualizar livro
    @PutMapping("/{id}")
    public ResponseEntity<LivroModels> atualizarLivros(
        @PathVariable Long id,
        @RequestBody LivroModels livroModels) {

        LivroModels livroAtualizado = livroService.atulizar(id,livroModels);
        return ResponseEntity.ok(livroAtualizado);
    }

    // Deletar Livro
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarLivro(@PathVariable Long id){
        livroService.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
