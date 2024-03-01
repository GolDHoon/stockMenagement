package com.gdh.assetMenagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AssetMenagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssetMenagementApplication.class, args);
	}

}
