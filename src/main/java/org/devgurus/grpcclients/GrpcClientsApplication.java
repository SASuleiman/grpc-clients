package org.devgurus.grpcclients;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class GrpcClientsApplication {

	public static void main(String[] args) {
		SpringApplication.run(GrpcClientsApplication.class, args);
	}

}
