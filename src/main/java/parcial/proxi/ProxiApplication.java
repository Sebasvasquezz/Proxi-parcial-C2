package parcial.proxi;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProxiApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(ProxiApplication.class);
        app.setDefaultProperties(Collections.singletonMap("server.port", 8081));
        app.run(args);
    }

}
