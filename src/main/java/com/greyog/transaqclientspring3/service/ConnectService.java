package com.greyog.transaqclientspring3.service;

import com.greyog.transaqclientspring3.entity.command.AbstractCommand;
import com.greyog.transaqclientspring3.entity.command.ConnectCommand;
import com.greyog.transaqclientspring3.entity.command.DisconnectCommand;
import com.greyog.transaqclientspring3.entity.command.ServerStatusCommand;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import transaqConnector.Connect;
import transaqConnector.ConnectServiceGrpc;

import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.Executor;

@Slf4j
@Service
public class ConnectService {

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

    @SneakyThrows
    public  <T extends AbstractCommand> String getXMLCommand(final T command) {
        StringWriter sw = new StringWriter();
        Result result = new StreamResult(sw);
        marshaller.marshal(command, result);
//        log.info("marshall result: {}", sw);
        return sw.toString();
    }

//    public String getLoginResult() {
//        String command = getLoginCommand();
//        String requestResult = getRequestResult(command);
//        return requestResult;
//    }

    public String getRequestResult(String xmlCommand) {
        var request = Connect.SendCommandRequest.newBuilder()
                .setMessage(xmlCommand)
                .build();
        var response = blockingStub.sendCommand(request);
        String r = new String(response.toByteArray(), StandardCharsets.UTF_8);
        log.info("""
            Request: {};
            Result: {}""", request, response.getMessage());
        return response.getMessage();
    }

    public <T extends AbstractCommand> String sendCommand(final T command) {
        return getRequestResult(getXMLCommand(command));
    }

//    public String getDisconnectCommand() {
//        return getXMLCommand(new DisconnectCommand());
//    }
//
//    public String getDisconnectResult() {
//        return getRequestResult(getDisconnectCommand());
//    }
//
//    public String getServerStatus() {
//        return getRequestResult(getServerStatusCommand());
//    }
//
//    private String getServerStatusCommand() {
//        return getXMLCommand(new ServerStatusCommand());
//    }

//    public String initDataFetch() {
//        messageProcessorService.run();
//        return "Started processing of messages...";
//    }
}
