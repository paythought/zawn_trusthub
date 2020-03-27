
package com.zawn.domain.preview;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.rest.core.config.Projection;

import com.zawn.domain.Sequences;
import com.zawn.domain.Steps;
import com.zawn.domain.Timelines;
import com.zawn.domain.Users;

@Projection(name = "TimelinesPreview", types = { com.zawn.domain.Timelines.class })
public interface TimelinesPreview  extends AbstractDocumentPreview{
	public Users getIdowner();

	public Sequences getIdsequence();

	public List<Steps> getSteps();

	public String getCache();

	public Boolean getHidden();

	public Timelines.Status getStatus();

	public Boolean getVerified();

	public String getNotes();

}