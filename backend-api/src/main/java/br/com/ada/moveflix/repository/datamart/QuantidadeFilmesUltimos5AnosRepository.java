package br.com.ada.moveflix.repository.datamart;

import br.com.ada.moveflix.entity.datamart.QuantidadeFilmesUltimos5AnosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuantidadeFilmesUltimos5AnosRepository extends JpaRepository<QuantidadeFilmesUltimos5AnosEntity, Integer> {
}
