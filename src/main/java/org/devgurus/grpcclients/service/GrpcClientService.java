package org.devgurus.grpcclients.service;

import io.grpc.ManagedChannel;
import org.devgurus.grpcclients.dto.ClientRequest;
import org.devgurus.grpcclients.dto.ClientResponse;
import org.devgurus.grpcimplementation.*;
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
        FraudCheckResponse fraudCheckResponse = doFraudCheck(request);
        String grpcServiceName = "grpc-client";
        return ClientResponse.builder()
                .fraudTransaction(fraudCheckResponse.getFraudTransaction())
                .pastTransactionCountGenerated(fraudCheckResponse.getPastTransactionCountGenerated())
                .message(fraudCheckResponse.getMessage())
                .route(request.getRoute())
                .build();
    }


//    private String getGreetingMessage(String name) {
//
//        GreetingServiceGrpc.GreetingServiceBlockingStub stub = GreetingServiceGrpc.newBlockingStub(channel);
//
//        // Prepare the gRPC request
//        GreetingRequest request = GreetingRequest.newBuilder()
//                .setName(name)
//                .build();
//
//        // Call the gRPC server and return the response
//        GreetingResponse response = stub.greet(request);
//        return response.getMessage();
//    }

    private FraudCheckResponse doFraudCheck(ClientRequest request) {
        FraudCheckServiceGrpc.FraudCheckServiceBlockingStub stub = FraudCheckServiceGrpc.newBlockingStub(channel);

        // Prepare the gRPC request
        FraudCheckRequest grpcRequest = FraudCheckRequest.newBuilder()
                .setRoute(request.getRoute())
                .setAmount(request.getAmount())
                .build();

        // Call the gRPC server and return the response
        return stub.fraudCheck(grpcRequest);
    }
}
