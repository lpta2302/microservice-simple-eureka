package com.thienan.student.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.thienan.student.entity.Student;
import com.thienan.student.repository.StudentRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();    
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> findAllStudentBySchoolId(Long schoolId) {
        return studentRepository.findAllBySchoolId(schoolId);
    }
    
}
