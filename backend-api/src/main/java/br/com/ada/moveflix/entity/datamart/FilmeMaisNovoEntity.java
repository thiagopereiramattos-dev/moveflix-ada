package br.com.ada.moveflix.entity.datamart;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "top30_filmes_mais_novos", schema = "datamart")
public class FilmeMaisNovoEntity {

    @Id
    private Integer idFilme;

    private String nomeFilme;
    private Integer anoLancamento;
    private String nomeDiretor;
    private Double mediaAvaliacoes;

    // Getters e setters
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

    public Integer getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(Integer anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public String getNomeDiretor() {
        return nomeDiretor;
    }

    public void setNomeDiretor(String nomeDiretor) {
        this.nomeDiretor = nomeDiretor;
    }

    public Double getMediaAvaliacoes() {
        return mediaAvaliacoes;
    }

    public void setMediaAvaliacoes(Double mediaAvaliacoes) {
        this.mediaAvaliacoes = mediaAvaliacoes;
    }
}
