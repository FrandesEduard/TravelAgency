package org.fasttrack;

import org.fasttrack.model.Offer;
import org.fasttrack.repository.OfferReader;
import org.fasttrack.repository.OfferRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Main {
    @Value("${file.location}")
    private String fileLocation;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    CommandLineRunner atStartup(OfferRepository repository) {
        return args -> {
            List<Offer> offersFromFile = OfferReader.getAllOffers(fileLocation);
            repository.saveAll(offersFromFile);
        };
    }
}
