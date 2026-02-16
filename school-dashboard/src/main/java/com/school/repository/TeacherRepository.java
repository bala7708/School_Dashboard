package com.school.repository;

import com.school.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository for Teacher entity
 */
@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    
    Optional<Teacher> findByEmail(String email);
    
    Optional<Teacher> findByEmployeeId(String employeeId);
    
    List<Teacher> findBySubject(String subject);
    
    List<Teacher> findByStatus(Teacher.Status status);
    
    @Query("SELECT t FROM Teacher t WHERE " +
           "LOWER(t.firstName) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
           "LOWER(t.lastName) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
           "LOWER(t.email) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
           "LOWER(t.employeeId) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
           "LOWER(t.subject) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Teacher> searchTeachers(String keyword);
    
    long countByStatus(Teacher.Status status);
    
    long countBySubject(String subject);
}
