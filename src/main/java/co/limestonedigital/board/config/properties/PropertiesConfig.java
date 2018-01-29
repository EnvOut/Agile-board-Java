package co.limestonedigital.board.config.properties;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:board-config/mongoDB.properties")
public class PropertiesConfig {
}
