
package com.zawn.domain.preview;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.rest.core.config.Projection;

import com.zawn.domain.Documents;
import com.zawn.domain.Templates;
import com.zawn.domain.Users;

@Projection(name = "TemplatesPreview", types = { com.zawn.domain.Templates.class })
public interface TemplatesPreview  extends AbstractDocumentPreview{
	public Users getIdperson();

	public Documents getIddocument();

	public String getName();

	public String getDescription();

	public List<String> getParameters();

	public List<String> getConditions();

	public List<String> getActions();

	public Boolean getHidden();

	public Templates.Status getStatus();

	public Boolean getVerified();

	public String getNotes();

}