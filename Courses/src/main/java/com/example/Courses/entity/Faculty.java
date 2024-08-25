package com.example.Courses.entity;

import jakarta.persistence.*;
import java.util.Set;
@Entity
public class Faculty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String department;

    @OneToMany(mappedBy = "faculty")
    private Set<CourseInstance> courseInstances;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Set<CourseInstance> getCourseInstances() {
        return courseInstances;
    }

    public void setCourseInstances(Set<CourseInstance> courseInstances) {
        this.courseInstances = courseInstances;
    }
}
