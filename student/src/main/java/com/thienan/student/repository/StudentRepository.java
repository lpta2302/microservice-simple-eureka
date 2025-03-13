package com.thienan.student.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.thienan.student.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findAllBySchoolId(Long schoolId);
}
