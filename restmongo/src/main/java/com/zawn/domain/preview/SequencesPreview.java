
package com.zawn.domain.preview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.rest.core.config.Projection;

import com.zawn.domain.Operations;
import com.zawn.domain.Sequences;

@Projection(name = "SequencesPreview", types = { com.zawn.domain.Sequences.class })
public interface SequencesPreview  extends AbstractDocumentPreview{
	public String getName();

	public String getDescription();

	public String getIcon();

	public String getImage();

	public Sequences.Type getType();

	public Sequences.Category getCategory();

	public Boolean getWitness();

	public List<Operations> getOperations();

	public Map<String, Object> getParameters();

	public String getAmount();

	public Boolean getHidden();

	public Sequences.Status getStatus();

	public Boolean getVerified();

	public String getNotes();

}