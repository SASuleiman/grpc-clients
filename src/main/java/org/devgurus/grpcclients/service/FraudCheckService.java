package org.devgurus.grpcclients.service;


import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.devgurus.grpcclients.dto.RestFraudCheckResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FraudCheckService {

    private final RestTemplate restTemplate;
    private final String fraudCheckUrl;

    public FraudCheckService(RestTemplate restTemplate, @Value("${fraud.check.url}") String fraudCheckUrl) {
        this.restTemplate = restTemplate;
        this.fraudCheckUrl = fraudCheckUrl;
    }

    public RestFraudCheckResponse doFraudCheck(double amount) {
        // Create a request parameter map
        String url = fraudCheckUrl + "?amount=" + amount;

        // Make the POST request
        return restTemplate.postForObject(url, null, RestFraudCheckResponse.class);
    }


}
