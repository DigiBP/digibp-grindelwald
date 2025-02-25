package ch.fhnw.digibp;

import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableProcessApplication("digibp-gindelwald")
public class ProcessApplication {

	public static void main(String... args) {
		SpringApplication.run(ProcessApplication.class, args);
	}

}