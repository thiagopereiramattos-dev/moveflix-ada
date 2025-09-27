package br.com.ada.moveflix.service.datamart;

import br.com.ada.moveflix.entity.datamart.FilmeTopGeneroEntity;

import java.util.List;

public interface FilmeTopGeneroService {

    List<FilmeTopGeneroEntity> listarTop10PorGenero();
}
