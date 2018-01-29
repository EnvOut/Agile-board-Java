package co.limestonedigital.board.config;

import co.limestonedigital.board.config.database.MongoConfig;
import co.limestonedigital.board.config.properties.PropertiesConfig;
import co.limestonedigital.board.config.spring.WebConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({WebConfiguration.class,
        PropertiesConfig.class,
        MongoConfig.class})
@ComponentScan("co.limestonedigital.board")
public class BoardConfig {
}
