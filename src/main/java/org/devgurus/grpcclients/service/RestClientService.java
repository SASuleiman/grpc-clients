package org.devgurus.grpcclients.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.devgurus.grpcclients.client.RestFeignClient;
import org.devgurus.grpcclients.dto.ClientRequest;
import org.devgurus.grpcclients.dto.ClientResponse;
import org.devgurus.grpcclients.dto.RestGreetingRequest;
import org.devgurus.grpcclients.dto.RestGreetingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RestClientService {


    private final RestFeignClient client;

    public ClientResponse callRestClient(ClientRequest request) {
        String route = "rest-client";
        RestGreetingResponse response = client.greet(new RestGreetingRequest(request.getName()));
        return new ClientResponse(response.getMessage(),route);
    }
}
