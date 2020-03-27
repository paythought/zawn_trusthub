
package com.zawn.domain.preview;

import java.util.List;

import org.springframework.data.rest.core.config.Projection;

import com.zawn.domain.Certificators;

@Projection(name = "CertificatorsPreview", types = { com.zawn.domain.Certificators.class })
public interface CertificatorsPreview  extends AbstractDocumentPreview{
	public String getName();

	public String getDescription();

	public Certificators.Type getType();

	public String getUrl();

	public String getCall();

	public Double getPort();

	public List<String> getParameters();

	public Boolean getSandbox();

	public Double getData_quality();

	public String getFormat();

	public Boolean getHidden();

	public Certificators.Status getStatus();

	public Boolean getVerified();

	public String getNotes();

}
