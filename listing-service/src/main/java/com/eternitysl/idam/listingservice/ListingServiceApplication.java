package com.eternitysl.idam.listingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@EnableEurekaClient
@RefreshScope
public class ListingServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(ListingServiceApplication.class, args);
	}

}
