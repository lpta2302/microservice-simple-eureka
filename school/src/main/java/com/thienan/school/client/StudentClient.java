package com.thienan.school.client;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.thienan.school.entity.Student;

@FeignClient(name = "student-service", url = "${application.config.student-url}")
public interface StudentClient {
    @GetMapping("/school/{schoolId}")
    public List<Student> getAllStudentsOfSchool(
        @PathVariable("schoolId") Long schoolId
    );
}
