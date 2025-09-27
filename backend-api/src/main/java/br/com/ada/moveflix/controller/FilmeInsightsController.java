package br.com.ada.moveflix.controller;

import br.com.ada.moveflix.entity.datamart.*;
import br.com.ada.moveflix.service.datamart.FilmeInsightsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/filmes_insights")
public class FilmeInsightsController {

    private final FilmeInsightsService filmeInsightsService;

    public FilmeInsightsController(FilmeInsightsService filmeInsightsService) {
        this.filmeInsightsService = filmeInsightsService;
    }

    @GetMapping("/top10-por-genero")
    public List<FilmeTopGeneroEntity> listarTop10PorGenero() {
        return filmeInsightsService.listarTop10PorGenero();
    }

    @GetMapping("/top20-maior-duracao")
    public List<FilmeTop20ComMaiorDuracaoEntity> listarTop20ComMaiorDuracao() {
        return filmeInsightsService.listarTop20ComMaiorDuracao();
    }

    @GetMapping("/top30-mais-novos")
    public List<FilmeMaisNovoEntity> listarTop30MaisNovos() {
        return filmeInsightsService.listarTop30MaisNovos();
    }

    @GetMapping("/top3-por-genero")
    public List<FilmeTop3GeneroEntity> listarTop3PorGenero() {
        return filmeInsightsService.listarTop3PorGenero();
    }

    @GetMapping("/top15-geral-avaliado")
    public List<FilmeTop15AvaliadoEntity> listarTop15GralAvaliado() {
        return filmeInsightsService.listarTop15Avaliado();
    }

    @GetMapping("/qtd-filmes-5-ultimos-anos")
    public List<QuantidadeFilmesUltimos5AnosEntity> listarQtdFilmesUltimos5Anos() {
        return filmeInsightsService.listarQtdFilmesUltimos5Anos();
    }

    @GetMapping("/listar-filmes-5-ultimos-anos")
    public List<FilmesLancadosUltimos5AnosEntity> listarFilmesLancadosUltimos5Anos() {
        return filmeInsightsService.listarFilmesLancadosUltimos5Anos();
    }
}

