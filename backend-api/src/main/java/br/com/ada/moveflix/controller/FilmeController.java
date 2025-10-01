package br.com.ada.moveflix.controller;

import br.com.ada.moveflix.dto.ApiResponseDTO;
import br.com.ada.moveflix.dto.FilmeDTO;
import br.com.ada.moveflix.service.raw.FilmeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/filmes")
@Tag(name = "Filmes (RAW)", description = "Operações de CRUD sobre filmes brutos (schema raw).")
public class FilmeController {

    private final FilmeService filmeService;

    public FilmeController(FilmeService filmeService) {
        this.filmeService = filmeService;
    }

    @Operation(
            summary = "Cadastrar um novo filme",
            description = "Recebe um objeto FilmeDTO no corpo da requisição e insere no schema RAW.",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    required = true,
                    description = "Dados do filme a ser cadastrado",
                    content = @Content(
                            schema = @Schema(implementation = FilmeDTO.class),
                            examples = @ExampleObject(value = """
                        {
                          "nome": "Interestelar",
                          "descricaoFilme": "Um grupo de exploradores viaja através de um buraco de minhoca.",
                          "idGenero": 1,
                          "anoLancamento": 2014,
                          "nomeDiretor": "Christopher Nolan",
                          "duracao": 169,
                          "mediaAvaliacoes": 7.8
                        }
                        """)
                    )
            ),
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Filme cadastrado com sucesso"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Requisição inválida (campos obrigatórios ausentes ou inválidos)"
                    )
            }
    )
    @PostMapping
    public ResponseEntity<ApiResponseDTO> cadastrarFilme(@Valid @RequestBody FilmeDTO filmeDTO) {
        filmeService.cadastrarFilme(filmeDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponseDTO("Filme cadastrado com sucesso!", filmeDTO));
    }
}
