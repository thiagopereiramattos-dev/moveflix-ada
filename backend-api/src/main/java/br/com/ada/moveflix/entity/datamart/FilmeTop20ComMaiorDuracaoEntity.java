package br.com.ada.moveflix.entity.datamart;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "top20_filmes_maior_duracao", schema = "datamart")
public class FilmeTop20ComMaiorDuracaoEntity {

    @Id
    @Column(name = "id_filme")
    private Integer idFilme;

    @Column(name = "nome_filme")
    private String nomeFilme;

    @Column(name = "id_genero")
    private Integer idGenero;

    @Column(name = "genero")
    private String genero;

    @Column(name = "duracao")
    private Integer duracao;

    @Column(name = "posicao")
    private Integer posicao;

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

    public Integer getDuracao() {
        return duracao;
    }

    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }

    public Integer getPosicao() {
        return posicao;
    }

    public void setPosicao(Integer posicao) {
        this.posicao = posicao;
    }
}
