package com.example.Courses.controller;

import com.example.Courses.entity.CourseInstance;
import com.example.Courses.service.CourseInstanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instances")
public class CourseInstanceController {

    @Autowired
    private CourseInstanceService courseInstanceService;

    @PostMapping
    public ResponseEntity<CourseInstance> createCourseInstance(@RequestBody CourseInstance instance) {
        CourseInstance createdInstance = courseInstanceService.createCourseInstance(instance);
        return ResponseEntity.ok(createdInstance);
    }

    @GetMapping("/{year}/{semester}")
    public ResponseEntity<List<CourseInstance>> getCourseInstances(@PathVariable int year, @PathVariable int semester) {
        List<CourseInstance> instances = courseInstanceService.getCourseInstances(year, semester);
        return ResponseEntity.ok(instances);
    }

    @GetMapping("/{year}/{semester}/{id}")
    public ResponseEntity<CourseInstance> getCourseInstanceById(@PathVariable int year, @PathVariable int semester, @PathVariable Long id) {
        return courseInstanceService.getCourseInstanceById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{year}/{semester}/{id}")
    public ResponseEntity<Void> deleteCourseInstance(@PathVariable int year, @PathVariable int semester, @PathVariable Long id) {
        courseInstanceService.deleteCourseInstance(id);
        return ResponseEntity.noContent().build();
    }

}
