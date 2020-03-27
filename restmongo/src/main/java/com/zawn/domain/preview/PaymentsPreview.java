
package com.zawn.domain.preview;

import org.springframework.data.rest.core.config.Projection;

import com.zawn.domain.Payments;
import com.zawn.domain.Wallets;

@Projection(name = "PaymentsPreview", types = { com.zawn.domain.Payments.class })
public interface PaymentsPreview  extends AbstractDocumentPreview{
	public Wallets getIdwallet();

	public String getIdtransaction();

	public Payments.Type getType();

	public Payments.Cycle getCycle();

	public Double getAmount();

	public String getCurrency();

	public String getName();

	public String getDescription();

	public Payments.Gateway getGateway();

	public Payments.Result getResult();

	public Boolean getHidden();

	public Payments.Status getStatus();

	public Boolean getVerified();

	public String getNotes();

}