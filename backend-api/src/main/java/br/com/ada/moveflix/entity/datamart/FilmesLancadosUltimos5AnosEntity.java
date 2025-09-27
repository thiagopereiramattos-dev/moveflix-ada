package br.com.ada.moveflix.entity.datamart;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "filmes_ultimos_5_anos", schema = "datamart")
public class FilmesLancadosUltimos5AnosEntity {

    @Id
    @Column(name = "id_filme")  // co_filme na warehouse
    private Integer idFilme;

    @Column(name = "nome_filme")
    private String nomeFilme;

    @Column(name = "ano_lancamento")
    private Integer anoLancamento;

    @Column(name = "id_genero")
    private Integer idGenero;

    @Column(name = "genero")
    private String genero;

    @Column(name = "media_avaliacoes")
    private Double mediaAvaliacoes;


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

}
