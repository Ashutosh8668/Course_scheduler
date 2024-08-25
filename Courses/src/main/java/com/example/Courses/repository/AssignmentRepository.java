package com.example.Courses.repository;

import com.example.Courses.entity.Assignment;
import com.example.Courses.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssignmentRepository extends JpaRepository<Assignment, Long> {
    List<Assignment> findByFacultyId(Long facultyId);
    List<Assignment> findByCourse(Course course);
}
