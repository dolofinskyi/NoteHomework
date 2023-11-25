package ua.test.project.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({
		"ua.test.project.note",
})
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}