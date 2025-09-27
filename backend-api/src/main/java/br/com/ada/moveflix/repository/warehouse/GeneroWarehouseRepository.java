package br.com.ada.moveflix.repository.warehouse;

import br.com.ada.moveflix.entity.warehouse.GeneroWarehouseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GeneroWarehouseRepository extends JpaRepository<GeneroWarehouseEntity, Integer>{
    Optional<GeneroWarehouseEntity> findById(Integer id);
    boolean existsById(Integer id);
    boolean existsByNome(String nome);
}
