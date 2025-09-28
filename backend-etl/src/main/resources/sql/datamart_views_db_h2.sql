-- View: datamart.filmes_ultimos_5_anos

DROP VIEW IF EXISTS datamart.filmes_ultimos_5_anos;

CREATE VIEW datamart.filmes_ultimos_5_anos AS
 SELECT f.co_filme AS id_filme,
    f.no_filme AS nome_filme,
    f.ano_lancamento,
    f.id_genero,
    g.no_genero AS genero,
    f.media_avaliacoes
   FROM warehouse.filme f
     JOIN warehouse.genero g ON g.id_genero = f.id_genero
  WHERE CAST(f.ano_lancamento AS numeric) >= (YEAR(CURRENT_DATE) - 4)
  ORDER BY f.ano_lancamento DESC, f.media_avaliacoes DESC;


-- View: datamart.quantidade_filmes_ultimos_5_anos

DROP VIEW IF EXISTS datamart.quantidade_filmes_ultimos_5_anos;

CREATE VIEW datamart.quantidade_filmes_ultimos_5_anos AS
 SELECT ano_lancamento,
    count(*) AS quantidade
   FROM warehouse.filme
  WHERE CAST(ano_lancamento AS numeric) >= (YEAR(CURRENT_DATE) - 4)
  GROUP BY ano_lancamento
  ORDER BY ano_lancamento DESC;


-- View: datamart.top3_filmes_por_genero

DROP VIEW IF EXISTS datamart.top3_filmes_por_genero;

CREATE VIEW datamart.top3_filmes_por_genero AS
 SELECT id_genero,
    genero,
    id_filme,
    nome_filme,
    media_avaliacoes,
    posicao
   FROM ( SELECT f.id_genero,
            g.no_genero AS genero,
            f.co_filme AS id_filme,
            f.no_filme AS nome_filme,
            f.media_avaliacoes,
            row_number() OVER (PARTITION BY f.id_genero ORDER BY f.media_avaliacoes DESC) AS posicao
           FROM warehouse.filme f
             JOIN warehouse.genero g ON g.id_genero = f.id_genero
          WHERE f.media_avaliacoes IS NOT NULL) sub
  WHERE posicao <= 3;


-- View: datamart.top10_filmes_por_genero

DROP VIEW IF EXISTS datamart.top10_filmes_por_genero;

CREATE VIEW datamart.top10_filmes_por_genero AS
 SELECT id_genero,
    genero,
    id_filme,
    nome_filme,
    media_avaliacoes,
    posicao
   FROM ( SELECT f.id_genero,
            g.no_genero AS genero,
            f.co_filme AS id_filme,
            f.no_filme AS nome_filme,
            f.media_avaliacoes,
            rank() OVER (PARTITION BY f.id_genero ORDER BY f.media_avaliacoes DESC) AS posicao
           FROM warehouse.filme f
             JOIN warehouse.genero g ON g.id_genero = f.id_genero
          WHERE f.media_avaliacoes IS NOT NULL) sub
  WHERE posicao <= 10;


-- View: datamart.top15_melhores_avaliados

DROP VIEW IF EXISTS datamart.top15_melhores_avaliados;

CREATE VIEW datamart.top15_melhores_avaliados AS
 SELECT f.co_filme AS id_filme,
    f.no_filme AS nome_filme,
    f.media_avaliacoes,
    f.ano_lancamento,
    f.nome_diretor,
    g.no_genero AS genero
   FROM warehouse.filme f
     JOIN warehouse.genero g ON g.id_genero = f.id_genero
  WHERE f.media_avaliacoes IS NOT NULL
  ORDER BY f.media_avaliacoes DESC
 LIMIT 15;


-- View: datamart.top20_filmes_maior_duracao

DROP VIEW IF EXISTS datamart.top20_filmes_maior_duracao;

CREATE VIEW datamart.top20_filmes_maior_duracao AS
 SELECT f.co_filme AS id_filme,
    f.no_filme AS nome_filme,
    f.id_genero,
    g.no_genero AS genero,
    f.duracao,
    rank() OVER (ORDER BY f.duracao DESC) AS posicao
   FROM warehouse.filme f
     JOIN warehouse.genero g ON g.id_genero = f.id_genero
  WHERE f.duracao IS NOT NULL
  ORDER BY f.duracao DESC
 LIMIT 20;


-- View: datamart.top30_filmes_mais_novos

DROP VIEW IF EXISTS datamart.top30_filmes_mais_novos;

CREATE VIEW datamart.top30_filmes_mais_novos AS
 SELECT co_filme AS id_filme,
    no_filme AS nome_filme,
    ano_lancamento,
    nome_diretor,
    media_avaliacoes
   FROM warehouse.filme f
  WHERE ano_lancamento IS NOT NULL
  ORDER BY ano_lancamento DESC
 LIMIT 30;
