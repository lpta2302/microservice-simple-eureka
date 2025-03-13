package com.thienan.school.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import com.thienan.school.client.StudentClient;
import com.thienan.school.dto.FullSchoolResponse;
import com.thienan.school.entity.School;
import com.thienan.school.entity.Student;
import com.thienan.school.repository.SchoolRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@RequestMapping("/api/v1/schools")
public class SchoolService {
    private final SchoolRepository schoolRepository;
    private final StudentClient studentClient;

    public List<School> getAllSchools() {
        return schoolRepository.findAll();
    }

    public School createSchool(School school) {
        return schoolRepository.save(school);
    }
    
    public FullSchoolResponse getSchoolWithStudents(
        Long schoolId
    ){
        School foundedSchool = schoolRepository
            .findById(schoolId)
            .orElseThrow(()->
                new EntityNotFoundException("Not found shcool id: "+schoolId));

        List<Student> students = 
            studentClient.getAllStudentsOfSchool(schoolId);

        return FullSchoolResponse.builder()
            .name(foundedSchool.getName())
            .id(foundedSchool.getId())
            .students(students)
            .build();
    }
}
