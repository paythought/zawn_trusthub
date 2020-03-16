
package com.zawn.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

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
    "id_operator",
    "id_person",
    "id_witness",
    "start",
    "finish",
    "code",
    "cache",
    "imei",
    "ip",
    "mac",
    "gps",
    "sid",
    
    "hidden",
    "status",
    "verified",
    "notes",
    "logs"
})
@Document @Getter @Setter @NoArgsConstructor 
public class  Steps extends AbstractDocument{

    @JsonProperty("id_operator")
    @DBRef
    public Users id_operator;
    @JsonProperty("id_person")
    @DBRef
    public Users id_person;
    @JsonProperty("id_witness")
    @DBRef
    public Users id_witness;
    @JsonProperty("start")
    public Date start;
    @JsonProperty("finish")
    public Date finish;
    @JsonProperty("code")
    public Double code;
    @JsonProperty("cache")
    public String cache;
    @JsonProperty("imei")
    public String imei;
    @JsonProperty("ip")
    public String ip;
    @JsonProperty("mac")
    public String mac;
    @JsonProperty("gps")
    public String gps;
    @JsonProperty("sid")
    public Double sid;
    
    @JsonProperty("hidden")
    public Boolean hidden;
    @JsonProperty("status")
    public Steps.Status status;
    @JsonProperty("verified")
    public Boolean verified;
    @JsonProperty("notes")
    public String notes;
    @JsonProperty("logs")
    @Valid
    @DBRef
    public List<Logs> logs = new ArrayList<>();
    
    public enum Status {

        ENABLED("ENABLED"),
        DISABLED("DISABLED"),
        DELETED("DELETED");
        private final String value;
        private final static Map<String, Steps.Status> CONSTANTS = new HashMap< >();

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

}
