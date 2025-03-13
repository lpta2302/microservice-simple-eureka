package com.thienan.school.controller;

import org.springframework.web.bind.annotation.RestController;

import com.thienan.school.entity.School;
import com.thienan.school.service.SchoolService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.thienan.school.dto.FullSchoolResponse;




@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/schools")
public class SchoolController {
    private final SchoolService schoolService;

    @GetMapping
    public ResponseEntity<List<School>> getAllSchools() {
        return ResponseEntity.ok(schoolService.getAllSchools());
    }

    @GetMapping("/{schoolId}/students")
    public ResponseEntity<FullSchoolResponse> getSchoolWithStudents(
        @PathVariable("schoolId") Long schoolId
    ) {
        return ResponseEntity.ok(schoolService.getSchoolWithStudents(schoolId));
    }
    

    @PostMapping
    public ResponseEntity<School> createSchool(
        @RequestBody School school
    ) {
        return ResponseEntity.ok(schoolService.createSchool(school));
    }
    
    
}
