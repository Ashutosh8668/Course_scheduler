package com.example.Courses.controller;

import com.example.Courses.entity.Assignment;
import com.example.Courses.entity.Course;
import com.example.Courses.entity.CourseInstance;
import com.example.Courses.entity.Faculty;
import com.example.Courses.service.AssignmentService;
import com.example.Courses.service.CourseInstanceService;
import com.example.Courses.service.CourseService;
import com.example.Courses.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private AssignmentService assignmentService;

    @Autowired
    private FacultyService facultyService;


    @Autowired
    private CourseInstanceService courseInstanceService;

    @GetMapping("/assignments/{id}")
    public String viewAssignments(@PathVariable Long id, Model model) {
        Course course = courseService.getCourseById(id).orElse(null);
        List<CourseInstance> courseInstances = courseInstanceService.getCourseInstancesByCourseId(id);
        model.addAttribute("course", course);
        model.addAttribute("courseInstances", courseInstances);
        return "course_assignments";
    }
    @GetMapping("/{id}")
    public String viewCourse(@PathVariable Long id, Model model) {
        Course course = courseService.getCourseById(id).orElse(null);
        model.addAttribute("course", course);
        Optional<Assignment> assignment = assignmentService.getAssignmentById(id);
        model.addAttribute("assignment", assignment.orElse(null));
        return "course_details";
    }

    @GetMapping("/")
    public String listCourses(Model model) {
        List<Course> courses = courseService.getAllCourses();
        model.addAttribute("courses", courses);
        return "home";  // Thymeleaf template for listing courses
    }

    @GetMapping("/add")
    public String showAddCourseForm(Model model) {
        model.addAttribute("course", new Course());
        return "add_course";  // Thymeleaf template for adding a course
    }

    @PostMapping("/add")
    public String addCourse(@ModelAttribute Course course) {
        courseService.createCourse(course);
        return "redirect:/courses/";  // Redirect to the list of courses
    }

    @GetMapping("/edit/{id}")
    public String editCourse(@PathVariable Long id, Model model) {
        Course course = courseService.getCourseById(id).orElse(null);
        model.addAttribute("course", course);
        return "edit-course";
    }

    @PostMapping("/edit/{id}")
    public String updateCourse(@PathVariable Long id, @ModelAttribute Course course) {
        course.setId(id);
        courseService.createCourse(course);
        return "redirect:/courses/";
    }

    @PostMapping("/delete/{id}")
    public String deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return "redirect:/courses/";
    }

    @GetMapping("/assign")
    public String showAssignCourseForm(Model model) {
        List<Course> courses = courseService.getAllCourses();
        List<Faculty> faculties = facultyService.getAllFaculties();
        model.addAttribute("courses", courses);
        model.addAttribute("faculties", faculties);
        model.addAttribute("assignment", new Assignment());
        return "assign_course";  // Thymeleaf template for assigning a course
    }



}
