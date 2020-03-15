
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
 * payments
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id_wallet",
    "id_transaction",
    "type",
    "cycle",
    "amount",
    "currency",
    "name",
    "description",
    "gateway",
    "result",
    "hidden",
    "status",
    "verified",
    "notes",
    "logs"
})
@Document @Getter @Setter @NoArgsConstructor public class  Payments extends AbstractDocument{

    @JsonProperty("id_wallet")
    @DBRef public Wallets id_wallet;
    @JsonProperty("id_transaction")
    public String id_transaction;
    @JsonProperty("type")
    public Payments.Type type;
    @JsonProperty("cycle")
    public Payments.Cycle cycle;
    @JsonProperty("amount")
    public Double amount;
    @JsonProperty("currency")
    public String currency;
    @JsonProperty("name")
    public String name;
    @JsonProperty("description")
    public String description;
    @JsonProperty("gateway")
    public Payments.Gateway gateway;
    @JsonProperty("result")
    public Payments.Result result;
    @JsonProperty("hidden")
    public Boolean hidden;
    @JsonProperty("status")
    public Payments.Status status;
    @JsonProperty("verified")
    public Boolean verified;
    @JsonProperty("notes")
    public String notes;
    @JsonProperty("logs")
    @Valid
    @DBRef public List<Logs> logs = new ArrayList<>();

    public enum Cycle {

        ONES("ONES"),
        DAILY("DAILY"),
        WEEKLY("WEEKLY"),
        MONTHLY("MONTHLY"),
        QUARTERLY("QUARTERLY"),
        ANNUALLY("ANNUALLY");
        private final String value;
        private final static Map<String, Payments.Cycle> CONSTANTS = new HashMap<String, Payments.Cycle>();

        static {
            for (Payments.Cycle c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private Cycle(String value) {
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
        public static Payments.Cycle fromValue(String value) {
            Payments.Cycle constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

    public enum Gateway {

        BANK("BANK"),
        PAYPAL("PAYPAL"),
        CREDIT("CREDIT"),
        DEBIT("DEBIT");
        private final String value;
        private final static Map<String, Payments.Gateway> CONSTANTS = new HashMap<String, Payments.Gateway>();

        static {
            for (Payments.Gateway c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private Gateway(String value) {
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
        public static Payments.Gateway fromValue(String value) {
            Payments.Gateway constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

    public enum Result {

        ACCEPTED("ACCEPTED"),
        REJECTED("REJECTED"),
        WAITING("WAITING");
        private final String value;
        private final static Map<String, Payments.Result> CONSTANTS = new HashMap<String, Payments.Result>();

        static {
            for (Payments.Result c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private Result(String value) {
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
        public static Payments.Result fromValue(String value) {
            Payments.Result constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

    public enum Status {

        ENABLED("ENABLED"),
        DISABLED("DISABLED"),
        DELETED("DELETED");
        private final String value;
        private final static Map<String, Payments.Status> CONSTANTS = new HashMap<String, Payments.Status>();

        static {
            for (Payments.Status c: values()) {
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
        public static Payments.Status fromValue(String value) {
            Payments.Status constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

    public enum Type {

        IN("IN"),
        OUT("OUT");
        private final String value;
        private final static Map<String, Payments.Type> CONSTANTS = new HashMap<String, Payments.Type>();

        static {
            for (Payments.Type c: values()) {
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
        public static Payments.Type fromValue(String value) {
            Payments.Type constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
