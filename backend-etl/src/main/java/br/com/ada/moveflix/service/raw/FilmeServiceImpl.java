package br.com.ada.moveflix.service.raw;

import br.com.ada.moveflix.dto.FilmeDTO;
import br.com.ada.moveflix.entity.raw.FilmeEntity;
import br.com.ada.moveflix.entity.raw.GeneroEntity;
import br.com.ada.moveflix.mapper.FilmeMapper;
import br.com.ada.moveflix.repository.raw.FilmeRepository;
import br.com.ada.moveflix.repository.raw.GeneroRepository;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Optional;

@Service
public class FilmeServiceImpl implements  FilmeService{

    private static final Logger logger = LoggerFactory.getLogger(FilmeServiceImpl.class);
    private final FilmeRepository filmeRepository;
    private final GeneroRepository generoRepository;

    public FilmeServiceImpl(FilmeRepository filmeRepository,GeneroRepository generoRepository) {
        this.filmeRepository = filmeRepository;
        this.generoRepository = generoRepository;
    }

    @Override
    public void importarCSV(String caminhoCsv) {
        int inseridos = 0;
        int jaExistentes = 0;

        logger.info("📥 Iniciando importação de filmes do arquivo: {}", caminhoCsv);
        String nomeFilme = "";
        String[] linhaErro= null;
        try (
                InputStreamReader reader = new InputStreamReader(new ClassPathResource(caminhoCsv).getInputStream());
                CSVReader csvReader = new CSVReader(reader)
        ) {
            String[] linha;
            csvReader.readNext();

            while ((linha = csvReader.readNext()) != null) {
                linhaErro = linha;
                if (linha.length == 0 || linha[0].trim().isEmpty()) {
                    continue;
                }

                nomeFilme = linha[4];

                int idGenero = Integer.parseInt(linha[6]);
                Optional<GeneroEntity> generoOptional = generoRepository.findById(idGenero);

                if (generoOptional.isPresent()) {
                    if (!filmeRepository.existsByNome(nomeFilme)) {
                        FilmeEntity filme = new FilmeEntity();
                        filme.setNome(nomeFilme);
                        filme.setDescricaoFilme(linha[1]);
                        filme.setAnoLancamento(parseNullableInteger(linha[0]));
                        filme.setNomeDiretor(linha[5]);
                        filme.setDuracao(parseNullableInteger(linha[2]));
                        filme.setMediaAvaliacoes(parseNullableDouble(linha[3]));

                        filme.setGenero(generoOptional.get());

                        filmeRepository.save(filme);
                        inseridos++;
                        logger.info("✔️ Filme adicionado: {}", nomeFilme);
                    }else{
                        jaExistentes++;
                        logger.info("ℹ️ Filme já existente: {}", nomeFilme);
                    }
                } else {
                    logger.warn("⚠️ Filme não encontrado. Filme '{}' não foi importado.", nomeFilme);
                }
            }

            logger.info("✅ Importação finalizada. Inseridos: {} | Já Existentes: {}", inseridos, jaExistentes);

        } catch (IOException | CsvValidationException e) {
            logger.error("❌ Erro ao importar o FILME: " +nomeFilme);
            logger.error("❌ Erro ao importar o CSV de Filmes: {}", e.getMessage(), e);
            throw new RuntimeException("Erro ao importar CSV", e);
        }catch (Exception ex){
            logger.error("❌ Erro ao importar o FILME: " + nomeFilme);
            throw new RuntimeException("Erro ao importar CSV", ex);
        }
    }

    @Override
    public void cadastrarFilme(FilmeDTO filmeDTO) {

        FilmeEntity filmeEntity = FilmeMapper.toEntity(filmeDTO);
        this.filmeRepository.save(filmeEntity);
    }

    @Override
    public List<FilmeDTO> listarFilmes() {
        List<FilmeEntity> filmes = this.filmeRepository.findAll();

        return filmes.stream()
                .map(FilmeMapper::toDTO)
                .toList();
    }

    private Integer parseNullableInteger(String valor) {
        if (valor == null || valor.isBlank()) {
            return null;
        }
        return Integer.parseInt(valor.trim());
    }

    private Double parseNullableDouble(String valor) {
        if (valor == null || valor.isBlank()) {
            return null;
        }
        return Double.parseDouble(valor.trim());
    }

}
