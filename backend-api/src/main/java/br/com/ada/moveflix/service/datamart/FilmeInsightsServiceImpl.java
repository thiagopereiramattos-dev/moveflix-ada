package br.com.ada.moveflix.service.datamart;

import br.com.ada.moveflix.entity.datamart.*;
import br.com.ada.moveflix.repository.datamart.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmeInsightsServiceImpl implements FilmeInsightsService {

    private final FilmeTopGeneroRepository filmeTopGeneroRepository;
    private final FilmeTop20MaiorDuracaoRepository filmeMaisLongoRepository;
    private final FilmeMaisNovoRepository filmeMaisNovoRepository;
    private final FilmeTop3GeneroRepository filmeTop3GeneroRepository;
    private final FilmeTop15AvaliadoRepository filmeTop15AvaliadoRepository;

    private final QuantidadeFilmesUltimos5AnosRepository quantidadeFilmesUltimos5AnosRepository;
    private final FilmesLancadosUltimos5AnosRepository filmesLancadosUltimos5AnosRepository;

    public FilmeInsightsServiceImpl(
            FilmeTopGeneroRepository filmeTopGeneroRepository,
            FilmeTop20MaiorDuracaoRepository filmeMaisLongoRepository,
            FilmeMaisNovoRepository filmeMaisNovoRepository,
            FilmeTop3GeneroRepository filmeTop3GeneroRepository,
            FilmeTop15AvaliadoRepository filmeTop15AvaliadoRepository,
            QuantidadeFilmesUltimos5AnosRepository quantidadeFilmesUltimos5AnosRepository,
            FilmesLancadosUltimos5AnosRepository filmesLancadosUltimos5AnosRepository
    ) {
        this.filmeTopGeneroRepository = filmeTopGeneroRepository;
        this.filmeMaisLongoRepository = filmeMaisLongoRepository;
        this.filmeMaisNovoRepository = filmeMaisNovoRepository;
        this.filmeTop3GeneroRepository = filmeTop3GeneroRepository;
        this.filmeTop15AvaliadoRepository = filmeTop15AvaliadoRepository;
        this.quantidadeFilmesUltimos5AnosRepository = quantidadeFilmesUltimos5AnosRepository;
        this.filmesLancadosUltimos5AnosRepository = filmesLancadosUltimos5AnosRepository;
    }

    @Override
    public List<FilmeTop20ComMaiorDuracaoEntity> listarTop20ComMaiorDuracao() {
        return filmeMaisLongoRepository.findAllByOrderByPosicaoAsc();
    }

    @Override
    public List<FilmeTopGeneroEntity> listarTop10PorGenero() {
        return filmeTopGeneroRepository.findAllByOrderByGeneroAscPosicaoAsc();
    }

    @Override
    public List<FilmeMaisNovoEntity> listarTop30MaisNovos() {
        return filmeMaisNovoRepository.findAll();
    }

    @Override
    public List<FilmeTop3GeneroEntity> listarTop3PorGenero() {
        return filmeTop3GeneroRepository.findAllByOrderByPosicaoAsc();
    }

    @Override
    public List<FilmeTop15AvaliadoEntity> listarTop15Avaliado() {
        return filmeTop15AvaliadoRepository.findAll();
    }

    @Override
    public List<QuantidadeFilmesUltimos5AnosEntity> listarQtdFilmesUltimos5Anos() {
        return quantidadeFilmesUltimos5AnosRepository.findAll();
    }

    @Override
    public List<FilmesLancadosUltimos5AnosEntity> listarFilmesLancadosUltimos5Anos() {
        return filmesLancadosUltimos5AnosRepository.findAll();
    }

}
