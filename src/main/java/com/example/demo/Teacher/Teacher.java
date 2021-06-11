package com.example.demo.Teacher;

import com.example.demo.Course.Course;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "teacher")
    private Set<Course> courses = new HashSet<>();

    public Teacher() {
    }

    public Teacher(String name) {
        this.name = name;
    }

    public Teacher(String name, Set<Course> courses) {
        this.name = name;
        this.courses = courses;
    }

    public Teacher(Long id, String name, Set<Course> courses) {
        this.id = id;
        this.name = name;
        this.courses = courses;
    }

    public Long getId() {
        return id;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
