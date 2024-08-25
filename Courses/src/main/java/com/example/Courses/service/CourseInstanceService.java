package com.example.Courses.service;


import com.example.Courses.entity.CourseInstance;
import com.example.Courses.repository.CourseInstanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseInstanceService {

    @Autowired
    private CourseInstanceRepository courseInstanceRepository;

    public CourseInstance createCourseInstance(CourseInstance instance) {
        return courseInstanceRepository.save(instance);
    }

    public List<CourseInstance> getCourseInstances(int year, int semester) {
        return courseInstanceRepository.findByYearAndSemester(year, semester);
    }

    public Optional<CourseInstance> getCourseInstanceById(Long id) {
        return courseInstanceRepository.findById(id);
    }

    public void deleteCourseInstance(Long id) {
        courseInstanceRepository.deleteById(id);
    }

    public void saveCourseInstance(CourseInstance courseInstance) {
        courseInstanceRepository.save(courseInstance);
    }
    public List<CourseInstance> getCourseInstancesByCourseId(Long courseId) {
        return courseInstanceRepository.findByCourseId(courseId);
    }

}