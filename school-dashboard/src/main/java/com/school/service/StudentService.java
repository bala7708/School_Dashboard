package com.school.service;

import com.school.model.Student;
import com.school.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service for Student operations
 */
@Service
@Slf4j
public class StudentService {
    
    private final StudentRepository studentRepository;
    
    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
    
    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }
    
    public Optional<Student> getStudentByEmail(String email) {
        return studentRepository.findByEmail(email);
    }
    
    public List<Student> getStudentsByGrade(String grade) {
        return studentRepository.findByGrade(grade);
    }
    
    public List<Student> getStudentsByClass(String grade, String section) {
        return studentRepository.findByGradeAndClassSection(grade, section);
    }
    
    public List<Student> searchStudents(String keyword) {
        return studentRepository.searchStudents(keyword);
    }
    
    @Transactional
    public Student saveStudent(Student student) {
       // log.info("Saving student: {}", student.getFullName());
        return studentRepository.save(student);
    }
    
    @Transactional
    public void deleteStudent(Long id) {
       // log.info("Deleting student with ID: {}", id);
        studentRepository.deleteById(id);
    }
    
    public long getActiveStudentCount() {
        return studentRepository.countByStatus(Student.Status.ACTIVE);
    }
    
    public long getStudentCountByGrade(String grade) {
        return studentRepository.countByGrade(grade);
    }
    
    public boolean existsByEmail(String email) {
        return studentRepository.findByEmail(email).isPresent();
    }
    
    public boolean existsByRollNumber(String rollNumber) {
        return studentRepository.findByRollNumber(rollNumber).isPresent();
    }
}
