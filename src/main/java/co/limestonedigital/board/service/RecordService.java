package co.limestonedigital.board.service;

import co.limestonedigital.board.model.RecordModel;
import co.limestonedigital.board.repository.RecordRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class RecordService {
    @Autowired
    @Qualifier("recordRepository")
    private RecordRepository recordRepository;

    public List<RecordModel> getAll() {
        return recordRepository.findAll();
    }

    public RecordModel removeByID(String id) {
        RecordModel result = recordRepository.getById(id);
        recordRepository.deleteById(id);
        return result;
    }

    public RecordModel changeById(String id, RecordModel model) {
        RecordModel record = recordRepository.getById(id);

        // TODO Must be refact!
        String description = model.getDescription();
        if (description != null) {
            record.setDescription(description);
        }

        String name = model.getName();
        if (name != null) {
            record.setName(name);
        }

        RecordModel.RecordType type = model.getType();
        if (type != null) {
            record.setType(type);
        }

        return recordRepository.save(record);
    }

    public RecordModel createRecord(RecordModel recordModel) {
        return recordRepository.save(recordModel);
    }
}
