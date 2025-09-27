package br.com.ada.moveflix.repository.warehouse;

import br.com.ada.moveflix.entity.warehouse.FilmeWarehouseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmeWarehouseRepository extends JpaRepository<FilmeWarehouseEntity, Integer> {
    boolean existsByNome(String nome);
}