
package com.zawn.domain.preview;

import org.springframework.data.rest.core.config.Projection;

import com.zawn.domain.Customers;
import com.zawn.domain.Wallets;

@Projection(name = "WalletsPreview", types = { com.zawn.domain.Wallets.class })
public interface WalletsPreview  extends AbstractDocumentPreview{
	public Customers getIdcustomer();

	public String getName();

	public String getDescription();

	public String getAmount();

	public Boolean getHidden();

	public Wallets.Status getStatus();

	public Boolean getVerified();

	public String getNotes();

}