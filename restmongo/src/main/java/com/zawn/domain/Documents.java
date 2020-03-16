
package com.zawn.domain;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
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
 * documents
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
    "extension",
    "editor",
    "date",
    "signed",
    "notarized",
    "encrypted",
    "host",
    "path",
    "hash",
    "token",
    "hidden",
    "status",
    "verified",
    "notes",
    "logs"
})
@Document @Getter @Setter @NoArgsConstructor public class  Documents extends AbstractDocument{

    @JsonProperty("id_user")
    @DBRef
    public Users id_user;
    @JsonProperty("name")
    public String name;
    @JsonProperty("description")
    public String description;
    @JsonProperty("metadata")
    public String metadata;
    @JsonProperty("extension")
    public Documents.Extension extension;
    @JsonProperty("editor")
    public String editor;
    @JsonProperty("date")
    public Date date;
    @JsonProperty("signed")
    public Boolean signed;
    @JsonProperty("notarized")
    public Boolean notarized;
    @JsonProperty("encrypted")
    public Boolean encrypted;
    @JsonProperty("host")
    public String host;
    @JsonProperty("path")
    public String path;
    @JsonProperty("hash")
    public String hash;
    @JsonProperty("token")
    public String token;
    @JsonProperty("hidden")
    public Boolean hidden;
    @JsonProperty("status")
    public Documents.Status status;
    @JsonProperty("verified")
    public Boolean verified;
    @JsonProperty("notes")
    public String notes;
    @JsonProperty("logs")
    @Valid
    @DBRef public List<Logs> logs = new ArrayList<>();

    public enum Extension {

        DOC("DOC"),
        XLS("XLS"),
        ODT("ODT"),
        PDF("PDF");
        private final String value;
        private final static Map<String, Documents.Extension> CONSTANTS = new HashMap<String, Documents.Extension>();

        static {
            for (Documents.Extension c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private Extension(String value) {
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
        public static Documents.Extension fromValue(String value) {
            Documents.Extension constant = CONSTANTS.get(value);
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
        private final static Map<String, Documents.Status> CONSTANTS = new HashMap<String, Documents.Status>();

        static {
            for (Documents.Status c: values()) {
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
        public static Documents.Status fromValue(String value) {
            Documents.Status constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
