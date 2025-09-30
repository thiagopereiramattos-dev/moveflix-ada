package br.com.ada.moveflix.controller;

import br.com.ada.moveflix.entity.datamart.*;
import br.com.ada.moveflix.service.datamart.FilmeInsightsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/filmes_insights")
@Tag(name = "Filmes Insights", description = "Endpoints de consultas analíticas sobre filmes")
public class FilmeInsightsController {

    private final FilmeInsightsService filmeInsightsService;

    public FilmeInsightsController(FilmeInsightsService filmeInsightsService) {
        this.filmeInsightsService = filmeInsightsService;
    }

    @Operation(summary = "Top 10 por gênero", description = "Lista os 10 filmes mais populares por gênero")
    @ApiResponse(
            responseCode = "200",
            description = "Lista de filmes por gênero retornada com sucesso",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = FilmeTopGeneroEntity.class),
                    examples = @ExampleObject(
                            value = "[{\n" +
                                    "  \"idFilme\": 1,\n" +
                                    "  \"nomeFilme\": \"Matrix\",\n" +
                                    "  \"idGenero\": 10,\n" +
                                    "  \"genero\": \"Ficção Científica\",\n" +
                                    "  \"posicao\": 1\n" +
                                    "}]"
                    )
            )
    )
    @GetMapping("/top10-por-genero")
    public List<FilmeTopGeneroEntity> listarTop10PorGenero() {
        return filmeInsightsService.listarTop10PorGenero();
    }

    @Operation(summary = "Top 20 maior duração", description = "Lista os 20 filmes com maior tempo de duração")
    @ApiResponse(
            responseCode = "200",
            description = "Lista de filmes retornada com sucesso",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = FilmeTop20ComMaiorDuracaoEntity.class),
                    examples = @ExampleObject(
                            value = "[{\n" +
                                    "  \"idFilme\": 101,\n" +
                                    "  \"nomeFilme\": \"O Poderoso Chefão\",\n" +
                                    "  \"idGenero\": 1,\n" +
                                    "  \"genero\": \"Drama\",\n" +
                                    "  \"duracao\": 175,\n" +
                                    "  \"posicao\": 1\n" +
                                    "}]"
                    )
            )
    )
    @GetMapping("/top20-maior-duracao")
    public List<FilmeTop20ComMaiorDuracaoEntity> listarTop20ComMaiorDuracao() {
        return filmeInsightsService.listarTop20ComMaiorDuracao();
    }

    @Operation(summary = "Top 30 filmes mais novos", description = "Lista os 30 filmes mais recentes lançados")
    @ApiResponse(
            responseCode = "200",
            description = "Lista de filmes mais novos retornada com sucesso",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = FilmeMaisNovoEntity.class),
                    examples = @ExampleObject(
                            value = "[{\n" +
                                    "  \"idFilme\": 200,\n" +
                                    "  \"nomeFilme\": \"Duna\",\n" +
                                    "  \"anoLancamento\": 2021,\n" +
                                    "  \"posicao\": 1\n" +
                                    "}]"
                    )
            )
    )
    @GetMapping("/top30-mais-novos")
    public List<FilmeMaisNovoEntity> listarTop30MaisNovos() {
        return filmeInsightsService.listarTop30MaisNovos();
    }

    @Operation(summary = "Top 3 por gênero", description = "Lista os 3 filmes mais populares de cada gênero")
    @ApiResponse(
            responseCode = "200",
            description = "Lista de filmes por gênero retornada com sucesso",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = FilmeTop3GeneroEntity.class),
                    examples = @ExampleObject(
                            value = "[{\n" +
                                    "  \"idFilme\": 11,\n" +
                                    "  \"nomeFilme\": \"Vingadores: Ultimato\",\n" +
                                    "  \"idGenero\": 2,\n" +
                                    "  \"genero\": \"Ação\",\n" +
                                    "  \"posicao\": 1\n" +
                                    "}]"
                    )
            )
    )
    @GetMapping("/top3-por-genero")
    public List<FilmeTop3GeneroEntity> listarTop3PorGenero() {
        return filmeInsightsService.listarTop3PorGenero();
    }

    @Operation(summary = "Top 15 geral mais bem avaliados", description = "Lista os 15 filmes com melhores avaliações")
    @ApiResponse(
            responseCode = "200",
            description = "Lista de filmes mais bem avaliados retornada com sucesso",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = FilmeTop15AvaliadoEntity.class),
                    examples = @ExampleObject(
                            value = "[{\n" +
                                    "  \"idFilme\": 301,\n" +
                                    "  \"nomeFilme\": \"A Origem\",\n" +
                                    "  \"nota\": 9.2,\n" +
                                    "  \"posicao\": 1\n" +
                                    "}]"
                    )
            )
    )
    @GetMapping("/top15-geral-avaliado")
    public List<FilmeTop15AvaliadoEntity> listarTop15GralAvaliado() {
        return filmeInsightsService.listarTop15Avaliado();
    }

    @Operation(summary = "Quantidade de filmes nos últimos 5 anos", description = "Retorna a quantidade de filmes lançados nos últimos 5 anos")
    @ApiResponse(
            responseCode = "200",
            description = "Quantidade por ano retornada com sucesso",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = QuantidadeFilmesUltimos5AnosEntity.class),
                    examples = @ExampleObject(
                            value = "[{\n" +
                                    "  \"anoLancamento\": 2020,\n" +
                                    "  \"quantidade\": 35\n" +
                                    "}, {\n" +
                                    "  \"anoLancamento\": 2021,\n" +
                                    "  \"quantidade\": 42\n" +
                                    "}]"
                    )
            )
    )
    @GetMapping("/qtd-filmes-5-ultimos-anos")
    public List<QuantidadeFilmesUltimos5AnosEntity> listarQtdFilmesUltimos5Anos() {
        return filmeInsightsService.listarQtdFilmesUltimos5Anos();
    }

    @Operation(summary = "Lista de filmes lançados nos últimos 5 anos", description = "Retorna os filmes lançados nos últimos 5 anos")
    @ApiResponse(
            responseCode = "200",
            description = "Lista de filmes dos últimos 5 anos retornada com sucesso",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = FilmesLancadosUltimos5AnosEntity.class),
                    examples = @ExampleObject(
                            value = "[{\n" +
                                    "  \"idFilme\": 400,\n" +
                                    "  \"nomeFilme\": \"Interestelar\",\n" +
                                    "  \"anoLancamento\": 2019\n" +
                                    "}]"
                    )
            )
    )
    @GetMapping("/listar-filmes-5-ultimos-anos")
    public List<FilmesLancadosUltimos5AnosEntity> listarFilmesLancadosUltimos5Anos() {
        return filmeInsightsService.listarFilmesLancadosUltimos5Anos();
    }
}
