package com.art0123.LearnFromHome;

import com.art0123.LearnFromHome.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class LearnFromHomeApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnFromHomeApplication.class, args);
	}

}
