
package com.zawn.domain.preview;

import java.util.Date;

import org.springframework.data.rest.core.config.Projection;

import com.zawn.domain.Steps;
import com.zawn.domain.Users;

@Projection(name = "StepsPreview", types = { com.zawn.domain.Steps.class })
public interface StepsPreview  extends AbstractDocumentPreview{
	public Users getIdoperator();

	public Users getIdperson();

	public Users getIdwitness();

	public Date getStart();

	public Date getFinish();

	public Double getCode();

	public String getCache();

	public String getImei();

	public String getIp();

	public String getMac();

	public String getGps();

	public Double getSid();

	public Boolean getHidden();

	public Steps.Status getStatus();

	public Boolean getVerified();

	public String getNotes();

}