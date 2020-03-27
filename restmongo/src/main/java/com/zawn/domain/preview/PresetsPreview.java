
package com.zawn.domain.preview;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.rest.core.config.Projection;

import com.zawn.domain.Presets;
import com.zawn.domain.Subscriptions;

@Projection(name = "PresetsPreview", types = { com.zawn.domain.Presets.class })
public interface PresetsPreview  extends AbstractDocumentPreview{
	public Subscriptions getIdsubscription();

	public String getName();

	public String getDescription();

	public List<String> getParameters();

	public Boolean getHidden();

	public Presets.Status getStatus();

	public Boolean getVerified();

	public String getNotes();

}