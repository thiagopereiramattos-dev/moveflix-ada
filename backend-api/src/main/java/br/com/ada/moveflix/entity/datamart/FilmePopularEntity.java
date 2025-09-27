package br.com.ada.moveflix.entity.datamart;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "filmes_populares", schema = "datamart")
public class FilmePopularEntity {
    @Id
    private Integer idFilme;
    private String nomeFilme;
    private Double mediaAvaliacoes;

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
}
