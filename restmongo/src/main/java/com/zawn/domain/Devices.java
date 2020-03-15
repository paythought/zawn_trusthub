
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
 * devices
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id_seat",
    "name",
    "description",
    "vendor",
    "serial",
    "type",
    "certificate",
    "hidden",
    "status",
    "verified",
    "notes",
    "logs"
})
@Document @Getter @Setter @NoArgsConstructor public class  Devices extends AbstractDocument{

    @JsonProperty("id_seat")
    @DBRef public Seats id_seat;
    @JsonProperty("name")
    public String name;
    @JsonProperty("description")
    public String description;
    @JsonProperty("vendor")
    public String vendor;
    @JsonProperty("serial")
    public Double serial;
    @JsonProperty("type")
    public Devices.Type type;
    @JsonProperty("certificate")
    public String certificate;
    @JsonProperty("hidden")
    public Boolean hidden;
    @JsonProperty("status")
    public Devices.Status status;
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
        private final static Map<String, Devices.Status> CONSTANTS = new HashMap<String, Devices.Status>();

        static {
            for (Devices.Status c: values()) {
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
        public static Devices.Status fromValue(String value) {
            Devices.Status constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

    public enum Type {

        FINGERPRINT("FINGERPRINT"),
        WEBCAM("WEBCAM"),
        MICROPHONE("MICROPHONE"),
        TAB("TAB");
        private final String value;
        private final static Map<String, Devices.Type> CONSTANTS = new HashMap<String, Devices.Type>();

        static {
            for (Devices.Type c: values()) {
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
        public static Devices.Type fromValue(String value) {
            Devices.Type constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
