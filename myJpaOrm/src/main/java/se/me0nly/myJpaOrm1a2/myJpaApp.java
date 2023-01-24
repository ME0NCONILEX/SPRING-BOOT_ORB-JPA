package se.me0nly.myJpaOrm1a2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class myJpaApp {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(myJpaApp.class, args);
	}

}
