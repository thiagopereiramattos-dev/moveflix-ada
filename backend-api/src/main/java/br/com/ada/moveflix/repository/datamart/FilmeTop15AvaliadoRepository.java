package br.com.ada.moveflix.repository.datamart;

import br.com.ada.moveflix.entity.datamart.FilmeTop15AvaliadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  FilmeTop15AvaliadoRepository extends JpaRepository<FilmeTop15AvaliadoEntity, Integer> {
}