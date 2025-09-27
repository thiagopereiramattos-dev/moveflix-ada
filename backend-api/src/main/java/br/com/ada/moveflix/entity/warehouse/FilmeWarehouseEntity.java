package br.com.ada.moveflix.entity.warehouse;

import jakarta.persistence.*;

@Entity
@Table(name = "filme", schema = "warehouse")
public class FilmeWarehouseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CO_FILME", nullable = false)
    private Integer codigo;

    @Column(name = "NO_FILME", length = 200, nullable = false)
    private String nome;

    @Column(name = "DESC_FILME", length = 200)
    private String descricaoFilme;

    @Column(name = "ANO_LANCAMENTO", length = 4)
    private Integer anoLancamento;

    @Column(name = "NOME_DIRETOR", length = 200)
    private String nomeDiretor;

    @Column(name = "DURACAO", length = 4)
    private Integer duracao;

    @Column(name = "MEDIA_AVALIACOES", length = 4)
    private Double mediaAvaliacoes;

    @Column(name = "ID_GENERO")
    private Integer idGenero;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricaoFilme() {
        return descricaoFilme;
    }

    public void setDescricaoFilme(String descricaoFilme) {
        this.descricaoFilme = descricaoFilme;
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

    public Integer getDuracao() {
        return duracao;
    }

    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }

    public Double getMediaAvaliacoes() {
        return mediaAvaliacoes;
    }

    public void setMediaAvaliacoes(Double mediaAvaliacoes) {
        this.mediaAvaliacoes = mediaAvaliacoes;
    }

    public Integer getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(Integer idGenero) {
        this.idGenero = idGenero;
    }
}
