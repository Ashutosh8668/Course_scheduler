package com.example.Courses.controller;

import com.example.Courses.entity.Assignment;
import com.example.Courses.entity.Course;
import com.example.Courses.entity.CourseInstance;
import com.example.Courses.entity.Faculty;
import com.example.Courses.service.CourseInstanceService;
import com.example.Courses.service.CourseService;
import com.example.Courses.service.FacultyService;
import com.example.Courses.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/assignments")
public class AssignmentController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private FacultyService facultyService;

    @Autowired
    private AssignmentService assignmentService;
    @Autowired
    private CourseInstanceService courseInstanceService;

    @GetMapping("/add")
    public String showAssignCourseForm(Model model) {
        List<Course> courses = courseService.getAllCourses();
        List<Faculty> faculties = facultyService.getAllFaculties();
        model.addAttribute("courses", courses);
        model.addAttribute("faculties", faculties);
        return "assign_course"; 
    }

    @PostMapping("/add")
    public String addAssignment(@RequestParam Long courseId,
                                @RequestParam Long facultyId,
                                @RequestParam int year,
                                @RequestParam int semester) {
        // Retrieve the course and faculty based on the provided IDs
        Course course = courseService.getCourseById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        Faculty faculty = facultyService.getFacultyById(facultyId)
                .orElseThrow(() -> new RuntimeException("Faculty not found"));
        CourseInstance courseInstance = new CourseInstance(year, semester, course, faculty);
        courseInstanceService.saveCourseInstance(courseInstance);
        return "redirect:/courses/";
    }

    @GetMapping("/details/{id}")
    public String viewAssignmentDetails(@PathVariable Long id, Model model) {
        Assignment assignment = assignmentService.getAssignmentById(id)
                .orElseThrow(() -> new RuntimeException("Assignment not found"));
        model.addAttribute("assignment", assignment);
        return "assignment_details";  // Thymeleaf template for assignment details
    }

    @GetMapping("/assign")
    public String showAssignPage(Model model) {
        List<Course> courses = courseService.getAllCourses();
        List<Faculty> faculties = facultyService.getAllFaculties();
        model.addAttribute("courses", courses);
        model.addAttribute("faculties", faculties);
        return "assign_course";  // Return the name of the Thymeleaf template
    }
}
