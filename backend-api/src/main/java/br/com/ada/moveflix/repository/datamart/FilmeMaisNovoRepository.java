package br.com.ada.moveflix.repository.datamart;

import br.com.ada.moveflix.entity.datamart.FilmeMaisNovoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmeMaisNovoRepository extends JpaRepository<FilmeMaisNovoEntity, Integer> {
}
