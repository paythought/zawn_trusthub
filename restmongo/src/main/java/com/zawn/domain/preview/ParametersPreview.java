
package com.zawn.domain.preview;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.rest.core.config.Projection;

import com.zawn.domain.Parameters;
import com.zawn.domain.Users;

@Projection(name = "ParametersPreview", types = { com.zawn.domain.Parameters.class })
public interface ParametersPreview  extends AbstractDocumentPreview{
	public Users getIdcustomer();

	public String getName();

	public String getDescription();

	public List<String> getParameters();

	public String getUsername();

	public String getPassword();

	public String getKey();

	public Boolean getHidden();

	public Parameters.Status getStatus();

	public Boolean getVerified();

	public String getNotes();

}