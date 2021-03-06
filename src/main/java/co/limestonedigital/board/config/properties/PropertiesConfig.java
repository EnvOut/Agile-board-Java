package co.limestonedigital.board.config.properties;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource({"classpath:board-config/mongoDB.properties",
//        "classpath:board-config/log.properties",
        "classpath:simplelogger.properties"})
public class PropertiesConfig {
}
