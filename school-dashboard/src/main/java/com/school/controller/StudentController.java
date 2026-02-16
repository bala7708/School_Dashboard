package com.school.controller;

import com.school.model.Student;
import com.school.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Controller for Student operations
 */
@Controller
@RequestMapping("/students")
public class StudentController {
    
    private final StudentService studentService;
    
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    
    @GetMapping
    public String listStudents(@RequestParam(required = false) String search, Model model) {
        if (search != null && !search.isEmpty()) {
            model.addAttribute("students", studentService.searchStudents(search));
            model.addAttribute("search", search);
        } else {
            model.addAttribute("students", studentService.getAllStudents());
        }
        return "students/list";
    }
    
    @GetMapping("/{id}")
    public String viewStudent(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        return studentService.getStudentById(id)
                .map(student -> {
                    model.addAttribute("student", student);
                    return "students/view";
                })
                .orElseGet(() -> {
                    redirectAttributes.addFlashAttribute("error", "Student not found");
                    return "redirect:/students";
                });
    }
    
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("student", new Student());
        return "students/form";
    }
    
    @PostMapping
    public String createStudent(@Valid @ModelAttribute Student student, 
                               BindingResult result, 
                               RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "students/form";
        }
        
        if (studentService.existsByEmail(student.getEmail())) {
            result.rejectValue("email", "error.student", "Email already exists");
            return "students/form";
        }
        
        if (studentService.existsByRollNumber(student.getRollNumber())) {
            result.rejectValue("rollNumber", "error.student", "Roll number already exists");
            return "students/form";
        }
        
        studentService.saveStudent(student);
        redirectAttributes.addFlashAttribute("success", "Student created successfully");
        return "redirect:/students";
    }
    
    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        return studentService.getStudentById(id)
                .map(student -> {
                    model.addAttribute("student", student);
                    return "students/form";
                })
                .orElseGet(() -> {
                    redirectAttributes.addFlashAttribute("error", "Student not found");
                    return "redirect:/students";
                });
    }
    
    @PostMapping("/{id}")
    public String updateStudent(@PathVariable Long id,
                               @Valid @ModelAttribute Student student,
                               BindingResult result,
                               RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "students/form";
        }
        
        student.setId(id);
        studentService.saveStudent(student);
        redirectAttributes.addFlashAttribute("success", "Student updated successfully");
        return "redirect:/students/" + id;
    }
    
    @PostMapping("/{id}/delete")
    public String deleteStudent(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        studentService.deleteStudent(id);
        redirectAttributes.addFlashAttribute("success", "Student deleted successfully");
        return "redirect:/students";
    }
}
