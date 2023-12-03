package com.greyog.transaqclientspring3.service;

import com.greyog.transaqclientspring3.component.Server;
import com.greyog.transaqclientspring3.entity.message.*;
import jakarta.xml.bind.JAXBException;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import transaqConnector.Connect;
import transaqConnector.ConnectServiceGrpc;


import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@Slf4j
@Component
public class MessageProcessorServiceImpl implements MessageProcessorService {

    @Autowired
    private ConnectServiceGrpc.ConnectServiceBlockingStub blockingStub;

    @Autowired
    private Jaxb2Marshaller marshaller;

    @Autowired
    private Server server;
    private List<Consumer<String>> listeners = new ArrayList<>();

    @Override
    @SneakyThrows
    @Async
    public void run() {
        var dataRequest = Connect.DataRequest.newBuilder().build();
        var dataResponseIterator = blockingStub.fetchResponseData(dataRequest);
        var unmarshaller = marshaller.createUnmarshaller();
        dataResponseIterator.forEachRemaining(dataResponse -> {
                    var message = dataResponse.getMessage();
                    var reader = new StringReader(message);
                    try {
                        var obj = unmarshaller.unmarshal(reader);
                        processObject(obj, message);
                    } catch (JAXBException e) {
                        log.error("Couldn't parse message: {}", message);
                    }
                }
        );
        log.info("MessageProcessorService finished");
    }

    @Async
    private void processObject(Object object, String message) {
        if (!(object instanceof Pits) &&
                !(object instanceof SecInfoUpd) &&
                !(object instanceof Securities)) {
            log.info("Processed massage for type: {}", object.getClass());
        }
        if (object instanceof Loggable) {
//            log.info(message);
//            log.info(object.toString());
        }
        if (object instanceof ServerStatus serverStatus) {
            server.setServerStatus(serverStatus);
        }
        if (object instanceof Client client) {
            server.addClientInfo(client);
        }
        if (object instanceof Positions positions) {
            server.setPositions(positions);
        }
        listeners.forEach(stringConsumer -> stringConsumer.accept(object.getClass().toString()));
    }

    @Override
    public void addListener(Consumer<String> stringConsumer) {
        listeners.add(stringConsumer);
    }
}

