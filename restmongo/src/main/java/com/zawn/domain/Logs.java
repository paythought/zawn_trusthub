
package com.zawn.domain;

import java.math.BigInteger;
import java.util.Date;
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
 * logs
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "idabis",
    "iduser",
    "idcustomer",
    "idoperation",
    "idtimeline",
    "idparameter",
    "idsequence",
    "idstep",
    "idinfo",
    "iddocument",
    "idtemplate",
    "idflow",
    "idnotification",
    "idtask",
    "idsubscription",
    "idsetting",
    "idmodule",
    "idpreset",
    "idlimit",
    "idcertificator",
    "idseat",
    "iddevice",
    "idlicence",
    "idnotarization",
    "idwallet",
    "idpayment",
    "name",
    "description",
    "type",
    "code",
    "imei",
    "ip",
    "mac",
    "time",
    "gps",
    "sid",
    "hidden",
    "status",
    "verified",
    "notes"
})
@Document @Getter @Setter @NoArgsConstructor 
public class  Logs extends AbstractDocument{

    @JsonProperty("idabis")
    public String idabis;
    @JsonProperty("iduser")
    @DBRef
    public Users iduser;
    @JsonProperty("idcustomer")
    @DBRef public Customers idcustomer;
    @JsonProperty("idoperation")
    @DBRef public Operations idoperation;
    @JsonProperty("idtimeline")
    @DBRef public Timelines idtimeline;
    @JsonProperty("idparameter")
    @DBRef public Parameters idparameter;
    @JsonProperty("idsequence")
    @DBRef public Sequences idsequence;
    @JsonProperty("idstep")
    @DBRef public Steps idstep;
    @JsonProperty("idinfo")
    @DBRef public Infos idinfo;
    @JsonProperty("iddocument")
    @DBRef public Documents iddocument;
    @JsonProperty("idtemplate")
    @DBRef public Templates idtemplate;
    @JsonProperty("idflow")
    @DBRef public Flows idflow;
    @JsonProperty("idnotification")
    @DBRef public Notifications idnotification;
    @JsonProperty("idtask")
    @DBRef public Tasks idtask;
    @JsonProperty("idsubscription")
    @DBRef public Subscriptions idsubscription;
    @JsonProperty("idsetting")
    @DBRef public Settings idsetting;
    @JsonProperty("idmodule")
    @DBRef public Modules idmodule;
    @JsonProperty("idpreset")
    @DBRef public Presets idpreset;
    @JsonProperty("idlimit")
    @DBRef public Limits idlimit;
    @JsonProperty("idcertificator")
    @DBRef public Certificators idcertificator;
    @JsonProperty("idseat")
    @DBRef public Seats idseat;
    @JsonProperty("iddevice")
    @DBRef public Devices iddevice;
    @JsonProperty("idlicence")
    @DBRef public Licences idlicence;
    @JsonProperty("idnotarization")
    @DBRef public Notarizations idnotarization;
    @JsonProperty("idwallet")
    @DBRef public Wallets idwallet;
    @JsonProperty("idpayment")
    @DBRef public Payments idpayment;
    @JsonProperty("name")
    public String name;
    @JsonProperty("description")
    public String description;
    @JsonProperty("type")
    public Logs.Type type;
    @JsonProperty("code")
    public Double code;
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
    @JsonProperty("sid")
    public Double sid;
    
    @JsonProperty("hidden")
    public Boolean hidden = false;
    @JsonProperty("status")
    public Logs.Status status = Status.ENABLED;
    @JsonProperty("verified")
    public Boolean verified = true;
    @JsonProperty("notes")
    public String notes;

    public enum Status {

        ENABLED("ENABLED"),
        DISABLED("DISABLED"),
        DELETED("DELETED");
        private final String value;
        private final static Map<String, Logs.Status> CONSTANTS = new HashMap<String, Logs.Status>();

        static {
            for (Logs.Status c: values()) {
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
        public static Logs.Status fromValue(String value) {
            Logs.Status constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

    public enum Type {

        CREATE("CREATE"),
        UPDATE("UPDATE"),
        DELETE("DELETE");
        private final String value;
        private final static Map<String, Logs.Type> CONSTANTS = new HashMap<String, Logs.Type>();

        static {
            for (Logs.Type c: values()) {
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
        public static Logs.Type fromValue(String value) {
            Logs.Type constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
