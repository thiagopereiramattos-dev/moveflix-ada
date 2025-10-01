package br.com.ada.moveflix.service.raw;

import br.com.ada.moveflix.dto.FilmeDTO;
import br.com.ada.moveflix.entity.raw.FilmeEntity;
import br.com.ada.moveflix.entity.raw.GeneroEntity;
import br.com.ada.moveflix.exception.GeneroInvalidoException;
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
    public void cadastrarFilme(FilmeDTO filmeDTO) {

        boolean generoExiste = generoRepository.existsById(filmeDTO.getIdGenero());
        if (!generoExiste) {
            throw new GeneroInvalidoException("ID de gênero inválido: " + filmeDTO.getIdGenero());
        }

        FilmeEntity filmeEntity = FilmeMapper.toEntity(filmeDTO);
        this.filmeRepository.save(filmeEntity);
    }
}
