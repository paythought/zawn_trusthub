package com.zawn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.AfterDeleteEvent;
import org.springframework.data.mongodb.core.mapping.event.AfterSaveEvent;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

import com.zawn.domain.AbstractLoggedDocument;
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
import com.zawn.repository.LogsRepository;
@Component
public class AfterDBListener extends AbstractMongoEventListener<AbstractLoggedDocument> {
	@Autowired
	private LogsRepository logsRepo;
	
	

	@Override
	public void onAfterDelete(AfterDeleteEvent<AbstractLoggedDocument> event) {
		
		Logs logs=new Logs();
		logs.setType(Logs.Type.DELETE);
		logs.setNotes(event.getCollectionName());
		logs = logsRepo.insert(logs);
		
		super.onAfterDelete(event);
	}
	

	@Override
	public void onBeforeConvert(BeforeConvertEvent<AbstractLoggedDocument> event) {
		AbstractLoggedDocument domain = event.getSource();
		
		Logs logs=new Logs();
		logs.setType(domain.getId()==null?Logs.Type.CREATE:Logs.Type.UPDATE  );
		logs = logsRepo.insert(logs);
		
		domain.getLogs().add(logs);
		
		super.onBeforeConvert(event);
	}
	@Override
	public void onAfterSave(AfterSaveEvent<AbstractLoggedDocument> event) {
		AbstractLoggedDocument domain = event.getSource();
		Logs logs=domain.getLogs().get(domain.getLogs().size()-1);
		//Comment bellow to DISABLE Logging.
		setTarget(logs,domain);
		
		logsRepo.save(logs);
		
		super.onAfterSave(event);
	}

	private void setTarget(Logs logs, AbstractLoggedDocument doc) {
		if(doc instanceof Users)
			logs.setIduser((Users)doc);
		else if(doc instanceof Customers  )
			logs.setIdcustomer((Customers)doc);
		else if(doc instanceof Operations )
			logs.setIdoperation (( Operations)doc);
		else if(doc instanceof Timelines )
			logs.setIdtimeline (( Timelines)doc);
		else if(doc instanceof Parameters )
			logs.setIdparameter ((Parameters )doc);
		else if(doc instanceof Sequences )
			logs.setIdsequence (( Sequences)doc);
		else if(doc instanceof Steps  )
			logs.setIdstep (( Steps)doc);
		else if(doc instanceof Infos )
			logs.setIdinfo ((Infos )doc);
		else if(doc instanceof Documents )
			logs.setIddocument (( Documents)doc);
		else if(doc instanceof Templates )
			logs.setIdtemplate (( Templates)doc);
		else if(doc instanceof Flows )
			logs.setIdflow ((Flows )doc);
		else if(doc instanceof Notifications )
			logs.setIdnotification ((Notifications )doc);
		else if(doc instanceof Tasks )
			logs.setIdtask (( Tasks)doc);
		else if(doc instanceof Subscriptions )
			logs.setIdsubscription (( Subscriptions)doc);
		else if(doc instanceof Settings )
			logs.setIdsetting ((Settings)doc);
		else if(doc instanceof Modules )
			logs.setIdmodule (( Modules)doc);
		else if(doc instanceof Presets )
			logs.setIdpreset (( Presets)doc);
		else if(doc instanceof Limits )
			logs.setIdlimit (( Limits)doc);
		else if(doc instanceof Certificators )
			logs.setIdcertificator ((Certificators )doc);
		else if(doc instanceof Seats )
			logs.setIdseat (( Seats)doc);
		else if(doc instanceof Devices )
			logs.setIddevice (( Devices)doc);
		else if(doc instanceof Licences )
			logs.setIdlicence (( Licences)doc);
		else if(doc instanceof  Notarizations)
			logs.setIdnotarization (( Notarizations)doc);
		else if(doc instanceof Wallets )
			logs.setIdwallet ((Wallets )doc);
		else if(doc instanceof Payments )
			logs.setIdpayment (( Payments)doc);
	}
	
	}