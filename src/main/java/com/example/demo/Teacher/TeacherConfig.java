package com.example.demo.Teacher;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class TeacherConfig {

    @Bean
    CommandLineRunner commandLineRunnerTeacher(TeacherRepository teacherRepository) {
        return arg -> {
            Teacher tuanAnh = new Teacher(
                    "Tuan Anh"
            );

            Teacher dongVo = new Teacher(
                    "Dong Vo"
            );

            teacherRepository.saveAll(List.of(tuanAnh, dongVo));
        };
    }
}
