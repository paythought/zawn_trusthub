package com.zawn.domain.preview;

import java.util.List;

import org.springframework.data.rest.core.config.Projection;

import com.zawn.domain.Logs;
import com.zawn.domain.StatusEnum;
import com.zawn.domain.Users;

@Projection(name = "UsersPreview", types = { com.zawn.domain.Users.class })
public interface UsersPreview extends AbstractDocumentPreview{

	public String getUsername();

	public String getPassword();

	public Users.Type getType();

	public Boolean getHidden();

	public StatusEnum getStatus();

	public Boolean getVerified();

	public String getNotes();
	
	public List<Logs> getLogs();

}