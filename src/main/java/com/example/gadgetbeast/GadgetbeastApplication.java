package com.example.gadgetbeast;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GadgetbeastApplication {

	public static void main(String[] args) {
		SpringApplication.run(GadgetbeastApplication.class, args);
	}

	@Bean
	public CommandLineRunner dataLoader(ISpecificationRepository repo) {
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				repo.save(new Specification("1", "ASUS", "16 GB", Specification.Type.RAM));
				repo.save(new Specification("2", "HP", "16 GB", Specification.Type.RAM));
				repo.save(new Specification("3", "ASUS", "8 GB", Specification.Type.RAM));
				repo.save(new Specification("4", "DELL", "1 TB", Specification.Type.HDD));
				repo.save(new Specification("5", "SAMSUNG", "512 GB", Specification.Type.HDD));
				repo.save(new Specification("6", "ASUS", "2 TB", Specification.Type.HDD));
				repo.save(new Specification("7", "DELL", "256 GB", Specification.Type.HDD));
				repo.save(new Specification("8", "HP", "13.6 inch", Specification.Type.DISPLAY));
				repo.save(new Specification("9", "HP", "14.6 inch", Specification.Type.DISPLAY));
				repo.save(new Specification("10", "DELL", "1.6 inch", Specification.Type.DISPLAY));
				repo.save(new Specification("11", "SAMSUNG", "core i7", Specification.Type.PROCESSOR));
				repo.save(new Specification("12", "INTEL", "core i5", Specification.Type.PROCESSOR));
				repo.save(new Specification("13", "AMD", "core i3", Specification.Type.PROCESSOR));
			}
		};

	}
}
