package br.com.ada.moveflix.repository.datamart;

import br.com.ada.moveflix.entity.datamart.FilmeTop20ComMaiorDuracaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FilmeTop20MaiorDuracaoRepository extends JpaRepository<FilmeTop20ComMaiorDuracaoEntity, Integer> {

    List<FilmeTop20ComMaiorDuracaoEntity> findAllByOrderByPosicaoAsc();

}
