
package com.zawn.domain.preview;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.rest.core.config.Projection;

import com.zawn.domain.Limits;
import com.zawn.domain.Subscriptions;

@Projection(name = "LimitsPreview", types = { com.zawn.domain.Limits.class })
public interface LimitsPreview  extends AbstractDocumentPreview{
	public Subscriptions getIdsubscription();

	public String getName();

	public String getDescription();

	public List<String> getParameters();

	public Boolean getHidden();

	public Limits.Status getStatus();

	public Boolean getVerified();

	public String getNotes();

}