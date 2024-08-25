package com.example.Courses.controller;

import com.example.Courses.entity.Faculty;
import com.example.Courses.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/faculties")
public class FacultyController {

    @Autowired
    private FacultyService facultyService;

    @GetMapping("/add")
    public String showAddFacultyForm(Model model) {
        model.addAttribute("faculty", new Faculty());  // Add a Faculty object to the model
        return "add_faculty";  // Thymeleaf template for adding a faculty
    }

    @GetMapping("/")
    public String listFaculties(Model model) {
        List<Faculty> faculties = facultyService.getAllFaculties();
        model.addAttribute("faculties", faculties);
        return "faculty_list";  // Thymeleaf template for listing faculties
    }

    @PostMapping("/add")
    public String addFaculty(@ModelAttribute Faculty faculty) {
        facultyService.createFaculty(faculty);
        return "redirect:/faculties/";  // Redirect to the list of faculties
    }

    @GetMapping("/{id}")
    public String viewFaculty(@PathVariable Long id, Model model) {
        Faculty faculty = facultyService.getFacultyById(id).orElse(null);
        model.addAttribute("faculty", faculty);
        return "faculty_details";  // Thymeleaf template for faculty details
    }

    @PostMapping("/delete/{id}")
    public String deleteFaculty(@PathVariable Long id) {
        facultyService.deleteFaculty(id);
        return "redirect:/faculties/";
    }
}
