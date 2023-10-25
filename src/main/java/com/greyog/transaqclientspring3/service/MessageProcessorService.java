package com.greyog.transaqclientspring3.service;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import transaqConnector.Connect;
import transaqConnector.ConnectServiceGrpc;


import java.util.Iterator;

@Slf4j
@Component
public class MessageProcessorService {

    @Autowired
    private ConnectServiceGrpc.ConnectServiceBlockingStub blockingStub;

    @SneakyThrows
    @Async
    public void run() {
        Connect.DataRequest dataRequest = Connect.DataRequest.newBuilder()
                .build();
        Iterator<Connect.DataResponse> dataResponseIterator = blockingStub.fetchResponseData(dataRequest);
        while (true) {
            dataResponseIterator.forEachRemaining(dataResponse ->
                    log.info("Got some data: {}", dataResponse.getMessage())
            );
            Thread.sleep(1000);
        }

//        for (int i = 0; dataResponseIterator.hasNext(); i++) {
//            Connect.DataResponse dataResponse = dataResponseIterator.next();
//            log.info("Got some data: {}", dataResponse.getMessage());
//        }
    }
}

