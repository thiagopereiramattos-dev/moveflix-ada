package br.com.ada.moveflix.service.etl;


import br.com.ada.moveflix.entity.raw.FilmeEntity;
import br.com.ada.moveflix.entity.warehouse.FilmeWarehouseEntity;
import br.com.ada.moveflix.repository.raw.FilmeRepository;
import br.com.ada.moveflix.repository.warehouse.FilmeWarehouseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmeETLServiceImpl implements  FilmeETLService {
    private static final Logger logger = LoggerFactory.getLogger(FilmeETLService.class);

    private final FilmeRepository rawRepository;
    private final FilmeWarehouseRepository filmeWarehouseRepository;

    public FilmeETLServiceImpl(FilmeRepository rawRepository,
                           FilmeWarehouseRepository warehouseRepository) {
        this.rawRepository = rawRepository;
        this.filmeWarehouseRepository = warehouseRepository;
    }

    @Override
    public void executarETL() {
        logger.info("🚀 Iniciando processo ETL de filmes do schema raw para warehouse...");

        List<FilmeEntity> filmesRaw = rawRepository.findAll();
        int inseridos = 0;
        int repetidos = 0;
        int ignorados = 0;

        for (FilmeEntity raw : filmesRaw) {

            String nome = raw.getNome();
            if (nome == null || nome.isBlank()) {
                logger.warn("⚠️ Filme ignorado: nome inválido");
                ignorados++;
                continue;
            }

            if (filmeWarehouseRepository.existsByNome(nome)) {
                logger.info("ℹ️ Filme já existente no warehouse: {}", nome);
                repetidos++;
                continue;
            }

            if (dadosIncompletos(raw)) {
                logger.warn("⚠️ Filme ignorado por dados incompletos: {}", nome);
                ignorados++;
                continue;
            }

            // Transformação e carga
            FilmeWarehouseEntity filme = new FilmeWarehouseEntity();
            filme.setNome(nome.trim());
            filme.setDescricaoFilme(raw.getDescricaoFilme());
            filme.setAnoLancamento(raw.getAnoLancamento());
            filme.setNomeDiretor(raw.getNomeDiretor());
            filme.setDuracao(raw.getDuracao());
            filme.setMediaAvaliacoes(raw.getMediaAvaliacoes());
            filme.setIdGenero(raw.getGenero().getId());

            filmeWarehouseRepository.save(filme);
            inseridos++;
            logger.info("✔️ Filme ETL inserido: {}", nome);
        }

        logger.info("✅ ETL finalizado.");
        logger.info("📊 Relatório ETL → Inseridos: {} | Repetidos: {} | Ignorados: {}", inseridos, repetidos, ignorados);
    }

    private boolean dadosIncompletos(FilmeEntity raw) {
        return raw.getAnoLancamento() == null ||
                raw.getDuracao() == null ||
                raw.getNomeDiretor() == null || raw.getNomeDiretor().isBlank() ||
                raw.getMediaAvaliacoes() == null ||
                raw.getGenero() == null ||
                raw.getNome() == null || raw.getNome().isBlank();
    }

}
