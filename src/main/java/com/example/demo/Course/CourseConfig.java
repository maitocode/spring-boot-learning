package com.example.demo.Course;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CourseConfig {
    @Bean
    CommandLineRunner commandLineRunnerCourse(CourseRepository courseRepository) {
        return arg -> {
            Course math = new Course(
                    "Math"
            );

            Course geography = new Course(
                    "Geography"
            );

            Course physic = new Course(
                    "Physic"
            );

            courseRepository.saveAll(
                    List.of(math, geography, physic)
            );
        };
    }
}
