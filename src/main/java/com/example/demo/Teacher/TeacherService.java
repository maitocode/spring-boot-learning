package com.example.demo.Teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TeacherService {

    TeacherRepository teacherRepository;

    @Autowired
    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public List<Teacher> getTeacher() {
        return teacherRepository.findAll();
    }

    public void addNewTeacher(Teacher teacher) {
        Optional<Teacher> teacherOptional = teacherRepository.findByName(teacher.getName());

        if (teacherOptional.isPresent()) {
            throw new IllegalStateException("Cant add teacher, Teacher has exist!!!");
        }
        teacherRepository.save(teacher);
    }

    @Transactional
    public void updateTeacher(Long teacherId, String name) {
        Teacher teacher = teacherRepository.findById(teacherId)
                .orElseThrow(()-> new IllegalStateException("Doesn't exist Teacher!!!"));

        if (name != null && name.length() > 0 && !Objects.equals(teacher.getName(), name)) {
            teacher.setName(name);
        }
    }

    public void deleteTeacher(Long teacherId) {
        boolean exist = teacherRepository.existsById(teacherId);
        if (exist) {
            teacherRepository.deleteById(teacherId);
        }
        else {
            throw new IllegalStateException("cant delete teacher, id is not legal!!!");
        }
    }
}
