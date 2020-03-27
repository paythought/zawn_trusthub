
package com.zawn.domain.preview;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.rest.core.config.Projection;

import com.zawn.domain.Devices;
import com.zawn.domain.Licences;
import com.zawn.domain.Seats;
import com.zawn.domain.Users;

@Projection(name = "SeatsPreview", types = { com.zawn.domain.Seats.class })
public interface SeatsPreview  extends AbstractDocumentPreview{
	public Users getIdcustomer();

	public Licences getIdlicence();

	public List<Devices> getDevices();

	public String getName();

	public String getDescription();

	public Seats.Type getType();

	public String getImei();

	public String getIp();

	public String getMac();

	public Date getTime();

	public String getGps();

	public Boolean getHidden();

	public Seats.Status getStatus();

	public Boolean getVerified();

	public String getNotes();

}