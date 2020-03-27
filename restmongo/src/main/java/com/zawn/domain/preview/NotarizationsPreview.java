
package com.zawn.domain.preview;

import java.math.BigInteger;

import org.springframework.data.rest.core.config.Projection;

import com.zawn.domain.Documents;
import com.zawn.domain.Logs;
import com.zawn.domain.Notarizations;
import com.zawn.domain.Steps;
import com.zawn.domain.Timelines;
import com.zawn.domain.Users;

@Projection(name = "NotarizationsPreview", types = { com.zawn.domain.Notarizations.class })
public interface NotarizationsPreview  extends AbstractDocumentPreview{
	public Users getIdperson();

	public Documents getIddocument();

	public String getIdabis();

	public Timelines getIdtimeline();

	public Steps getIdstep();

	public Logs getIdlog();

	public Notarizations.Type getType();

	public String getName();

	public String getDescription();

	public String getKey();

	public String getHash();

	public Boolean getHidden();

	public Notarizations.Status getStatus();

	public Boolean getVerified();

	public String getNotes();

}