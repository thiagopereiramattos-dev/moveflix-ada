package br.com.ada.moveflix.entity.datamart;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "top3_filmes_por_genero", schema = "datamart")
public class FilmeTop3GeneroEntity {

    @Id
    private Integer idFilme;

    private Integer idGenero;
    private String genero;
    private String nomeFilme;
    private Double mediaAvaliacoes;
    private Integer posicao;

    // Getters e Setters

    public Integer getIdFilme() {
        return idFilme;
    }

    public void setIdFilme(Integer idFilme) {
        this.idFilme = idFilme;
    }

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
