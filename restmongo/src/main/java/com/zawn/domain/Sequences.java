
package com.zawn.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * sequences
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "description",
    "type",
    "witness",
    "steps",
    "parameters",
    "amount",
    "hidden",
    "status",
    "verified",
    "notes",
    "logs"
})
@Document @Getter @Setter @NoArgsConstructor
public class Sequences extends AbstractDocument{

    @JsonProperty("name")
    @NotEmpty
    @Indexed(unique = true)
    public String name;
    @JsonProperty("description")
    public String description;
    @JsonProperty("type")
    @NotNull
    public Sequences.Type type;
    @JsonProperty("witness")
    public Boolean witness;
    @JsonProperty("steps")
    @Valid
    @DBRef 
    public List<Steps> steps = new ArrayList<>();
    @JsonProperty("parameters") 
    @Valid
    public Map<String, Object> parameters = new HashMap<String, Object>();
    @JsonProperty("amount")
    public String amount;
    @JsonProperty("hidden")
    public Boolean hidden;
    @JsonProperty("status")
    public Sequences.Status status;
    @JsonProperty("verified")
    public Boolean verified;
    @JsonProperty("notes")
    public String notes;
    @JsonProperty("logs")
    @Valid
    @DBRef 
    public List<Logs> logs = new ArrayList<>();
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public enum Status {

        ENABLED("ENABLED"),
        DISABLED("DISABLED"),
        DELETED("DELETED");
        private final String value;
        private final static Map<String, Sequences.Status> CONSTANTS = new HashMap<>();

        static {
            for (Sequences.Status c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private Status(String value) {
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
        public static Sequences.Status fromValue(String value) {
        	Sequences.Status constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

    public enum Type {

        ENROLLMENT("ENROLLMENT"),
        SIGNATURE("SIGNATURE"),
        IDENTIFICATION("IDENTIFICATION"),
        VALIDATION("VALIDATION"),
        NOTARIZATION("NOTARIZATION");
        private final String value;
        private final static Map<String, Sequences.Type> CONSTANTS = new HashMap<>();

        static {
            for (Sequences.Type c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private Type(String value) {
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
        public static Sequences.Type fromValue(String value) {
        	Sequences.Type constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
