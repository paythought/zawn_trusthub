
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
    "id_abis",
    "id_user",
    "id_customer",
    "id_operation",
    "id_status",
    "id_parameter",
    "id_sequence",
    "id_step",
    "id_info",
    "id_document",
    "id_template",
    "id_flow",
    "id_notification",
    "id_task",
    "id_subscription",
    "id_setting",
    "id_module",
    "id_preset",
    "id_limit",
    "id_certificator",
    "id_seat",
    "id_device",
    "id_licence",
    "id_notarization",
    "id_wallet",
    "id_payment",
    "name",
    "description",
    "type",
    "code",
    "details",
    "vpn",
    "ssl",
    "encrypted",
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
@Document @Getter @Setter @NoArgsConstructor public class  Logs extends AbstractDocument{

    @JsonProperty("id_abis")
    public BigInteger id_abis;
    @JsonProperty("id_user")
    public BigInteger id_user;
    @JsonProperty("id_customer")
    @DBRef public Customers id_customer;
    @JsonProperty("id_operation")
    @DBRef public Operations id_operation;
    @JsonProperty("id_status")
    @DBRef public Status id_status;
    @JsonProperty("id_parameter")
    @DBRef public Parameters id_parameter;
    @JsonProperty("id_sequence")
    @DBRef public Sequences id_sequence;
    @JsonProperty("id_step")
    @DBRef public Steps id_step;
    @JsonProperty("id_info")
    @DBRef public Infos id_info;
    @JsonProperty("id_document")
    @DBRef public Documents id_document;
    @JsonProperty("id_template")
    @DBRef public Templates id_template;
    @JsonProperty("id_flow")
    @DBRef public Flows id_flow;
    @JsonProperty("id_notification")
    @DBRef public Notifications id_notification;
    @JsonProperty("id_task")
    @DBRef public Tasks id_task;
    @JsonProperty("id_subscription")
    @DBRef public Subscriptions id_subscription;
    @JsonProperty("id_setting")
    @DBRef public Settings id_setting;
    @JsonProperty("id_module")
    @DBRef public Modules id_module;
    @JsonProperty("id_preset")
    @DBRef public Presets id_preset;
    @JsonProperty("id_limit")
    @DBRef public Limits id_limit;
    @JsonProperty("id_certificator")
    @DBRef public Certificators id_certificator;
    @JsonProperty("id_seat")
    @DBRef public Seats id_seat;
    @JsonProperty("id_device")
    @DBRef public Devices id_device;
    @JsonProperty("id_licence")
    @DBRef public Licences id_licence;
    @JsonProperty("id_notarization")
    @DBRef public Notarizations id_notarization;
    @JsonProperty("id_wallet")
    @DBRef public Wallets id_wallet;
    @JsonProperty("id_payment")
    @DBRef public Payments id_payment;
    @JsonProperty("name")
    public String name;
    @JsonProperty("description")
    public String description;
    @JsonProperty("type")
    public Logs.Type type;
    @JsonProperty("code")
    public Double code;
    @JsonProperty("details")
    public String details;
    @JsonProperty("vpn")
    public Boolean vpn;
    @JsonProperty("ssl")
    public Boolean ssl;
    @JsonProperty("encrypted")
    public Boolean encrypted;
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
    public Boolean hidden;
    @JsonProperty("status")
    public Logs.Status status;
    @JsonProperty("verified")
    public Boolean verified;
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
