package br.com.ada.moveflix.projection;

public interface FilmeTopGeneroProjection {
    Integer getIdGenero();
    String getGenero();
    Integer getIdFilme();
    String getNomeFilme();
    Double getMediaAvaliacoes();
    Integer getPosicao();
}
