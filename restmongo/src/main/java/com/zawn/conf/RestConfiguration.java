package com.zawn.conf;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.mapping.event.ValidatingMongoEventListener;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.core.event.ValidatingRepositoryEventListener;
import org.springframework.data.rest.core.mapping.ExposureConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

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
import com.zawn.domain.StatusEnum;
import com.zawn.domain.StatusWithSuspendedEnum;
import com.zawn.domain.Steps;
import com.zawn.domain.Subscriptions;
import com.zawn.domain.Tasks;
import com.zawn.domain.Templates;
import com.zawn.domain.Timelines;
import com.zawn.domain.Users;
import com.zawn.domain.Wallets;

@Configuration
public class RestConfiguration implements  RepositoryRestConfigurer {
    
    @Bean
    public LocalValidatorFactoryBean localValidatorFactoryBean() {
        return new LocalValidatorFactoryBean();
    }
    @Bean
    public ValidatingMongoEventListener validatingMongoEventListener(LocalValidatorFactoryBean lfb) {
        return new ValidatingMongoEventListener(lfb);
    }
    
    // Configure validator
//    @Override
//    public void configureValidatingRepositoryEventListener(ValidatingRepositoryEventListener  validatingListener) {
//        validatingListener.addValidator("afterCreate", validator());
//        validatingListener.addValidator("beforeCreate", validator());
//        validatingListener.addValidator("afterSave", validator());
//        validatingListener.addValidator("beforeSave", validator());
//    }
    
    // Configure exposure
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration restConfig) {
    	
    	//restConfig.useHalAsDefaultJsonMediaType(false);
    	//restConfig.setDefaultMediaType(MediaType.APPLICATION_JSON);
    	
    	restConfig.getCorsRegistry().addMapping("/**").
    		allowedOrigins("*").
    		allowedMethods("*");
    	
        ExposureConfiguration config = restConfig.getExposureConfiguration();
        
        config.forDomainType(Users.class).
        	withItemExposure((metadata, httpMethods) ->
        		httpMethods.disable(HttpMethod.POST, HttpMethod.PUT, HttpMethod.PATCH, HttpMethod.DELETE)).
        	withCollectionExposure((metadata, httpMethods) ->
    			httpMethods.disable(HttpMethod.POST, HttpMethod.PUT, HttpMethod.PATCH, HttpMethod.DELETE)).
        	withAssociationExposure((metadata, httpMethods) ->
				httpMethods.disable(HttpMethod.POST, HttpMethod.PUT, HttpMethod.PATCH, HttpMethod.DELETE));
        
        config.forDomainType(Logs.class).
        	withItemExposure((metadata, httpMethods) ->
        		httpMethods.disable(HttpMethod.DELETE)).
        	withAssociationExposure((metadata, httpMethods) ->
        		httpMethods.disable(HttpMethod.DELETE));
        
        // Expose ID fields
        restConfig.exposeIdsFor(
        		Users.class
        		,Certificators.class
        		,Customers.class
        		,Devices.class
        		,Documents.class
        		,Flows.class
        		,Infos.class
        		,Licences.class
        		,Limits.class
        		,Logs.class
        		,Modules.class
        		,Notarizations.class
        		,Notifications.class
        		,Operations.class
        		,Parameters.class
        		,Payments.class
        		,Presets.class
        		,Seats.class
        		,Sequences.class
        		,Settings.class
        		,Steps.class
        		,Subscriptions.class
        		,Tasks.class
        		,Templates.class
        		,Timelines.class
        		,Users.class
        		,Wallets.class
        		);
        
    }
    
    
}