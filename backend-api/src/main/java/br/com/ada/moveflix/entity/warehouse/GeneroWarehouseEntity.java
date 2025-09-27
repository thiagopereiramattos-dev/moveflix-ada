package br.com.ada.moveflix.entity.warehouse;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "genero", schema = "warehouse")
public class GeneroWarehouseEntity {
    @Id
    @Column(name = "ID_GENERO", nullable = false)
    private Integer id;

    @Column(name = "NO_GENERO", length = 75, nullable = false)
    private String nome;

    @Column(name = "NO_GENERO_NORMALIZADO", length = 75, nullable = false)
    private String nomeSimplificado;

    @Column(name = "DESC_GENERO", length = 200, nullable = false)
    private String descricaoGenero;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricaoGenero() {
        return descricaoGenero;
    }

    public void setDescricaoGenero(String descricaoGenero) {
        this.descricaoGenero = descricaoGenero;
    }

    public String getNomeSimplificado() {
        return nomeSimplificado;
    }

    public void setNomeSimplificado(String nomeSimplificado) {
        this.nomeSimplificado = nomeSimplificado;
    }
}
