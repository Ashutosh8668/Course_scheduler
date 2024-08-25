package com.example.Courses.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "course_instance")
public class CourseInstance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "year", nullable = false)
    private int year;

    @Column(name = "semester", nullable = false)
    private int semester;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @ManyToOne
    @JoinColumn(name = "faculty_id")
    private Faculty faculty; // The faculty assigned to this course instance

    // Default constructor
    public CourseInstance() {}

    // Parameterized constructor
    public CourseInstance(int year, int semester, Course course, Faculty faculty) {
        this.year = year;
        this.semester = semester;
        this.course = course;
        this.faculty = faculty;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    @Override
    public String toString() {
        return "CourseInstance{" +
                "id=" + id +
                ", year=" + year +
                ", semester=" + semester +
                ", course=" + course +
                ", faculty=" + faculty +
                '}';
    }
}
