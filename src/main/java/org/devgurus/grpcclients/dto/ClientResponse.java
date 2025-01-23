package org.devgurus.grpcclients.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientResponse {
    private String response;
    private String route;
    private boolean fraudTransaction;
    private long pastTransactionCountGenerated;
    private String message;
}
