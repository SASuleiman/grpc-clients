package org.devgurus.grpcclients.controller;

import com.google.api.Http;
import lombok.AllArgsConstructor;
import org.devgurus.grpcclients.dto.ClientRequest;
import org.devgurus.grpcclients.dto.ClientResponse;
import org.devgurus.grpcclients.service.RouterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ClientController {

    private final RouterService routerService;

    @PostMapping("/request")
    public ResponseEntity<ClientResponse> sendRequestToServer(@RequestBody ClientRequest request) {
        ClientResponse clientResponse = routerService.routeRequest(request);
        return new ResponseEntity<>(clientResponse, HttpStatus.OK);
    }
}