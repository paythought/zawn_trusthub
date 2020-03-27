package com.zawn.conf;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.convert.CustomConversions;

//@Configuration
//@EnableMongoRepositories
public class MongoClientConfiguration extends AbstractMongoClientConfiguration  {
	@Autowired
	private List<Converter<?, ?>> converters;
	
	
	@Override
	protected String getDatabaseName() {
		return "zwrt";
	}

	@Override
	public com.mongodb.client.MongoClient mongoClient() {
		//return MongoClients.create("mongodb://localhost:27017/?replicaSet=rs0&w=majority");
		return null;
	}
	
	@Override
	public CustomConversions customConversions() {
		return new CustomConversions(converters);
	}

}
//public class MongoClientConfiguration extends AbstractMongoConfiguration {
//
//	  @Override
//	  public String getDatabaseName() {
//	    return "database";
//	  }
//
//	  @Override
//	  @Bean
//	  public MongoClient mongoClient() {
//	    return new MongoClient(singletonList(new ServerAddress("127.0.0.1", 27017)),
//	      singletonList(MongoCredential.createCredential("name", "db", "pwd".toCharArray())));
//	  }
//	}
