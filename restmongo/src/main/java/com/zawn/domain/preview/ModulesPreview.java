
package com.zawn.domain.preview;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.rest.core.config.Projection;

import com.zawn.domain.Modules;
import com.zawn.domain.Subscriptions;

@Projection(name = "ModulesPreview", types = { com.zawn.domain.Modules.class })
public interface ModulesPreview  extends AbstractDocumentPreview{
	public Subscriptions getIdsubscription();

	public String getName();

	public String getDescription();

	public List<String> getParameters();

	public Modules.Type getType();

	public Boolean getHidden();

	public Modules.Status getStatus();

	public Boolean getVerified();

	public String getNotes();

}