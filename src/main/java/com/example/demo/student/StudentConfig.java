package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return arg -> {
            Student quyet = new Student(
                    "quyet",
                    "code.maito@gmail.com",
                    LocalDate.of(2000, Month.JANUARY, 5)
            );

            Student alex = new Student(
                    "alex",
                    "alex.maito@gmail.com",
                    LocalDate.of(2007, Month.JANUARY, 5)
            );

            repository.saveAll(
                    List.of(quyet, alex)
            );
        };
    }
}
