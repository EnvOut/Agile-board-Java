package co.limestonedigital.board.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@Data
public class RecordModel {
    @Id
    private UUID id;

    private String name;

    private String description;

    private RecordCommand command;

    @AllArgsConstructor(staticName = "of",
            onConstructor = @__({@JsonCreator}))
    public enum RecordType {
        TO_DO(0), IN_PROGRESS(1), DONE(2);

        @Getter
        @JsonProperty
        private int id;
    }

    @AllArgsConstructor(staticName = "of",
            onConstructor = @__({@JsonCreator}))
    public enum RecordCommand {
        REMOVE(0), ADD(1);

        @Getter
        @JsonProperty
        private int id;
    }
}
