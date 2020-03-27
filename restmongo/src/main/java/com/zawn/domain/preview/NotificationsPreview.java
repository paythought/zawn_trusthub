
package com.zawn.domain.preview;

import org.springframework.data.rest.core.config.Projection;

import com.zawn.domain.Notifications;
import com.zawn.domain.Users;

@Projection(name = "NotificationsPreview", types = { com.zawn.domain.Notifications.class })
public interface NotificationsPreview  extends AbstractDocumentPreview{
	public Users getIdowner();

	public Users getIdperson();

	public String getTitle();

	public String getContent();

	public String getAttach();

	public String getPath();

	public Notifications.Type getType();

	public Notifications.Priority getPriority();

	public Boolean getReaded();

	public Boolean getExecuted();

	public Boolean getHidden();

	public Notifications.Status getStatus();

	public Boolean getVerified();

	public String getNotes();

}