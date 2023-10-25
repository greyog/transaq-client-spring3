package com.greyog.transaqclientspring3.service;

import com.greyog.transaqclientspring3.config.MyConfigClass;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MyConfigClass.class , ConnectService.class})
class ConnectServiceTest {

    @Autowired
    ConnectService connectService;

    @Test
    void getLoginCommand() {
        connectService.getLoginCommand();
    }

    @Test
    void getDisconnectCommand() {
        connectService.getDisconnectCommand();
    }
}