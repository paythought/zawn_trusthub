
package com.zawn.domain.preview;

import org.springframework.data.rest.core.config.Projection;

import com.zawn.domain.Devices;
import com.zawn.domain.Seats;

@Projection(name = "DevicesPreview", types = { com.zawn.domain.Devices.class })
public interface DevicesPreview  extends AbstractDocumentPreview{
	public Seats getIdseat();

	public String getName();

	public String getDescription();

	public String getVendor();

	public Double getSerial();

	public Devices.Type getType();

	public String getCertificate();

	public Boolean getHidden();

	public Devices.Status getStatus();

	public Boolean getVerified();

	public String getNotes();

}