package com.zawn.domain;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.data.mongodb.core.mapping.DBRef;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
public abstract class AbstractLoggedDocument
extends AbstractDocument{
	@JsonProperty("logs")
    @Valid
    @DBRef(lazy = true) 
    public List<Logs> logs = new ArrayList<>();
	
}
