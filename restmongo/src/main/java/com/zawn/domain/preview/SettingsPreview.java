
package com.zawn.domain.preview;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.rest.core.config.Projection;

import com.zawn.domain.Settings;
import com.zawn.domain.Subscriptions;

@Projection(name = "SettingsPreview", types = { com.zawn.domain.Settings.class })
public interface SettingsPreview  extends AbstractDocumentPreview{
	public Subscriptions getIdsubscription();

	public String getName();

	public String getDescription();

	public List<String> getParameters();

	public Boolean getHidden();

	public Settings.Status getStatus();

	public Boolean getVerified();

	public String getNotes();

}