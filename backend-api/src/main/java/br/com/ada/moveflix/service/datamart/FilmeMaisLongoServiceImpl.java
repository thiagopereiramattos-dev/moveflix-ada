package br.com.ada.moveflix.service.datamart;

import br.com.ada.moveflix.entity.datamart.FilmeTop20ComMaiorDuracaoEntity;
import br.com.ada.moveflix.repository.datamart.FilmeTop20MaiorDuracaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmeMaisLongoServiceImpl implements FilmeMaisLongoService {

    private final FilmeTop20MaiorDuracaoRepository repository;

    public FilmeMaisLongoServiceImpl(FilmeTop20MaiorDuracaoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<FilmeTop20ComMaiorDuracaoEntity> listarTop20FilmesMaisLongos() {
        return repository.findAllByOrderByPosicaoAsc();
    }
}
