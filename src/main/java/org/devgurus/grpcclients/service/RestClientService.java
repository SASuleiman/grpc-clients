package org.devgurus.grpcclients.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.devgurus.grpcclients.client.RestFeignClient;
import org.devgurus.grpcclients.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RestClientService {


    private final RestFeignClient client;

    public ClientResponse callRestClient(ClientRequest request) {
        String route = "rest-client";
        RestFraudCheckResponse response = client.doFraudCheck(request.getAmount());
        return ClientResponse.builder()
                .route(request.getRoute())
                .message(response.getMessage())
                .fraudTransaction(response.isFraudTransaction())
                .pastTransactionCountGenerated(response.getPastTransactionCountGenerated())
                .build();
    }
}
