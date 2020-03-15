
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
 * wallets
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id_customer",
    "name",
    "description",
    "amount",
    "hidden",
    "status",
    "verified",
    "notes",
    "logs"
})
@Document @Getter @Setter @NoArgsConstructor public class  Wallets  extends AbstractDocument{

    @JsonProperty("id_customer")
    @DBRef public Customers id_customer;
    @JsonProperty("name")
    public String name;
    @JsonProperty("description")
    public String description;
    @JsonProperty("amount")
    public String amount;
    @JsonProperty("hidden")
    public Boolean hidden;
    @JsonProperty("status")
    public Wallets.Status status;
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
        private final static Map<String, Wallets.Status> CONSTANTS = new HashMap<String, Wallets.Status>();

        static {
            for (Wallets.Status c: values()) {
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
        public static Wallets.Status fromValue(String value) {
            Wallets.Status constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
