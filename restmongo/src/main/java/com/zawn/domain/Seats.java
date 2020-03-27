
package com.zawn.domain;

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
 * seats
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "idcustomer",
    "idlicence",
    "devices",
    "name",
    "description",
    "type",
    "imei",
    "ip",
    "mac",
    "time",
    "gps",
    "hidden",
    "status",
    "verified",
    "notes",
    "logs"
})
@Document @Getter @Setter @NoArgsConstructor public class  Seats  extends AbstractLoggedDocument{

    @JsonProperty("idcustomer")
    @DBRef
    public Users idcustomer;
    @JsonProperty("idlicence")
    @DBRef public Licences idlicence;
    @JsonProperty("devices")
    @Valid
    @DBRef
    public List<Devices> devices = new ArrayList<>();
    @JsonProperty("name")
    public String name;
    @JsonProperty("description")
    public String description;
    @JsonProperty("type")
    public Seats.Type type;
    @JsonProperty("imei")
    public String imei;
    @JsonProperty("ip")
    public String ip;
    @JsonProperty("mac")
    public String mac;
    @JsonProperty("time")
    public Date time;
    @JsonProperty("gps")
    public String gps;
    @JsonProperty("hidden")
    public Boolean hidden;
    @JsonProperty("status")
    public Seats.Status status;
    @JsonProperty("verified")
    public Boolean verified;
    @JsonProperty("notes")
    public String notes;
    

    public enum Status {

        ENABLED("ENABLED"),
        DISABLED("DISABLED"),
        DELETED("DELETED");
        private final String value;
        private final static Map<String, Seats.Status> CONSTANTS = new HashMap<String, Seats.Status>();

        static {
            for (Seats.Status c: values()) {
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
        public static Seats.Status fromValue(String value) {
            Seats.Status constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

    public enum Type {

        PC("PC"),
        MOBILE("MOBILE");
        private final String value;
        private final static Map<String, Seats.Type> CONSTANTS = new HashMap<String, Seats.Type>();

        static {
            for (Seats.Type c: values()) {
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
        public static Seats.Type fromValue(String value) {
            Seats.Type constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
