package com.siemens.configserverdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigserverdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigserverdemoApplication.class, args);
	}

}
