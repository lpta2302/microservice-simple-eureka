package com.thienan.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.thienan.school.entity.School;

public interface SchoolRepository extends JpaRepository<School, Long>{
    
}
