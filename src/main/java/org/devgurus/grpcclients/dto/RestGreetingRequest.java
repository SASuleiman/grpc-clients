package org.devgurus.grpcclients.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RestGreetingRequest {
    private String name;
}
