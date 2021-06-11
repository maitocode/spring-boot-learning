package com.example.demo.Course;

import com.example.demo.Teacher.Teacher;
import com.example.demo.Teacher.TeacherRepository;
import com.example.demo.student.Student;
import com.example.demo.student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CourseService {

    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;
    private final StudentRepository studentRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository, TeacherRepository teacherRepository, StudentRepository studentRepository) {
        this.courseRepository = courseRepository;
        this.teacherRepository = teacherRepository;
        this.studentRepository = studentRepository;
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public void createNewCourse(Course course) {
        Optional<Course> courseOption = courseRepository.findByName(course.getName());

        if (courseOption.isPresent()) {
            throw new IllegalStateException("Course is existed!!!");
        }

        courseRepository.save(course);
    }

    @Transactional
    public void updateTeacher(Long courseId, Long teacherId) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(()-> new IllegalStateException("the Course Id is Not legal!!"));

        Teacher teacherCourse = course.getTeacher();
        Teacher teacher = teacherRepository.findById(teacherId)
                .orElseThrow(()-> new IllegalStateException("Teacher id is not Legal!!!"));

        if (teacherCourse == null || teacherCourse.getName() != teacher.getName()) {
            course.setTeacher(teacher);
        }

    }

    @Transactional
    public void addStudent(Long courseId, Long studentId) {
        Course course = courseRepository.findById(courseId).orElseThrow(()-> new IllegalStateException("cant find id of "));
        Student student = studentRepository.findById(studentId).orElseThrow(()-> new IllegalStateException("can't find id of student"));

        Set<Student> set = course.getStudents();

        for (Student s : set) {
            if (s.getId() == studentId)
                throw new IllegalStateException("id student is Exist in Course!!!");
        }
        course.addStudent(student);
    }

    public void deleteCourse(Long courseId) {
        boolean exist = courseRepository.existsById(courseId);
        if (exist) {
            courseRepository.deleteById(courseId);
        }
        else {
            throw new IllegalStateException("can't delete, course id is not legal!!");
        }
    }

    @Transactional
    public void updateName(Long courseId, String name) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(()-> new IllegalStateException("id is not legal!!!"));
        course.setName(name);
    }
}
