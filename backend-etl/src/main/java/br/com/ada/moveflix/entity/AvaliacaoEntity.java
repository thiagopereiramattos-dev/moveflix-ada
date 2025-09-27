package br.com.ada.moveflix.entity;

import br.com.ada.moveflix.entity.raw.FilmeEntity;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "avaliacao_filme")
public class AvaliacaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_AVALIACAO", nullable = false)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ID_FILME", nullable = false)
    private FilmeEntity filme;

    @Column(name = "NOTA", nullable = false)
    private Integer nota;

    @Column(name = "COMENTARIO", length = 500)
    private String comentario;

    @Column(name = "DATA_AVALIACAO", nullable = false)
    private LocalDateTime dataAvaliacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FilmeEntity getFilme() {
        return filme;
    }

    public void setFilme(FilmeEntity filme) {
        this.filme = filme;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public LocalDateTime getDataAvaliacao() {
        return dataAvaliacao;
    }

    public void setDataAvaliacao(LocalDateTime dataAvaliacao) {
        this.dataAvaliacao = dataAvaliacao;
    }
}
