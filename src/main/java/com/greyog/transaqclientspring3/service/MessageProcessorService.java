package com.greyog.transaqclientspring3.service;

import com.greyog.transaqclientspring3.message.Client;
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
import java.util.Iterator;

@Slf4j
@Component
public class MessageProcessorService {

    @Autowired
    private ConnectServiceGrpc.ConnectServiceBlockingStub blockingStub;

    @Autowired
    private Jaxb2Marshaller marshaller;

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
//                        log.info("Processed massage for type: {}", obj.getClass());
                        processObject(obj);
                    } catch (JAXBException e) {
                        log.error("Couldn't parse message: {}", message);
//                        log.error("Exception message: ", e);
                    }
                }
        );
    }

    private void processObject(Object object) {
        log.info(object.toString());
    }

}

