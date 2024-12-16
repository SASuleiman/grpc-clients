package org.devgurus.grpcclients.service;

import lombok.AllArgsConstructor;
import org.devgurus.grpcclients.dto.ClientRequest;
import org.devgurus.grpcclients.dto.ClientResponse;
import org.devgurus.grpcclients.exceptions.BadRequestException;
import org.devgurus.grpcclients.util.ProjectUtils;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@AllArgsConstructor
public class RouterService {

    private final GrpcClientService grpcClientService;

    private final RestClientService restClientService;

    public ClientResponse routeRequest (ClientRequest request) {
        if(!ProjectUtils.isValidRoute(request.getRoute())) {
            throw new BadRequestException("Invalid route");
        }
        switch (request.getRoute()) {
            case "GRPC":
                return  grpcClientService.callClient(request);
            case "REST":
                return restClientService.callRestClient(request);
            case "SOAP", "GRAPHQL":
                throw new BadRequestException("Not Implemented");
            default: throw new BadRequestException("Unsupported route :" + request.getRoute());
        }
    }

}
