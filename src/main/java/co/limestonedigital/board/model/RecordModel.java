package co.limestonedigital.board.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@Document
public class RecordModel {
    @Id
    @JsonProperty
    private String id;

    @JsonProperty
    private String name;

    @JsonProperty
    private String description;

    @JsonProperty
    private RecordType type;

    public enum RecordType {
        TO_DO(0, "TO DO"), IN_PROGRESS(1, "In Progress"), DONE(2, "Done");

        RecordType(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Getter
        @JsonValue
        private int id;

        @Getter
        private String name;

        @JsonCreator
        public static RecordType of(int id) {
            RecordType result = null;
            for (RecordType item : RecordType.values()) {
                if (item.id == id) {
                    result = item;
                    break;
                }
            }
            return result;
        }
    }

    public enum RecordCommand {
        REMOVE(0), ADD(1);

        RecordCommand(int id) {
            this.id = id;
        }

        @Getter
        @JsonValue
        private int id;

        @JsonCreator
        public static RecordCommand of(int id) {
            RecordCommand result = null;
            for (RecordCommand item : RecordCommand.values()) {
                if (item.id == id) {
                    result = item;
                    break;
                }
            }
            return result;
        }
    }
}
