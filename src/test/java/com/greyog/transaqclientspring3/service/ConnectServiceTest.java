package com.greyog.transaqclientspring3.service;

import com.greyog.transaqclientspring3.config.MyConfigClass;
import com.greyog.transaqclientspring3.entity.command.ConnectCommand;
import com.greyog.transaqclientspring3.entity.command.DisconnectCommand;
import com.greyog.transaqclientspring3.entity.command.GetMarketsCommand;
import com.greyog.transaqclientspring3.entity.command.GetOptionFamiliesCommand;
import com.greyog.transaqclientspring3.entity.message.Security;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MyConfigClass.class , ConnectServiceImpl.class})
class ConnectServiceTest {

    Logger logger = LoggerFactory.getLogger(ConnectServiceTest.class);

    @Autowired
    ConnectService connectService;

    @Test
    void getLoginCommand() {
        var connectCommand = ConnectCommand.builder()
                .login("login")
                .build();
//        connectCommand.login = "transaq.login";
//        connectCommand.password = "transaq.password";
//        connectCommand.host = "transaq.host";
//        connectCommand.port = 123;
//        connectCommand.rqdelay = 100;
//        connectCommand.session_timeout = 1000;
//        connectCommand.request_timeout = 20;
////        connectCommand.push_u_limits = 20;
//        connectCommand.autopos = true;
//        System.out.println(connectService.getXMLCommand(connectCommand));
        logger.info(() -> connectService.getXMLCommand(connectCommand));

    }

    @Test
    void getDisconnectCommand() {
        logger.info(() -> connectService.getXMLCommand(new DisconnectCommand()));
    }

    @Test
    void getMarketsCommand() {
        var command = new GetMarketsCommand();
        String xmlCommand = connectService.getXMLCommand(command);
        logger.info(() -> xmlCommand);
        assert xmlCommand.contains("get_markets");
    }

    @Test
    void securityCommand() {
        var command = new GetOptionFamiliesCommand(new Security("RIU3", "FUT"));
        String xmlCommand = connectService.getXMLCommand(command);
        logger.info(() -> xmlCommand);
        assert xmlCommand.contains("option");
    }

}