package br.com.ada.moveflix.service.datamart;

import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

@Service
public class DatamartViewServiceImpl implements  DatamartViewService{

    private final JdbcTemplate jdbcTemplate;

    public DatamartViewServiceImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public void atualizarViewsDB() {
        try {
            var resource = new ClassPathResource("sql/datamart_views_db.sql");
            String sql = Files.readString(resource.getFile().toPath(), StandardCharsets.UTF_8);
            jdbcTemplate.execute(sql);
            System.out.println("✅ Views do datamart criadas ou atualizadas com sucesso!");
        } catch (Exception e) {
            System.err.println("❌ Erro ao atualizar views do datamart: " + e.getMessage());
        }
    }
}
