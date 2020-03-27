
package com.zawn.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

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
 * templates
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "idperson",
    "iddocument",
    "name",
    "description",
    "parameters",
    "conditions",
    "actions",
    "hidden",
    "status",
    "verified",
    "notes",
    "logs"
})
@Document @Getter @Setter @NoArgsConstructor public class  Templates  extends AbstractLoggedDocument{

    @JsonProperty("idperson")
    @DBRef
    public Users idperson;
    @JsonProperty("iddocument")
    @DBRef public Documents iddocument;
    @JsonProperty("name")
    public String name;
    @JsonProperty("description")
    public String description;
    @JsonProperty("parameters")
    @Valid
    public List<String> parameters = new ArrayList<String>();
    @JsonProperty("conditions")
    @Valid
    public List<String> conditions = new ArrayList<String>();
    @JsonProperty("actions")
    @Valid
    public List<String> actions = new ArrayList<String>();
    @JsonProperty("hidden")
    public Boolean hidden;
    @JsonProperty("status")
    public Templates.Status status;
    @JsonProperty("verified")
    public Boolean verified;
    @JsonProperty("notes")
    public String notes;
    

    public enum Status {

        ENABLED("ENABLED"),
        DISABLED("DISABLED"),
        DELETED("DELETED");
        private final String value;
        private final static Map<String, Templates.Status> CONSTANTS = new HashMap<String, Templates.Status>();

        static {
            for (Templates.Status c: values()) {
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
        public static Templates.Status fromValue(String value) {
            Templates.Status constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
