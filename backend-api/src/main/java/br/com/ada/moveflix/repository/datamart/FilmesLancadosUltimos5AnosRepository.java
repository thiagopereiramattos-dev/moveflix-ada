package br.com.ada.moveflix.repository.datamart;

import br.com.ada.moveflix.entity.datamart.FilmesLancadosUltimos5AnosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmesLancadosUltimos5AnosRepository extends JpaRepository<FilmesLancadosUltimos5AnosEntity, Integer> {
}
