package com.photoapp.api.gateway.PhotoAppZuulApiGateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class PhotoAppZuulApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhotoAppZuulApiGatewayApplication.class, args);
	}

}
