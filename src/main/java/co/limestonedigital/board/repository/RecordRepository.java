package co.limestonedigital.board.repository;

import co.limestonedigital.board.model.RecordModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RecordRepository extends MongoRepository<RecordModel, String> {
//    void removeById(String id);

    RecordModel getById(String id);
}
