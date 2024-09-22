package com.iitj.ecgserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class EcgserverApplication {

	public static void main(String[] args) {
		new EcgserverApplication().startApplication(args);
	}
	/* private method to start application */
	private void startApplication(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(EcgserverApplication.class, args);
		applicationContext.registerShutdownHook();
	}

}
