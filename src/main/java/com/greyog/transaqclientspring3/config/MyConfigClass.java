package com.greyog.transaqclientspring3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import java.util.HashMap;

@Configuration
public class MyConfigClass {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // marshaller.setContextPath(<jaxb.context-file>)
         marshaller.setPackagesToScan("com.greyog.transaqclientspring3.command");

        marshaller.setMarshallerProperties(new HashMap<>() {{
            put(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, true);
        }});

        return marshaller;
    }

//    @Bean
//    public ConnectServiceGrpc.ConnectServiceBlockingStub blockingStub() {
//        // Access a service running on the local machine on port 7777
//        String target = "localhost:7777";
//
//// Create a communication channel to the server, known as a Channel. Channels are thread-safe
//// and reusable. It is common to create channels at the beginning of your application and reuse
//// them until the application shuts down.
//        ManagedChannel channel = ManagedChannelBuilder.forTarget(target)
//                // Channels are secure by default (via SSL/TLS). For the example we disable TLS to avoid
//                // needing certificates.
//                .usePlaintext()
//                .build();
//
//        return ConnectServiceGrpc.newBlockingStub(
//        );
//    }
}
