package com.greyog.transaqclientspring3.config;

import com.greyog.transaqclientspring3.controller.DynamicContentServlet;
import com.greyog.transaqclientspring3.entity.message.ServerStatus;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import transaqConnector.Connect;
import transaqConnector.ConnectServiceGrpc;

import java.util.HashMap;
import java.util.concurrent.Executor;

@Configuration
@EnableScheduling
public class MyConfigClass {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // marshaller.setContextPath(<jaxb.context-file>)
         marshaller.setPackagesToScan("com.greyog.transaqclientspring3.entity.command",
                 "com.greyog.transaqclientspring3.entity.message");

        marshaller.setMarshallerProperties(new HashMap<>() {{
            put(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, true);
        }});

        return marshaller;
    }

    @Bean
    public ConnectServiceGrpc.ConnectServiceBlockingStub blockingStub() {
        // Access a service running on the local machine on port 7777
        String target = "localhost:50051";

// Create a communication channel to the server, known as a Channel. Channels are thread-safe
// and reusable. It is common to create channels at the beginning of your application and reuse
// them until the application shuts down.
        ManagedChannel channel = ManagedChannelBuilder.forTarget(target)
                // Channels are secure by default (via SSL/TLS). For the example we disable TLS to avoid
                // needing certificates.
                .usePlaintext()
                .build();

        return ConnectServiceGrpc.newBlockingStub(channel);
    }

    @Bean
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(2);
        executor.setQueueCapacity(500);
        executor.setThreadNamePrefix("MessageAsync-");
        executor.initialize();
        return executor;
    }

    @Bean(name = "applicationEventMulticaster")
    public ApplicationEventMulticaster simpleApplicationEventMulticaster() {
        SimpleApplicationEventMulticaster eventMulticaster =
                new SimpleApplicationEventMulticaster();

        eventMulticaster.setTaskExecutor(new SimpleAsyncTaskExecutor());
        return eventMulticaster;
    }

    @Bean
    public ServletRegistrationBean exampleServletBean() {
        ServletRegistrationBean bean = new ServletRegistrationBean(
                new DynamicContentServlet(), "/image");
        bean.setLoadOnStartup(1);
        return bean;
    }

}
