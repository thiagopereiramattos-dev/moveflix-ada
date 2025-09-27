package br.com.ada.moveflix.repository.datamart;

import br.com.ada.moveflix.entity.datamart.FilmeTop3GeneroEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FilmeTop3GeneroRepository extends JpaRepository<FilmeTop3GeneroEntity, Integer> {
    List<FilmeTop3GeneroEntity> findAllByOrderByPosicaoAsc();
}
