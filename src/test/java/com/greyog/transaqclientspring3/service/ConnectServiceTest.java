package com.greyog.transaqclientspring3.service;

import com.greyog.transaqclientspring3.config.MyConfigClass;
import com.greyog.transaqclientspring3.entity.command.ConnectCommand;
import com.greyog.transaqclientspring3.entity.command.DisconnectCommand;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MyConfigClass.class , ConnectService.class})
class ConnectServiceTest {

    Logger logger = LoggerFactory.getLogger(ConnectServiceTest.class);

    @Autowired
    ConnectService connectService;

    @Test
    void getLoginCommand() {
        var connectCommand = new ConnectCommand();
        connectCommand.login = "transaq.login";
        connectCommand.password = "transaq.password";
        connectCommand.host = "transaq.host";
        connectCommand.port = 123;
        connectCommand.rqdelay = 100;
        connectCommand.session_timeout = 1000;
        connectCommand.request_timeout = 20;
//        connectCommand.push_u_limits = 20;
        connectCommand.autopos = true;
//        System.out.println(connectService.getXMLCommand(connectCommand));
        logger.info(() -> connectService.getXMLCommand(connectCommand));

    }

    @Test
    void getDisconnectCommand() {
        logger.info(() -> connectService.getXMLCommand(new DisconnectCommand()));
    }
}