package it.unisalento.sonoffbackend;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SonoffBackEndApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(SonoffBackEndApplication.class);
        app.setDefaultProperties(Collections
          .singletonMap("server.port", "8082"));
        app.run(args);
	}

}
