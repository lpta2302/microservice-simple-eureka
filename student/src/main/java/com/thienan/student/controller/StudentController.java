package com.thienan.student.controller;

import org.springframework.web.bind.annotation.RestController;
import com.thienan.student.entity.Student;
import com.thienan.student.service.StudentService;
import lombok.RequiredArgsConstructor;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/students")
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(
            studentService.getAllStudents()
        );
    }

    @GetMapping("/school/{schoolId}")
    public ResponseEntity<List<Student>> findAllStudentBySchoolId(
        @PathVariable("schoolId") Long schoolId
    ) {
        return ResponseEntity.ok(
            studentService.findAllStudentBySchoolId(schoolId)
        );
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(
        @RequestBody Student student
    ) {
        return ResponseEntity.ok(studentService.createStudent(student));
    }
    
    
}
