
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
 * customers
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id_whmcs",
    "hidden",
    "status",
    "verified",
    "notes",
    "logs"
})
@Document @Getter @Setter @NoArgsConstructor public class  Customers extends AbstractDocument{

    @JsonProperty("id_whmcs")
    public Double id_whmcs;
    @JsonProperty("hidden")
    public Boolean hidden;
    @JsonProperty("status")
    public Customers.Status status;
    @JsonProperty("verified")
    public Boolean verified;
    @JsonProperty("notes")
    public String notes;
    @JsonProperty("logs")
    @Valid
    @DBRef public List<Logs> logs = new ArrayList<>();

    public enum Status {

        ENABLED("ENABLED"),
        DISABLED("DISABLED"),
        DELETED("DELETED");
        private final String value;
        private final static Map<String, Customers.Status> CONSTANTS = new HashMap<String, Customers.Status>();

        static {
            for (Customers.Status c: values()) {
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
        public static Customers.Status fromValue(String value) {
            Customers.Status constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
