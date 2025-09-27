package br.com.ada.moveflix.service.datamart;

import br.com.ada.moveflix.entity.datamart.*;

import java.util.List;

public interface FilmeInsightsService {
    List<FilmeTop20ComMaiorDuracaoEntity> listarTop20ComMaiorDuracao();
    List<FilmeTopGeneroEntity> listarTop10PorGenero();
    List<FilmeMaisNovoEntity> listarTop30MaisNovos();
    List<FilmeTop3GeneroEntity> listarTop3PorGenero();
    List<FilmeTop15AvaliadoEntity> listarTop15Avaliado();
    List<QuantidadeFilmesUltimos5AnosEntity> listarQtdFilmesUltimos5Anos();
    List<FilmesLancadosUltimos5AnosEntity> listarFilmesLancadosUltimos5Anos();

}
