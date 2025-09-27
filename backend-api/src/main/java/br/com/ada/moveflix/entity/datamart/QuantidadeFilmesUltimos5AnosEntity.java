package br.com.ada.moveflix.entity.datamart;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "quantidade_filmes_ultimos_5_anos", schema = "datamart")
public class QuantidadeFilmesUltimos5AnosEntity {

    @Id
    private Integer anoLancamento;
    private Long quantidade;

    public Integer getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(Integer anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }
}
