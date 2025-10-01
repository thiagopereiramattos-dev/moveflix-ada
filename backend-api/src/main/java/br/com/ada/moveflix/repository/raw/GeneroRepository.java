package br.com.ada.moveflix.repository.raw;

import br.com.ada.moveflix.entity.raw.GeneroEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GeneroRepository extends JpaRepository<GeneroEntity, Integer>{
    Optional<GeneroEntity> findById(Integer id);
    boolean existsById(Integer id);
}
