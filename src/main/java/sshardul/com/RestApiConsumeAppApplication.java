package sshardul.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("sshardul.com.*")
public class RestApiConsumeAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApiConsumeAppApplication.class, args);
	}

}
