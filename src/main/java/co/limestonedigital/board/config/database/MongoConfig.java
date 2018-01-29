package co.limestonedigital.board.config.database;

import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "co.limestonedigital.board.repository")
public class MongoConfig extends AbstractMongoConfiguration {
    @Value("${mongo.database.name}")
    private String databaseName;

    @Override
    public MongoClient mongoClient() {
        return new MongoClient();
    }

    @Override
    protected String getDatabaseName() {
        return databaseName;
    }
}
