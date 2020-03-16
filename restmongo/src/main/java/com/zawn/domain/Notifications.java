
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
 * notifications
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id_owner",
    "id_person",
    "title",
    "content",
    "attach",
    "path",
    "type",
    "priority",
    "readed",
    "executed",
    "hidden",
    "status",
    "verified",
    "notes",
    "logs"
})
@Document @Getter @Setter @NoArgsConstructor public class  Notifications extends AbstractDocument{

    @JsonProperty("id_owner")
    @DBRef
    public Users id_owner;
    @JsonProperty("id_person")
    @DBRef
    public Users id_person;
    @JsonProperty("title")
    public String title;
    @JsonProperty("content")
    public String content;
    @JsonProperty("attach")
    public String attach;
    @JsonProperty("path")
    public String path;
    @JsonProperty("type")
    public Notifications.Type type;
    @JsonProperty("priority")
    public Notifications.Priority priority;
    @JsonProperty("readed")
    public Boolean readed;
    @JsonProperty("executed")
    public Boolean executed;
    @JsonProperty("hidden")
    public Boolean hidden;
    @JsonProperty("status")
    public Notifications.Status status;
    @JsonProperty("verified")
    public Boolean verified;
    @JsonProperty("notes")
    public String notes;
    @JsonProperty("logs")
    @Valid
    @DBRef public List<Logs> logs = new ArrayList<>();

    public enum Priority {

        HIGH("HIGH"),
        MEDIUM("MEDIUM"),
        LOW("LOW");
        private final String value;
        private final static Map<String, Notifications.Priority> CONSTANTS = new HashMap<String, Notifications.Priority>();

        static {
            for (Notifications.Priority c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private Priority(String value) {
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
        public static Notifications.Priority fromValue(String value) {
            Notifications.Priority constant = CONSTANTS.get(value);
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
        private final static Map<String, Notifications.Status> CONSTANTS = new HashMap<String, Notifications.Status>();

        static {
            for (Notifications.Status c: values()) {
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
        public static Notifications.Status fromValue(String value) {
            Notifications.Status constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

    public enum Type {

        SIGN("SIGN"),
        SYSTEM("SYSTEM"),
        ALERT("ALERT");
        private final String value;
        private final static Map<String, Notifications.Type> CONSTANTS = new HashMap<String, Notifications.Type>();

        static {
            for (Notifications.Type c: values()) {
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
        public static Notifications.Type fromValue(String value) {
            Notifications.Type constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
