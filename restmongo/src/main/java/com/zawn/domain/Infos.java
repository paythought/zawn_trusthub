
package com.zawn.domain;

import java.math.BigInteger;
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
 * infos
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id_user",
    "name",
    "description",
    "metadata",
    "attach_type",
    "attach_name",
    "attach_host",
    "attach_path",
    "attach_hash",
    "attach_token",
    "hidden",
    "status",
    "verified",
    "notes",
    "logs"
})
@Document @Getter @Setter @NoArgsConstructor public class  Infos extends AbstractDocument{

    @JsonProperty("id_user")
    public BigInteger id_user;
    @JsonProperty("name")
    public String name;
    @JsonProperty("description")
    public String description;
    @JsonProperty("metadata")
    public String metadata;
    @JsonProperty("attach_type")
    public Infos.Attach_type attach_type;
    @JsonProperty("attach_name")
    public String attach_name;
    @JsonProperty("attach_host")
    public String attach_host;
    @JsonProperty("attach_path")
    public String attach_path;
    @JsonProperty("attach_hash")
    public String attach_hash;
    @JsonProperty("attach_token")
    public String attach_token;
    @JsonProperty("hidden")
    public Boolean hidden;
    @JsonProperty("status")
    public Infos.Status status;
    @JsonProperty("verified")
    public Boolean verified;
    @JsonProperty("notes")
    public String notes;
    @JsonProperty("logs")
    @Valid
    @DBRef public List<Logs> logs = new ArrayList<>();

    public enum Attach_type {

        IDENTITY_CARD("IDENTITY CARD"),
        PASSPORT("PASSPORT"),
        DRIVER_LICENCE("DRIVER LICENCE"),
        CONTRACT("CONTRACT"),
        NDA("NDA"),
        PAYMENT_RECEIPT("PAYMENT RECEIPT");
        private final String value;
        private final static Map<String, Infos.Attach_type> CONSTANTS = new HashMap<String, Infos.Attach_type>();

        static {
            for (Infos.Attach_type c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private Attach_type(String value) {
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
        public static Infos.Attach_type fromValue(String value) {
            Infos.Attach_type constant = CONSTANTS.get(value);
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
        private final static Map<String, Infos.Status> CONSTANTS = new HashMap<String, Infos.Status>();

        static {
            for (Infos.Status c: values()) {
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
        public static Infos.Status fromValue(String value) {
            Infos.Status constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
