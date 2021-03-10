package com.shadowhawk.aimsmockdispatcher;

import com.shadowhawk.aimsmockdispatcher.repository.TripRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class AimsmockdispatcherApplication {

	public static void main(String[] args) {
		SpringApplication.run(AimsmockdispatcherApplication.class, args);
	}

}
