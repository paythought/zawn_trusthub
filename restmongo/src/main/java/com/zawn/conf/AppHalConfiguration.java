package com.zawn.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.LinkRelation;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.hateoas.mediatype.hal.HalConfiguration;
import org.springframework.hateoas.mediatype.hal.HalConfiguration.RenderSingleLinks;
import org.springframework.hateoas.mediatype.hal.forms.HalFormsConfiguration;

@Configuration
//@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL_FORMS)
public class AppHalConfiguration {

	public HalConfiguration linkRelationBasedPolicy() {
		
	  return new HalConfiguration()
		 .withRenderSingleLinks(RenderSingleLinks.AS_SINGLE)
//	      .withRenderSingleLinksFor( 
//	          IanaLinkRelations.ITEM, RenderSingleLinks.AS_ARRAY) 
//	      .withRenderSingleLinksFor( 
//	          LinkRelation.of("prev"), RenderSingleLinks.AS_SINGLE)
	      ; 
	}
	
//	@Bean
	public HalFormsConfiguration media2() {
		return new HalFormsConfiguration()
				//.registerPattern(type, pattern)
				;
	}
	
}
