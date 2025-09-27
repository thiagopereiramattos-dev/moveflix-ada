package br.com.ada.moveflix.service.raw;

import br.com.ada.moveflix.dto.FilmeDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface FilmeService {

    void importarCSV(String caminhoCsv);
    void cadastrarFilme(FilmeDTO filmeDTO);

    List<FilmeDTO> listarFilmes();


}
