package br.com.ada.moveflix.dataloader;

import br.com.ada.moveflix.service.datamart.DatamartViewService;
import br.com.ada.moveflix.service.raw.FilmeService;
import br.com.ada.moveflix.service.raw.GeneroService;
import br.com.ada.moveflix.service.etl.FilmeETLService;
import br.com.ada.moveflix.service.etl.GeneroETLService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@Component
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

    @Override
    public void run(String... args) throws Exception {
        generoService.importarCSV("csv/generos.csv");
        logger.info("✅ Importação de Genero finalizada com sucesso");

        filmeService.importarCSV("csv/filmes_bruto.csv");
        logger.info("✅ Importação de Filmes finalizada com sucesso");

        generoETLService.executarETL();
        logger.info("✅ ETL de Genero finalizado com sucesso");

        filmeETLService.executarETL();
        logger.info("✅ ETL de Filmes finalizado com sucesso");

        datamartViewService.atualizarViewsDB(); // NOVO
        logger.info("✅ Views do datamart atualizadas com sucesso");

        context.close();
    }
}

