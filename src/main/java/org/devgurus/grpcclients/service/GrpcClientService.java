package org.devgurus.grpcclients.service;

import io.grpc.ManagedChannel;
import org.devgurus.grpcclients.dto.ClientRequest;
import org.devgurus.grpcclients.dto.ClientResponse;
import org.devgurus.grpcimplementation.GreetingRequest;
import org.devgurus.grpcimplementation.GreetingResponse;
import org.devgurus.grpcimplementation.GreetingServiceGrpc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GrpcClientService {

    private final ManagedChannel channel;


    @Autowired
    public GrpcClientService(ManagedChannel channel) {
        this.channel = channel;
    }

    public ClientResponse callClient(ClientRequest request) {
        String response = getGreetingMessage(request.getName());
        String grpcServiceName = "grpc-client";
        return new ClientResponse(response, grpcServiceName);
    }
    private String getGreetingMessage(String name) {

        GreetingServiceGrpc.GreetingServiceBlockingStub stub = GreetingServiceGrpc.newBlockingStub(channel);

        // Prepare the gRPC request
        GreetingRequest request = GreetingRequest.newBuilder()
                .setName(name)
                .build();

        // Call the gRPC server and return the response
        GreetingResponse response = stub.greet(request);
        return response.getMessage();
    }
}
