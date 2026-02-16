package com.school.controller;

import com.school.model.Teacher;
import com.school.service.TeacherService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Controller for Teacher operations
 */
@Controller
@RequestMapping("/teachers")
public class TeacherController {
    
    private final TeacherService teacherService;
    
    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }
    
    @GetMapping
    public String listTeachers(@RequestParam(required = false) String search, Model model) {
        if (search != null && !search.isEmpty()) {
            model.addAttribute("teachers", teacherService.searchTeachers(search));
            model.addAttribute("search", search);
        } else {
            model.addAttribute("teachers", teacherService.getAllTeachers());
        }
        return "teachers/list";
    }
    
    @GetMapping("/{id}")
    public String viewTeacher(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        return teacherService.getTeacherById(id)
                .map(teacher -> {
                    model.addAttribute("teacher", teacher);
                    return "teachers/view";
                })
                .orElseGet(() -> {
                    redirectAttributes.addFlashAttribute("error", "Teacher not found");
                    return "redirect:/teachers";
                });
    }
    
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("teacher", new Teacher());
        return "teachers/form";
    }
    
    @PostMapping
    public String createTeacher(@Valid @ModelAttribute Teacher teacher,
                               BindingResult result,
                               RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "teachers/form";
        }
        
        if (teacherService.existsByEmail(teacher.getEmail())) {
            result.rejectValue("email", "error.teacher", "Email already exists");
            return "teachers/form";
        }
        
        if (teacherService.existsByEmployeeId(teacher.getEmployeeId())) {
            result.rejectValue("employeeId", "error.teacher", "Employee ID already exists");
            return "teachers/form";
        }
        
        teacherService.saveTeacher(teacher);
        redirectAttributes.addFlashAttribute("success", "Teacher created successfully");
        return "redirect:/teachers";
    }
    
    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        return teacherService.getTeacherById(id)
                .map(teacher -> {
                    model.addAttribute("teacher", teacher);
                    return "teachers/form";
                })
                .orElseGet(() -> {
                    redirectAttributes.addFlashAttribute("error", "Teacher not found");
                    return "redirect:/teachers";
                });
    }
    
    @PostMapping("/{id}")
    public String updateTeacher(@PathVariable Long id,
                               @Valid @ModelAttribute Teacher teacher,
                               BindingResult result,
                               RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "teachers/form";
        }
        
        teacher.setId(id);
        teacherService.saveTeacher(teacher);
        redirectAttributes.addFlashAttribute("success", "Teacher updated successfully");
        return "redirect:/teachers/" + id;
    }
    
    @PostMapping("/{id}/delete")
    public String deleteTeacher(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        teacherService.deleteTeacher(id);
        redirectAttributes.addFlashAttribute("success", "Teacher deleted successfully");
        return "redirect:/teachers";
    }
}
