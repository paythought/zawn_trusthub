
package com.zawn.domain.preview;

import org.springframework.data.rest.core.config.Projection;

import com.zawn.domain.Users;

@Projection(name = "InfosPreview", types = { com.zawn.domain.Infos.class })
public interface InfosPreview  extends AbstractDocumentPreview{
	public Users getIdperson();

	public String getName();

	public String getDescription();

	public String getMetadata();

	public com.zawn.domain.Infos.Attach_type getAttach_type();

	public String getAttach_name();

	public String getAttach_host();

	public String getAttach_path();

	public String getAttach_hash();

	public String getAttach_token();

	public Boolean getHidden();

	public com.zawn.domain.Infos.Status getStatus();

	public Boolean getVerified();

	public String getNotes();

}