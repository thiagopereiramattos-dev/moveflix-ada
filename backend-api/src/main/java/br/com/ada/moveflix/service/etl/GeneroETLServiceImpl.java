package br.com.ada.moveflix.service.etl;


import br.com.ada.moveflix.entity.raw.GeneroEntity;
import br.com.ada.moveflix.entity.warehouse.GeneroWarehouseEntity;
import br.com.ada.moveflix.repository.raw.GeneroRepository;
import br.com.ada.moveflix.repository.warehouse.GeneroWarehouseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneroETLServiceImpl implements  GeneroETLService {
    private static final Logger logger = LoggerFactory.getLogger(GeneroETLServiceImpl.class);

    private final GeneroRepository rawRepository;
    private final GeneroWarehouseRepository warehouseRepository;

    public GeneroETLServiceImpl(GeneroRepository rawRepository, GeneroWarehouseRepository warehouseRepository) {
        this.rawRepository = rawRepository;
        this.warehouseRepository = warehouseRepository;
    }

    public void executarETL() {
        logger.info("🚀 Iniciando ETL de Gêneros do raw para o warehouse...");

        List<GeneroEntity> generosRaw = rawRepository.findAll();
        int inseridos = 0;
        int repetidos = 0;

        for (GeneroEntity raw : generosRaw) {
            if (warehouseRepository.existsById(raw.getId())) {
                logger.info("ℹ️ Gênero já existe no warehouse: {}", raw.getNome());
                repetidos++;
                continue;
            }

            GeneroWarehouseEntity generoWarehouseEntity = new GeneroWarehouseEntity();
            generoWarehouseEntity.setId(raw.getId());
            generoWarehouseEntity.setNome(raw.getNome());
            generoWarehouseEntity.setNomeSimplificado(raw.getNomeSimplificado());
            generoWarehouseEntity.setDescricaoGenero(raw.getDescricaoGenero());

            warehouseRepository.save(generoWarehouseEntity);
            inseridos++;
            logger.info("✔️ Gênero ETL inserido: {}", raw.getNome());
        }

        logger.info("✅ ETL de Gêneros finalizado. Inseridos: {} | Repetidos: {}", inseridos, repetidos);
    }
}
