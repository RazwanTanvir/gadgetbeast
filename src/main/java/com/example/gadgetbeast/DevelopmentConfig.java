package com.example.gadgetbeast;

import com.example.gadgetbeast.data.ISpecificationRepository;
import com.example.gadgetbeast.data.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;

@Profile("!prod")
@Configuration
public class DevelopmentConfig {

    @Bean
    public CommandLineRunner dataLoader(ISpecificationRepository repo,
                                        UserRepository userRepo, PasswordEncoder encoder) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                repo.deleteAll();
                userRepo.deleteAll();

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


                userRepo.save(new User("a1", encoder.encode("a1"), "John Doe",
                        "1800 S 3rd Street", "Waco", "TX", "76706", "2542140707"));
            }
        };
    }
}
