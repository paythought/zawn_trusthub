
package com.zawn.domain.preview;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.rest.core.config.Projection;

import com.zawn.domain.Sequences;
import com.zawn.domain.Tasks;
import com.zawn.domain.Users;

@Projection(name = "TasksPreview", types = { com.zawn.domain.Tasks.class })
public interface TasksPreview  extends AbstractDocumentPreview{
	public Users getIdowner();

	public Users getIdoperator();

	public Users getIdperson();

	public Sequences getIdsequence();

	public Sequences getIdflow();

	public String getName();

	public String getDescription();

	public List<String> getParameters();

	public List<String> getConditions();

	public List<String> getActions();

	public Boolean getHidden();

	public Tasks.Status getStatus();

	public Boolean getVerified();

	public String getNotes();

}