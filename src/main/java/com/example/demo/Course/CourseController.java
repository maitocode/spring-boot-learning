package com.example.demo.Course;

import com.example.demo.Teacher.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    private final CourseService courseService;
    private final TeacherService teacherService;

    @Autowired
    public CourseController(CourseService courseService, TeacherService teacherService) {
        this.courseService = courseService;
        this.teacherService = teacherService;
    }

    @GetMapping
    public List<Course> getCourses() {
        return courseService.getAllCourses();
    }

    @PostMapping
    void createCourse(@RequestBody Course course) {
        courseService.createNewCourse(course);
    }

    @PutMapping(path = "/{courseId}/teacher/{teacherId}")
    void updateCourseTeacher(
            @PathVariable("courseId") Long courseId,
            @PathVariable("teacherId") Long teacherId
    ) {
        courseService.updateTeacher(courseId, teacherId);
    }

    @PutMapping(path = "/{courseId}/student/{studentId}")
    void addStudent(
            @PathVariable("courseId") Long courseId,
            @PathVariable("studentId") Long studentId
    ){
        courseService.addStudent(courseId, studentId);
    }

    @PutMapping(path = "/{courseId}")
    void updateNameCourse(
            @PathVariable("courseId") Long courseId,
            @RequestParam(required = false) String name
    ) {
        courseService.updateName(courseId, name);
    }

    @DeleteMapping(path = "/{courseId}")
    void deleteCourse(@PathVariable("courseId") Long courseId) {
        courseService.deleteCourse(courseId);
    }
}
