package br.com.ada.moveflix.dto;

import jakarta.validation.constraints.*;

public class FilmeDTO {

    @NotBlank(message = "O nome do filme é obrigatório.")
    @Size(max = 150, message = "O nome do filme deve ter no máximo 150 caracteres.")
    private String nome;

    @NotBlank(message = "A descrição do filme é obrigatória.")
    @Size(max = 500, message = "A descrição deve ter no máximo 500 caracteres.")
    private String descricaoFilme;

    @NotNull(message = "O gênero é obrigatório.")
    private Integer idGenero;

    @NotNull(message = "O ano de lançamento é obrigatório.")
    @Min(value = 1900, message = "O ano de lançamento deve ser maior ou igual a 1900.")
    @Max(value = 2100, message = "O ano de lançamento deve ser menor ou igual a 2100.")
    private Integer anoLancamento;

    @NotBlank(message = "O nome do diretor é obrigatório.")
    @Size(max = 100, message = "O nome do diretor deve ter no máximo 100 caracteres.")
    private String nomeDiretor;

    @NotNull(message = "A duração é obrigatória.")
    @Min(value = 1, message = "A duração deve ser maior que 0.")
    private Integer duracao;

    @NotNull(message = "A média das avaliações é obrigatória.")
    @DecimalMin(value = "1.0", inclusive = true, message = "A média das avaliações deve ser maior ou igual a 1.")
    @DecimalMax(value = "10.0", inclusive = true, message = "A média das avaliações deve ser menor ou igual a 10.")
    private Double mediaAvaliacoes;

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

    public Integer getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(Integer idGenero) {
        this.idGenero = idGenero;
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
}
