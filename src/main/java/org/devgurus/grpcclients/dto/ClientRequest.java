package org.devgurus.grpcclients.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import org.springframework.util.RouteMatcher;

@Data
@Builder
public class ClientRequest {

    @NotNull(message = "Message must not be null")
    private String name;

    @NotNull(message = "Route must not be null")
    private String route;

    public enum RouteEnum {
        REST,
        GRPC,
        SOAP,
        GRAPHQL
    }

}
