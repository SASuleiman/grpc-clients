package org.devgurus.grpcclients.config;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientConfiguration {

    @Value("${GRPC_HOST:localhost}")
    private String host;

    @Value("${GRPC_PORT:9020}")
    private int port;

    @Bean
    public ManagedChannel managedChannel() {
        return ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();
    }
}
