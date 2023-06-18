package com.getgifted.rssparser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class RssParserApplication {

	public static void main(String[] args) {
		SpringApplication.run(RssParserApplication.class, args);
	}

}
