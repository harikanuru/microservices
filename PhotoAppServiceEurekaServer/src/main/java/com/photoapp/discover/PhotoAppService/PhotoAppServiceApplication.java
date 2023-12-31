package com.photoapp.discover.PhotoAppService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class PhotoAppServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhotoAppServiceApplication.class, args);
	}

}
