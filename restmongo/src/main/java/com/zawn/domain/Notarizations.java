
package com.zawn.domain;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

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
 * notarizations
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"idperson",
    "iddocument",
    "idabis",
    "idtimeline",
    "idstep",
    "idlog",
    "type",
    "name",
    "description",
    "key",
    "hash",
    
    "hidden",
    "status",
    "verified",
    "notes",
    "logs"
})
@Document @Getter @Setter @NoArgsConstructor public class  Notarizations extends AbstractLoggedDocument{
	@JsonProperty("idperson")
    @DBRef public Users idperson;
    @JsonProperty("iddocument")
    @DBRef public Documents iddocument;
    @JsonProperty("idabis")
    public String idabis;
    @JsonProperty("idtimeline")
    @DBRef public Timelines idtimeline;
    @JsonProperty("idstep")
    @DBRef public Steps idstep;
    @JsonProperty("idlog")
    @DBRef public Logs idlog;
    @JsonProperty("type")
    public Notarizations.Type type;
    @JsonProperty("name")
    public String name;
    @JsonProperty("description")
    public String description;
    @JsonProperty("key")
    public String key;
    @JsonProperty("hash")
    public String hash;
    @JsonProperty("hidden")
    public Boolean hidden;
    @JsonProperty("status")
    public Notarizations.Status status;
    @JsonProperty("verified")
    public Boolean verified;
    @JsonProperty("notes")
    public String notes;
    

    public enum Status {

        ENABLED("ENABLED"),
        DISABLED("DISABLED"),
        DELETED("DELETED");
        private final String value;
        private final static Map<String, Notarizations.Status> CONSTANTS = new HashMap<String, Notarizations.Status>();

        static {
            for (Notarizations.Status c: values()) {
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
        public static Notarizations.Status fromValue(String value) {
            Notarizations.Status constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

    public enum Type {
    	IDENTITY("IDENTITY"),
        DOCUMENT("DOCUMENT"),
        BIOMETRIC("BIOMETRIC"),
        TIMELINE("TIMELINE"),
        STEP("STEP"),
        LOG("LOG");
        private final String value;
        private final static Map<String, Notarizations.Type> CONSTANTS = new HashMap<String, Notarizations.Type>();

        static {
            for (Notarizations.Type c: values()) {
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
        public static Notarizations.Type fromValue(String value) {
            Notarizations.Type constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
