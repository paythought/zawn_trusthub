
package com.zawn.domain.preview;

import org.springframework.data.rest.core.config.Projection;

import com.zawn.domain.Customers;

@Projection(name = "CustomersPreview", types = { com.zawn.domain.Customers.class })
public interface CustomersPreview  extends AbstractDocumentPreview{
	public Double getIdwhmcs();

	public Boolean getHidden();

	public Customers.Status getStatus();

	public Boolean getVerified();

	public String getNotes();

}