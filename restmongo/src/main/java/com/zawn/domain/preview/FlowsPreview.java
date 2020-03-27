
package com.zawn.domain.preview;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.rest.core.config.Projection;

import com.zawn.domain.Users;

@Projection(name = "FlowsPreview", types = { com.zawn.domain.Flows.class })
public interface FlowsPreview  extends AbstractDocumentPreview{
	public Users getIdperson();

	public String getName();

	public String getDescription();

	public List<String> getParameters();

	public String getAmount();

	public Boolean getHidden();

	public com.zawn.domain.Flows.Status getStatus();

	public Boolean getVerified();

	public String getNotes();

}