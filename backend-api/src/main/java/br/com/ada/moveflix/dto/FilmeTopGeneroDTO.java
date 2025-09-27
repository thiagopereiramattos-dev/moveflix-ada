package br.com.ada.moveflix.dto;

public class FilmeTopGeneroDTO {

    private Integer idGenero;
    private String genero;
    private Integer idFilme;
    private String nomeFilme;
    private Double mediaAvaliacoes;
    private Integer posicao;

    public FilmeTopGeneroDTO(Integer idGenero, String genero, Integer idFilme, String nomeFilme, Double mediaAvaliacoes, Integer posicao) {
        this.idGenero = idGenero;
        this.genero = genero;
        this.idFilme = idFilme;
        this.nomeFilme = nomeFilme;
        this.mediaAvaliacoes = mediaAvaliacoes;
        this.posicao = posicao;
    }

    // Getters e setters

    public Integer getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(Integer idGenero) {
        this.idGenero = idGenero;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getIdFilme() {
        return idFilme;
    }

    public void setIdFilme(Integer idFilme) {
        this.idFilme = idFilme;
    }

    public String getNomeFilme() {
        return nomeFilme;
    }

    public void setNomeFilme(String nomeFilme) {
        this.nomeFilme = nomeFilme;
    }

    public Double getMediaAvaliacoes() {
        return mediaAvaliacoes;
    }

    public void setMediaAvaliacoes(Double mediaAvaliacoes) {
        this.mediaAvaliacoes = mediaAvaliacoes;
    }

    public Integer getPosicao() {
        return posicao;
    }

    public void setPosicao(Integer posicao) {
        this.posicao = posicao;
    }
}
