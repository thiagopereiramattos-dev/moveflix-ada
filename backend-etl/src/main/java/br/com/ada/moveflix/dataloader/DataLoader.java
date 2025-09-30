package br.com.ada.moveflix.dataloader;

import br.com.ada.moveflix.service.datamart.DatamartViewService;
import br.com.ada.moveflix.service.raw.FilmeService;
import br.com.ada.moveflix.service.raw.GeneroService;
import br.com.ada.moveflix.service.etl.FilmeETLService;
import br.com.ada.moveflix.service.etl.GeneroETLService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Profile("!test")
public class DataLoader implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(DataLoader.class);
    private final GeneroService generoService;
    private final FilmeService filmeService;
    private final FilmeETLService filmeETLService;
    private final DatamartViewService datamartViewService;
    private final GeneroETLService generoETLService;
    private final ConfigurableApplicationContext context;

    public DataLoader(GeneroService generoService,
                      FilmeService filmeService,
                      FilmeETLService filmeETLService,
                      GeneroETLService generoETLService,
                      DatamartViewService datamartViewService,
                      ConfigurableApplicationContext context) {
        this.generoService = generoService;
        this.filmeService = filmeService;
        this.filmeETLService = filmeETLService;
        this.generoETLService = generoETLService;
        this.datamartViewService = datamartViewService;
        this.context = context;
    }

    @Autowired
    private Environment environment;

    @Override
    public void run(String... args) throws Exception {

        logger.info("🔍 Profiles ativos: {}", Arrays.toString(environment.getActiveProfiles()));

        generoService.importarCSV("csv/generos.csv");
        logger.info("✅ Importação de Genero finalizada com sucesso");

        filmeService.importarCSV("csv/filmes_bruto.csv");
        logger.info("✅ Importação de Filmes finalizada com sucesso");

        generoETLService.executarETL();
        logger.info("✅ ETL de Genero finalizado com sucesso");

        filmeETLService.executarETL();
        logger.info("✅ ETL de Filmes finalizado com sucesso");

//        datamartViewService.atualizarViewsDB();
//        logger.info("✅ Views do datamart atualizadas com sucesso");

        logger.info("🛑 Finalizando aplicação...");
        logger.info("🔍 Profile ativo: {}", System.getProperty("spring.profiles.active"));

        // Fecha o contexto do Spring e encerra a JVM com código de saída 0 (sucesso)
        int exitCode = SpringApplication.exit(context, () -> 0);
        System.exit(exitCode);

//        if (!"test".equals(System.getProperty("spring.profiles.active")) && (!"ci".equals(System.getProperty("spring.profiles.active")))) {
//            // Fecha o contexto do Spring e encerra a JVM com código de saída 0 (sucesso)
//            int exitCode = SpringApplication.exit(context, () -> 0);
//            System.exit(exitCode);
//            //SpringApplication.exit(context, () -> 0);
//        }
    }
}
