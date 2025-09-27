package br.com.ada.moveflix.repository.datamart;

import br.com.ada.moveflix.entity.datamart.FilmeTopGeneroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmeTopGeneroRepository extends JpaRepository<FilmeTopGeneroEntity, Integer> {

    List<FilmeTopGeneroEntity> findAllByOrderByGeneroAscPosicaoAsc();

}
