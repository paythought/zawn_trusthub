
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
 * steps
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "description",
    "page",
    "path",
    "api",
    "type",
    "parameters",
    "amount",
    "url",
    "call",
    "port",
    "sandbox",
    "hidden",
    "status",
    "verified",
    "notes",
    "logs"
})
@Document @Getter @Setter @NoArgsConstructor  
public class Steps extends AbstractDocument{

    @JsonProperty("name")
    @NotEmpty
    @Indexed(unique = true)
    public String name;
    @JsonProperty("description")
    public String description;
    @JsonProperty("page")
    public String page;
    @JsonProperty("path")
    public String path;
    @JsonProperty("api")
    public String api;
    @JsonProperty("type")
    public Steps.Type type;
    @JsonProperty("parameters")
    @Valid
    public List<String> parameters = new ArrayList<String>();
    @JsonProperty("amount")
    public String amount;
    @JsonProperty("url")
    public String url;
    @JsonProperty("call")
    public String call;
    @JsonProperty("port")
    public String port;
    @JsonProperty("sandbox")
    public Boolean sandbox;
    @JsonProperty("hidden")
    @NotNull
    public Boolean hidden=false;
    @JsonProperty("status")
    @NotNull
    public Steps.Status status=Status.ENABLED;
    @JsonProperty("verified")
    @NotNull
    public Boolean verified=false;
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
        private final static Map<String, Steps.Status> CONSTANTS = new HashMap<>();

        static {
            for (Steps.Status c: values()) {
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
        public static Steps.Status fromValue(String value) {
        	Steps.Status constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

    public enum Type {

        REST("REST"),
        POST("POST");
        private final String value;
        private final static Map<String, Steps.Type> CONSTANTS = new HashMap<>();

        static {
            for (Steps.Type c: values()) {
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
        public static Steps.Type fromValue(String value) {
        	Steps.Type constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
