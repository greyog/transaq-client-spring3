package com.greyog.transaqclientspring3;

import com.greyog.transaqclientspring3.service.ConnectService;
import com.vaadin.flow.theme.Theme;
import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class TransaqClientSpring3Application {

	public static void main(String[] args) {
		SpringApplication.run(TransaqClientSpring3Application.class, args);
	}

	ConnectService connectService;

	@PreDestroy
	public void onExit(){
		log.info("########### Disconnect and exit #############");
		String result = connectService.getDisconnectResult();
		try {
			Thread.sleep(2 * 1000);
		} catch (InterruptedException e) {
			log.error("InterruptedException",e);
		}
		log.info("Disconnect result: {}", result);
	}

}