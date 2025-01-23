package org.devgurus.grpcclients.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class RestFraudCheckResponse {
    private boolean fraudTransaction;
    private int pastTransactionCountGenerated;
    private String message;
}
