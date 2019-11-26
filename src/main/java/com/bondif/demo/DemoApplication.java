package com.bondif.demo;

import com.bondif.demo.dao.AnalyseRepository;
import com.bondif.demo.dao.ClientRepository;
import com.bondif.demo.entities.Analyse;
import com.bondif.demo.entities.Client;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.Date;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    BCryptPasswordEncoder getBCPE() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner start(ClientRepository clientRepository, AnalyseRepository analyseRepository) {
        return args -> {
            clientRepository.deleteAll();
            analyseRepository.deleteAll();

            Client c1 = new Client("c1", "BOUKHLIF", "Mohamed", "https://icon-library.net/images/avatar-icon-images/avatar-icon-images-4.jpg", new ArrayList<>());
            Client c2 = new Client("c2", "Doe", "John", "https://icon-library.net/images/avatar-icon-images/avatar-icon-images-4.jpg", new ArrayList<>());

            Analyse a1 = new Analyse("1", "A1", new Date(), 4000.0, "c b1", true, c1);
            Analyse a2 = new Analyse("2", "A2", new Date(), 7810.0, "c pas b1", false, c2);
            Analyse a3 = new Analyse("3", "A3", new Date(), 5450.0, "c b1", false, c1);

            c1.getAnalyses().add(a1);
            c1.getAnalyses().add(a3);
            c2.getAnalyses().add(a2);

            clientRepository.save(c1);
            clientRepository.save(c2);

            analyseRepository.save(a1);
            analyseRepository.save(a2);
            analyseRepository.save(a3);
        };
    }
}
