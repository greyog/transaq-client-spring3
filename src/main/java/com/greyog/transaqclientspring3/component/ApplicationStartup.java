package com.greyog.transaqclientspring3.component;

import com.greyog.transaqclientspring3.entity.command.AbstractCommand;
import com.greyog.transaqclientspring3.entity.command.ChangePasswordCommand;
import com.greyog.transaqclientspring3.entity.command.ConnectCommand;
import com.greyog.transaqclientspring3.entity.command.ServerStatusCommand;
import com.greyog.transaqclientspring3.service.ConnectService;
import com.greyog.transaqclientspring3.service.MessageProcessorService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent>, HeartBeat {

    @Autowired
    private ConnectService connectService;
    @Autowired
    private Environment environment;
    @Autowired
    private MessageProcessorService messageProcessorService;
    @Autowired
    private Server server;

    /**
     * This event is executed as late as conceivably possible to indicate that
     * the application is ready to service requests.
     */
    @SneakyThrows
    @Override
    public void onApplicationEvent(final ApplicationReadyEvent event) {
        messageProcessorService.run();
        var connectCommand = new ConnectCommand();
        connectCommand.login = environment.getProperty("transaq.login");
        connectCommand.password = environment.getProperty("transaq.password");
        connectCommand.host = environment.getProperty("transaq.host");
        connectCommand.port = Integer.parseInt(environment.getProperty("transaq.port"));
        connectCommand.rqdelay = 100;
        connectCommand.session_timeout = 1000;
        connectCommand.request_timeout = 20;
        connectCommand.push_u_limits = 30;
        connectCommand.autopos = true;
        connectService.sendCommand(connectCommand);

//        while (true) {
//            log.info(connectService.getServerStatus());
//            Thread.sleep(1000);
//        }
    }

    private int order = 0;

    @Override
    @Async
    @Scheduled(fixedRate = 10000)
    public void heartBeat() {
        if (!server.isConnected()) return;
//        var changePasswordCommand = new ChangePasswordCommand();
//        changePasswordCommand.oldpass = environment.getProperty("transaq.password");
//        changePasswordCommand.newpass = environment.getProperty("transaq.newPassword");
//        log.info(changePasswordCommand.toString());
        switch (order) {
            case 0 -> {
                connectService.sendCommand(new ServerStatusCommand());
                order++;
            }
            case 1 -> {
                connectService.sendCommand(new ServerStatusCommand());
                order++;
            }
        }
//       todo relogin on Result: <result success="false"><message>Cannot process this command without connection.</message></result>
    }


}