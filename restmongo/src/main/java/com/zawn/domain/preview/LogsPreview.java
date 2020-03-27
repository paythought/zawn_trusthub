
package com.zawn.domain.preview;

import java.math.BigInteger;
import java.util.Date;

import org.springframework.data.rest.core.config.Projection;

import com.zawn.domain.Certificators;
import com.zawn.domain.Customers;
import com.zawn.domain.Devices;
import com.zawn.domain.Documents;
import com.zawn.domain.Flows;
import com.zawn.domain.Infos;
import com.zawn.domain.Licences;
import com.zawn.domain.Limits;
import com.zawn.domain.Logs;
import com.zawn.domain.Modules;
import com.zawn.domain.Notarizations;
import com.zawn.domain.Notifications;
import com.zawn.domain.Operations;
import com.zawn.domain.Parameters;
import com.zawn.domain.Payments;
import com.zawn.domain.Presets;
import com.zawn.domain.Seats;
import com.zawn.domain.Sequences;
import com.zawn.domain.Settings;
import com.zawn.domain.Steps;
import com.zawn.domain.Subscriptions;
import com.zawn.domain.Tasks;
import com.zawn.domain.Templates;
import com.zawn.domain.Timelines;
import com.zawn.domain.Users;
import com.zawn.domain.Wallets;

@Projection(name = "LogsPreview", types = { com.zawn.domain.Logs.class })
public interface LogsPreview  extends AbstractDocumentPreview{
	public String getIdabis();

	public Users getIduser();

	public Customers getIdcustomer();

	public Operations getIdoperation();

	public Timelines getIdtimeline();

	public Parameters getIdparameter();

	public Sequences getIdsequence();

	public Steps getIdstep();

	public Infos getIdinfo();

	public Documents getIddocument();

	public Templates getIdtemplate();

	public Flows getIdflow();

	public Notifications getIdnotification();

	public Tasks getIdtask();

	public Subscriptions getIdsubscription();

	public Settings getIdsetting();

	public Modules getIdmodule();

	public Presets getIdpreset();

	public Limits getIdlimit();

	public Certificators getIdcertificator();

	public Seats getIdseat();

	public Devices getIddevice();

	public Licences getIdlicence();

	public Notarizations getIdnotarization();

	public Wallets getIdwallet();

	public Payments getIdpayment();

	public String getName();

	public String getDescription();

	public Logs.Type getType();

	public Double getCode();

	public String getImei();

	public String getIp();

	public String getMac();

	public Date getTime();

	public String getGps();

	public Double getSid();

	public Boolean getHidden();

	public Logs.Status getStatus();

	public Boolean getVerified();

	public String getNotes();

}