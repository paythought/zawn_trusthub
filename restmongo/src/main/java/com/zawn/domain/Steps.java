
package com.zawn.domain;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.validation.constraints.NotNull;

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
 * steps
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "idoperator",
    "idperson",
    "idwitness",
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
public class  Steps extends AbstractLoggedDocument{

    @JsonProperty("idoperator")
    @DBRef
    public Users idoperator;
    @JsonProperty("idperson")
    @DBRef
    public Users idperson;
    @JsonProperty("idwitness")
    @DBRef
    public Users idwitness;
    @JsonProperty("start")
    @NotNull
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
    @NotNull
    @JsonProperty("hidden")
    public Boolean hidden=false;
    @NotNull
    @JsonProperty("status")
    public Steps.Status status=Status.ENABLED;
    @NotNull
    @JsonProperty("verified")
    public Boolean verified=false;
    @JsonProperty("notes")
    public String notes;
    
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
