package org.devgurus.grpcclients.client;

import org.devgurus.grpcclients.dto.RestFraudCheckResponse;
import org.devgurus.grpcclients.dto.RestGreetingRequest;
import org.devgurus.grpcclients.dto.RestGreetingResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name = "greetingFeign", url = "${REST_CLIENT_BASEURL}")
public interface RestFeignClient {

    @PostMapping("/api/fraud/check")
    RestFraudCheckResponse doFraudCheck(@RequestParam double amount);

}
