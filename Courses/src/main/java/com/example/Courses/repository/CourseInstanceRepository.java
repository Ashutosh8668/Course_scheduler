package com.example.Courses.repository;

import com.example.Courses.entity.CourseInstance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseInstanceRepository extends JpaRepository<CourseInstance, Long> {
    List<CourseInstance> findByYearAndSemester(int year, int semester);
    List<CourseInstance> findByCourseId(Long courseId);
}
