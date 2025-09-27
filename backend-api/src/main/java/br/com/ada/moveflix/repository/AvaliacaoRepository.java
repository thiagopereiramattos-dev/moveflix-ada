package br.com.ada.moveflix.repository;

import br.com.ada.moveflix.entity.AvaliacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AvaliacaoRepository extends JpaRepository<AvaliacaoEntity, Integer>{
    List<AvaliacaoEntity> findAllByNota(Integer nota);
}
