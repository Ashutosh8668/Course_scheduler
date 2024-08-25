package com.example.Courses.service;

import com.example.Courses.entity.Assignment;
import com.example.Courses.entity.Course;
import com.example.Courses.repository.AssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssignmentService {

    @Autowired
    private AssignmentRepository assignmentRepository;

    // Save an assignment
    public Assignment saveAssignment(Assignment assignment) {
        return assignmentRepository.save(assignment);
    }

    // Get all assignments
    public List<Assignment> getAllAssignments() {
        return assignmentRepository.findAll();
    }

    // Get assignments by course
    public List<Assignment> getAssignmentsByCourse(Course course) {
        return assignmentRepository.findByCourse(course);
    }

    // Get assignment by ID
    public Optional<Assignment> getAssignmentById(Long id) {
        return assignmentRepository.findById(id);
    }

    // Delete an assignment by ID
    public void deleteAssignment(Long id) {
        assignmentRepository.deleteById(id);
    }

    // Get assignments by faculty ID
    public List<Assignment> getAssignmentsByFacultyId(Long facultyId) {
        return assignmentRepository.findByFacultyId(facultyId);
    }



}
