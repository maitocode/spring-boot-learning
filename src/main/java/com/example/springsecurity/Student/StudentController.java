package com.example.springsecurity.Student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {

    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(1, "quyet"),
            new Student(2, "van"),
            new Student(3, "anna")
    );

    @GetMapping(path = "/{studentId}")
    public Student getStudent(@PathVariable("studentId") Integer studentId) {
        return STUDENTS.stream().filter(student -> studentId.equals(student.getId()))
                .findFirst()
                .orElseThrow(
                        () -> new IllegalStateException("studentId is invalid!!!")
                );
    }
}
