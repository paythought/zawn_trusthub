
package com.zawn.domain.preview;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.rest.core.config.Projection;

import com.zawn.domain.Customers;
import com.zawn.domain.Subscriptions;

@Projection(name = "SubscriptionsPreview", types = { com.zawn.domain.Subscriptions.class })
public interface SubscriptionsPreview  extends AbstractDocumentPreview{
	public Customers getIdcustomer();

	public String getName();

	public String getDescription();

	public List<String> getParameters();

	public Boolean getHidden();

	public Subscriptions.Status getStatus();

	public Boolean getVerified();

	public String getNotes();

}