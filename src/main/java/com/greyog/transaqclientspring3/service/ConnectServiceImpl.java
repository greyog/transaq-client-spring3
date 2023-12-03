package com.greyog.transaqclientspring3.service;

import com.greyog.transaqclientspring3.entity.command.AbstractCommand;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import transaqConnector.Connect;
import transaqConnector.ConnectServiceGrpc;

import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;

@Slf4j
@Service
public class ConnectServiceImpl implements ConnectService {

    @Autowired
    private ConnectServiceGrpc.ConnectServiceBlockingStub blockingStub;

    @Autowired
    private Jaxb2Marshaller marshaller;


//    private String getLoginCommand() {
//        var connectCommand = new ConnectCommand();
//        connectCommand.login = environment.getProperty("transaq.login");
//        connectCommand.password = environment.getProperty("transaq.password");
//        connectCommand.host = environment.getProperty("transaq.host");
//        connectCommand.port = Integer.parseInt(environment.getProperty("transaq.port"));
//        connectCommand.rqdelay = 100;
//        connectCommand.session_timeout = 1000;
//        connectCommand.request_timeout = 20;
////        connectCommand.push_u_limits = 20;
//        connectCommand.autopos = true;
//        return getXMLCommand(connectCommand);
//    }

    @Override
    @SneakyThrows
    public  <T extends AbstractCommand> String getXMLCommand(final T command) {
        StringWriter sw = new StringWriter();
        Result result = new StreamResult(sw);
        marshaller.marshal(command, result);
        return sw.toString();
    }

    @Override
    public String getRequestResult(String xmlCommand) {
        var request = Connect.SendCommandRequest.newBuilder()
                .setMessage(xmlCommand)
                .build();
        var response = blockingStub.sendCommand(request);
        String r = new String(response.toByteArray(), StandardCharsets.UTF_8);
//        log.info("""
//            Request: {};
//            Result: {}""", request, response.getMessage());
        return response.getMessage();
    }

    @Override
    public <T extends AbstractCommand> String sendCommand(final T command) {
        return getRequestResult(getXMLCommand(command));
    }

}
