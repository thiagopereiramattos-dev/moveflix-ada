package br.com.ada.moveflix.web.controller;

import br.com.ada.moveflix.dto.FilmeDTO;
import br.com.ada.moveflix.service.raw.FilmeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/filmes")
public class FilmeController {

    private final FilmeService filmeService;

    public FilmeController(FilmeService filmeService) {
        this.filmeService = filmeService;
    }

    // POST /filmes
    @PostMapping
    public ResponseEntity<Void> cadastrarFilme(@RequestBody FilmeDTO filmeDTO) {
        filmeService.cadastrarFilme(filmeDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    // GET /filmes
    @GetMapping
    public ResponseEntity<List<FilmeDTO>> listarFilmes() {
        List<FilmeDTO> filmes = filmeService.listarFilmes();
        return ResponseEntity.ok(filmes);
    }


}

