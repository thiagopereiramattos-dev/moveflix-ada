package br.com.ada.moveflix.service.datamart;

import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

@Service
public class DatamartViewServiceImpl implements  DatamartViewService{

    private final JdbcTemplate jdbcTemplate;
    private final Environment environment;

    public DatamartViewServiceImpl(JdbcTemplate jdbcTemplate, Environment environment) {
        this.jdbcTemplate = jdbcTemplate;
        this.environment = environment;
    }


    @Override
    public void atualizarViewsDB() {
        try {
            String sqlFile = environment.acceptsProfiles("test")
                    ? "sql/datamart_views_db_h2.sql"
                    : "sql/datamart_views_db.sql";

            var resource = new ClassPathResource(sqlFile);
            String sql = Files.readString(resource.getFile().toPath(), StandardCharsets.UTF_8);

            for (String statement : sql.split(";")) {
                if (!statement.trim().isEmpty()) {
                    jdbcTemplate.execute(statement);
                }
            }

            System.out.println("✅ Views do datamart criadas ou atualizadas com sucesso!");
        } catch (Exception e) {
            System.err.println("❌ Erro ao atualizar views do datamart: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
