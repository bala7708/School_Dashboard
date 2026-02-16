package com.school.controller;

import com.school.service.StudentService;
import com.school.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller for dashboard and home page
 */
@Controller
public class DashboardController {
    
    private final StudentService studentService;
    private final TeacherService teacherService;
    
    @Autowired
    public DashboardController(StudentService studentService, TeacherService teacherService) {
        this.studentService = studentService;
        this.teacherService = teacherService;
    }
    
    @GetMapping("/")
    public String dashboard(Model model) {
        // Dashboard statistics
        long totalStudents = studentService.getActiveStudentCount();
        long totalTeachers = teacherService.getActiveTeacherCount();
        
        model.addAttribute("totalStudents", totalStudents);
        model.addAttribute("totalTeachers", totalTeachers);
        model.addAttribute("recentStudents", studentService.getAllStudents().stream().limit(5).toList());
        model.addAttribute("recentTeachers", teacherService.getAllTeachers().stream().limit(5).toList());
        
        return "dashboard";
    }
}
