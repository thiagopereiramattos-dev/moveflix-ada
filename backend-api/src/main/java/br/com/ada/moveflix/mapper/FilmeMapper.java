package br.com.ada.moveflix.mapper;

import br.com.ada.moveflix.dto.FilmeDTO;
import br.com.ada.moveflix.entity.raw.FilmeEntity;
import br.com.ada.moveflix.entity.raw.GeneroEntity;

public class FilmeMapper {

    public static FilmeEntity toEntity(FilmeDTO filmeDTO) {
        FilmeEntity entity = new FilmeEntity();
        entity.setCodigo(filmeDTO.getCodigo());
        entity.setNome(filmeDTO.getNome());
        entity.setDuracao(filmeDTO.getDuracao());
        entity.setDescricaoFilme(filmeDTO.getDescricaoFilme());
        entity.setAnoLancamento(filmeDTO.getAnoLancamento());

        GeneroEntity generoEntity = new GeneroEntity();
        generoEntity.setId(filmeDTO.getIdGenero());
        entity.setGenero(generoEntity);
        return entity;
    }

    public static FilmeDTO toDTO(FilmeEntity entity) {
        FilmeDTO dto = new FilmeDTO();
        dto.setCodigo(entity.getCodigo());
        dto.setNome(entity.getNome());
        dto.setDuracao(entity.getDuracao());
        dto.setDescricaoFilme(entity.getDescricaoFilme());
        dto.setAnoLancamento(entity.getAnoLancamento());

        if (entity.getGenero() != null) {
            dto.setIdGenero(entity.getGenero().getId());
        }

        return dto;
    }
}
