package com.thienan.school.dto;

import java.util.List;
import com.thienan.school.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FullSchoolResponse {
    private Long id;
    private String name;
    private List<Student> students;
}
