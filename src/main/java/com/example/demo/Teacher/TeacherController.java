package com.example.demo.Teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping
    public List<Teacher> getTeacher() {
        return teacherService.getTeacher();
    }

    @PostMapping
    public void createTeacher(@RequestBody Teacher teacher) {
        teacherService.addNewTeacher(teacher);
    }

    @PutMapping(path = "/{teacherId}")
    public void updateTeacher(
            @PathVariable("teacherId") Long teacherId,
            @RequestParam(required = false) String name) {
        teacherService.updateTeacher(teacherId, name);
    }

    @DeleteMapping(path = "/{teacherId}")
    public void deleteTeacher(@PathVariable("teacherId") Long teacherId) {
        teacherService.deleteTeacher(teacherId);
    }

}
