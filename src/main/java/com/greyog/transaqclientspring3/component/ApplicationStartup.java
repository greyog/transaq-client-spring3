package com.greyog.transaqclientspring3.component;

import com.greyog.transaqclientspring3.service.ConnectService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    private ConnectService connectService;

    /**
     * This event is executed as late as conceivably possible to indicate that
     * the application is ready to service requests.
     */
    @SneakyThrows
    @Override
    public void onApplicationEvent(final ApplicationReadyEvent event) {
        log.info("Init data fetch result: {}", connectService.initDataFetch());
        log.info("Login result: {}", connectService.getLoginResult());

//        while (true) {
//            log.info(connectService.getServerStatus());
//            Thread.sleep(1000);
//        }
    }
}