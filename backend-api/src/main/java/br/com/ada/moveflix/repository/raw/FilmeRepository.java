package br.com.ada.moveflix.repository.raw;

import br.com.ada.moveflix.entity.raw.FilmeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FilmeRepository extends JpaRepository<FilmeEntity, Integer>{
    Optional<FilmeEntity> findByCodigo(Integer codigo);
    boolean existsByNome(String nome);
}
