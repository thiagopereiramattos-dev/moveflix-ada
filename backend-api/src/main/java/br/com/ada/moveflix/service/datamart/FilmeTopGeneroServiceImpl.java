package br.com.ada.moveflix.service.datamart;

import br.com.ada.moveflix.entity.datamart.FilmeTopGeneroEntity;
import br.com.ada.moveflix.repository.datamart.FilmeTopGeneroRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmeTopGeneroServiceImpl implements FilmeTopGeneroService {
    private static final Logger logger = LoggerFactory.getLogger(FilmeTopGeneroServiceImpl.class);

    private final FilmeTopGeneroRepository repository;

    public FilmeTopGeneroServiceImpl(FilmeTopGeneroRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<FilmeTopGeneroEntity> listarTop10PorGenero() {
        try {
            return repository.findAllByOrderByGeneroAscPosicaoAsc();
        } catch (Exception e) {
            logger.error("Erro ao listar top 10 filmes por gênero", e);
            throw new RuntimeException("Não foi possível obter os dados do top 10 filmes por gênero", e);
        }
    }
}
