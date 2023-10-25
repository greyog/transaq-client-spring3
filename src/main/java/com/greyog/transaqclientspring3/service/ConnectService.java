package com.greyog.transaqclientspring3.service;

import com.greyog.transaqclientspring3.command.ConnectCommand;
import com.greyog.transaqclientspring3.command.DisconnectCommand;
import com.greyog.transaqclientspring3.command.ServerStatusCommand;
import com.greyog.transaqclientspring3.component.MessageProcessor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;

import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;

@Slf4j
@Service
public class ConnectService {

//    @Autowired
//    private ConnectServiceGrpc.ConnectServiceBlockingStub blockingStub;

    @Autowired
    private Jaxb2Marshaller marshaller;

    public String getLoginCommand() {
        var connectCommand = new ConnectCommand();
        connectCommand.login = "login_here";
        connectCommand.password = "password_here";
        connectCommand.host = "tr1.finam.ru";
        connectCommand.port = 3900;
        connectCommand.rqdelay = 100;
        connectCommand.session_timeout = 1000;
        connectCommand.request_timeout = 1000;
        return getXMLCommand(connectCommand);
    }

    @SneakyThrows
    private <T> String getXMLCommand(final T command) {
        StringWriter sw = new StringWriter();
        Result result = new StreamResult(sw);
        marshaller.marshal(command, result);
        log.info("marshall result: {}", sw);
        return sw.toString();
    }

    public String getLoginResult() {
        String command = getLoginCommand();
        String requestResult = getRequestResult(command);
        return requestResult;
    }

    private String getRequestResult(String command) {
//        Connect.SendCommandRequest request = Connect.SendCommandRequest.newBuilder()
//                .setMessage(command)
//                .build();
//        Connect.SendCommandResponse response = blockingStub.sendCommand(request);
//        String r = new String(response.toByteArray(), StandardCharsets.UTF_8);
//        log.info("response: {}", response);
        return "r";
    }

    public String getDisconnectCommand() {
        return getXMLCommand(new DisconnectCommand());
    }

    public String getDisconnectResult() {
        return getRequestResult(getDisconnectCommand());
    }

    public String getServerStatus() {
        return getRequestResult(getServerStatusCommand());
    }

    private String getServerStatusCommand() {
        return getXMLCommand(new ServerStatusCommand());
    }

    private TaskExecutor taskExecutor;

    private MessageProcessor messageProcessor;

    public String initDataFetch() throws Exception {
        taskExecutor.execute(messageProcessor);
        return "Started processing of messages...";
    }
}
