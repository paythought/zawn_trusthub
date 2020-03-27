
package com.zawn.domain.preview;

import org.springframework.data.rest.core.config.Projection;

import com.zawn.domain.Licences;

@Projection(name = "LicencesPreview", types = { com.zawn.domain.Licences.class })
public interface LicencesPreview  extends AbstractDocumentPreview{
	public String getName();

	public String getDescription();

	public String getKey();

	public Boolean getHidden();

	public Licences.Status getStatus();

	public Boolean getVerified();

	public String getNotes();

}