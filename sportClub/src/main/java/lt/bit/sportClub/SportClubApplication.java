package lt.bit.sportClub;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lt.bit.sportClub.services.StorageService;

@SpringBootApplication
public class SportClubApplication {

	public static void main(String[] args) {
		SpringApplication.run(SportClubApplication.class, args);
	}
	@Bean
	CommandLineRunner init(StorageService storageService) {
		return (args) -> {
				storageService.init();
			};
	}

}
