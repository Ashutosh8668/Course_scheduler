package com.example.Courses.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "Course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "course_code", nullable = false, unique = true)
    private String courseCode;

    @Column(name = "description")
    private String description;

    // Default constructor
    public Course() {}

    // Parameterized constructor
    public Course(String title, String courseCode, String description) {
        this.title = title;
        this.courseCode = courseCode;
        this.description = description;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", courseCode='" + courseCode + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
