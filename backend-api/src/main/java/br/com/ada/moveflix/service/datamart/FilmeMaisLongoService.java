package br.com.ada.moveflix.service.datamart;

import br.com.ada.moveflix.entity.datamart.FilmeTop20ComMaiorDuracaoEntity;
import java.util.List;

public interface FilmeMaisLongoService {
    List<FilmeTop20ComMaiorDuracaoEntity> listarTop20FilmesMaisLongos();
}
