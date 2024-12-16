package org.devgurus.grpcclients.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class RestGreetingResponse {
    private String message;
}
