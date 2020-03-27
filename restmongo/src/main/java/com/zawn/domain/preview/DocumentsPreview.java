
package com.zawn.domain.preview;

import java.util.Date;

import org.springframework.data.rest.core.config.Projection;

import com.zawn.domain.Documents;
import com.zawn.domain.Users;

@Projection(name = "DocumentsPreview", types = { com.zawn.domain.Documents.class })
public interface DocumentsPreview  extends AbstractDocumentPreview{
	public Users getIduser();

	public String getName();

	public String getDescription();

	public String getMetadata();

	public com.zawn.domain.Documents.Extension getExtension();

	public String getEditor();

	public Date getDate();

	public Boolean getSigned();

	public Boolean getNotarized();

	public Boolean getEncrypted();

	public String getHost();

	public String getPath();

	public String getHash();

	public String getToken();

	public Boolean getHidden();

	public Documents.Status getStatus();

	public Boolean getVerified();

	public String getNotes();

}