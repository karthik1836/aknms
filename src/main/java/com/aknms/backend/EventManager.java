package com.aknms.backend;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;

/**
 * Application start for EventManager
 *
 */
@SpringBootApplication
public class EventManager {
	public static void main(String[] args) throws InterruptedException {
		//Thread.sleep(15000L);
		SpringApplication.run(EventManager.class, args);
	}
	
	@Bean
	public TomcatServletWebServerFactory httpsRedirectConfig() {
		TomcatServletWebServerFactory tomcat =  new TomcatServletWebServerFactory () {
	        @Override
	        protected void postProcessContext(Context context) {
	            SecurityConstraint securityConstraint = new SecurityConstraint();
	            securityConstraint.setUserConstraint("CONFIDENTIAL");
	            SecurityCollection collection = new SecurityCollection();
	            collection.addPattern("/*");
	            securityConstraint.addCollection(collection);
	            context.addConstraint(securityConstraint);
	        }
	    };
	    tomcat.addAdditionalTomcatConnectors(redirectConnector());
	    return tomcat;
	}

	private Connector redirectConnector() {
	  Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
	  connector.setScheme("http");
	  connector.setPort(8080);
	  connector.setSecure(false);
	  connector.setRedirectPort(8443);
	  
	  return connector;
	
}
}
