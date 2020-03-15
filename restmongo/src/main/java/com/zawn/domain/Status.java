
package com.zawn.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * status
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id_sequence",
    "name",
    "description",
    "completed",
    "cache",
    "hidden",
    "status",
    "verified",
    "notes",
    "logs"
})
@Document @Getter @Setter @NoArgsConstructor 
public class Status extends AbstractDocument{

    @JsonProperty("id_sequence")
    @DBRef 
    @NotNull
    public Object id_sequence;
    @JsonProperty("name")
    public String name;
    @JsonProperty("description")
    public String description;
    @JsonProperty("completed")
    @Valid
    @DBRef 
    public List<Steps> completed = new ArrayList<>();
    @JsonProperty("cache")
    public String cache;
    @JsonProperty("hidden")
    public Boolean hidden;
    @JsonProperty("status")
    public Status.StatusEnum status;
    @JsonProperty("verified")
    public Boolean verified;
    @JsonProperty("notes")
    public String notes;
    @JsonProperty("logs")
    @Valid
    @DBRef 
    public List<Logs> logs = new ArrayList<>();

    public enum StatusEnum {

        ENABLED("ENABLED"),
        DISABLED("DISABLED"),
        DELETED("DELETED");
        private final String value;
        private final static Map<String, Status.StatusEnum> CONSTANTS = new HashMap<>();

        static {
            for (Status.StatusEnum c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private StatusEnum(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        @JsonValue
        public String value() {
            return this.value;
        }

        @JsonCreator
        public static Status.StatusEnum fromValue(String value) {
        	Status.StatusEnum constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
