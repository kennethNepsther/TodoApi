package it.nepsther.todo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import it.nepsther.todo.service.DatabaseService;

@Configuration
@Profile("test")
public class TestConfig {

	@Autowired
	private DatabaseService dataBaseService;

	@Bean
	public boolean instanceOfDb() {
		this.dataBaseService.instaceDateBase();
		return true;
	}
}
