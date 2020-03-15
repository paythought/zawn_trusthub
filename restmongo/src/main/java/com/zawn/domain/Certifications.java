package com.zawn.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
* Certifications
* <p>
*
*
*/
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"id_abis",
"name",
"description",
"date",
"reference",
"rate",
"hidden",
"status",
"verified",
"notes",
"timeline"
})
@Getter
@Setter
@NoArgsConstructor
public class Certifications extends AbstractDocument{
@JsonProperty("id_abis")
public Abis id_abis;
@JsonProperty("name")
public String name;
@JsonProperty("description")
public String description;
@JsonProperty("date")
public Date date;
@JsonProperty("reference")
public Double reference;
@JsonProperty("rate")
public String rate;
@JsonProperty("hidden")
public Boolean hidden;
@JsonProperty("status")
public StatusWithSuspendedEnum status;
@JsonProperty("verified")
public Boolean verified;
@JsonProperty("notes")
public String notes;
@JsonProperty("timeline")
@Valid
public List<Logs> timeline = new ArrayList<>();

}