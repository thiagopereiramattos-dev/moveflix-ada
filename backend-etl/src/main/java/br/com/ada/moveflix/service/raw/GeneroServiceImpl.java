package br.com.ada.moveflix.service.raw;

import br.com.ada.moveflix.entity.raw.GeneroEntity;
import br.com.ada.moveflix.repository.raw.GeneroRepository;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStreamReader;

@Service
public class GeneroServiceImpl implements  GeneroService{

    private static final Logger logger = LoggerFactory.getLogger(GeneroServiceImpl.class);

    private final GeneroRepository generoRepository;

    public GeneroServiceImpl(GeneroRepository generoRepository) {
        this.generoRepository = generoRepository;
    }

    @Override
    public void importarCSV(String caminhoCsv) {
        int inseridos = 0;
        int jaExistentes = 0;

        logger.info("📥 Iniciando importação de gêneros do arquivo: {}", caminhoCsv);

        try (
                InputStreamReader reader = new InputStreamReader(new ClassPathResource(caminhoCsv).getInputStream());
                CSVReader csvReader = new CSVReader(reader)
        ) {
            String[] linha;
            csvReader.readNext(); // pula o cabeçalho

            while ((linha = csvReader.readNext()) != null) {
                if (linha.length == 0 || linha[0].trim().isEmpty()) {
                    continue;
                }

                Integer idGenero = Integer.parseInt(linha[0]);
                String nomeGenero = linha[1];

                if (!generoRepository.existsById(idGenero)) {
                    GeneroEntity genero = new GeneroEntity();
                    genero.setId(idGenero);
                    genero.setNome(nomeGenero);
                    genero.setNomeSimplificado(linha[2]);
                    genero.setDescricaoGenero(linha[3]);

                    generoRepository.save(genero);
                    inseridos++;
                    logger.info("✔️ Gênero adicionado: {} (ID: {})", nomeGenero, idGenero);
                } else {
                    jaExistentes++;
                    logger.info("ℹ️ Gênero já existente: {} (ID: {})", nomeGenero, idGenero);
                }
            }

            logger.info("✅ Importação finalizada. Inseridos: {} | Já Existentes: {}", inseridos, jaExistentes);

        } catch (IOException | CsvValidationException e) {
            logger.error("❌ Erro ao importar o CSV de Genero: {}", e.getMessage(), e);
            throw new RuntimeException("Erro ao importar CSV", e);
        }
    }

}
