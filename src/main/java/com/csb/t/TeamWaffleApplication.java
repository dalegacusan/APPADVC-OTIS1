package com.csb.t;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication()
public class TeamWaffleApplication {

	public static void main(String[] args) {
		SpringApplication.run(TeamWaffleApplication.class, args);
	}

}
