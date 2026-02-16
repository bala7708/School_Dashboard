package com.school.service;

import com.school.model.Teacher;
import com.school.repository.TeacherRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service for Teacher operations
 */
@Service
@Slf4j
public class TeacherService {
    
    private final TeacherRepository teacherRepository;
    
    @Autowired
    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }
    
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }
    
    public Optional<Teacher> getTeacherById(Long id) {
        return teacherRepository.findById(id);
    }
    
    public Optional<Teacher> getTeacherByEmail(String email) {
        return teacherRepository.findByEmail(email);
    }
    
    public List<Teacher> getTeachersBySubject(String subject) {
        return teacherRepository.findBySubject(subject);
    }
    
    public List<Teacher> searchTeachers(String keyword) {
        return teacherRepository.searchTeachers(keyword);
    }
    
    @Transactional
    public Teacher saveTeacher(Teacher teacher) {
       // log.info("Saving teacher: {}", teacher.getFullName());
        return teacherRepository.save(teacher);
    }
    
    @Transactional
    public void deleteTeacher(Long id) {
        //log.info("Deleting teacher with ID: {}", id);
        teacherRepository.deleteById(id);
    }
    
    public long getActiveTeacherCount() {
        return teacherRepository.countByStatus(Teacher.Status.ACTIVE);
    }
    
    public long getTeacherCountBySubject(String subject) {
        return teacherRepository.countBySubject(subject);
    }
    
    public boolean existsByEmail(String email) {
        return teacherRepository.findByEmail(email).isPresent();
    }
    
    public boolean existsByEmployeeId(String employeeId) {
        return teacherRepository.findByEmployeeId(employeeId).isPresent();
    }
}
