
package com.zawn.domain.preview;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.rest.core.config.Projection;

import com.zawn.domain.Operations;

@Projection(name = "OperationsPreview", types = { com.zawn.domain.Operations.class })
public interface OperationsPreview  extends AbstractDocumentPreview{
	public String getName();

	public String getDescription();

	public String getIcon();

	public String getImage();

	public String getPath();

	public Boolean getWtness();

	public List<String> getParameters();

	public String getAmount();

	public Boolean getHidden();

	public Operations.Status getStatus();

	public Boolean getVerified();

	public String getNotes();

}