package br.com.ada.moveflix.dataloader;

import br.com.ada.moveflix.service.raw.FilmeService;
import br.com.ada.moveflix.service.raw.GeneroService;
import br.com.ada.moveflix.service.etl.FilmeETLService;
import br.com.ada.moveflix.service.etl.GeneroETLService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(DataLoader.class);
    private final GeneroService generoService;
    private final FilmeService filmeService;
    private final FilmeETLService filmeETLService;
    private final GeneroETLService generoETLService;

    public DataLoader(GeneroService generoService,FilmeService filmeService,FilmeETLService filmeETLService,GeneroETLService generoETLService ) {
        this.generoService = generoService;
        this.filmeService = filmeService;
        this.filmeETLService = filmeETLService;
        this.generoETLService = generoETLService;
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
    }
}

