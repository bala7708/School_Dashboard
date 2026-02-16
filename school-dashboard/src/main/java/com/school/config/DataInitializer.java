package com.school.config;

import com.school.model.Student;
import com.school.model.Teacher;
import com.school.repository.StudentRepository;
import com.school.repository.TeacherRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

/**
 * Initialize database with mock data
 */
@Component
@Slf4j
public class DataInitializer implements CommandLineRunner {
    
    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;
    
    @Autowired
    public DataInitializer(StudentRepository studentRepository, TeacherRepository teacherRepository) {
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
    }
    
    @Override
    public void run(String... args) {
       // log.info("Initializing database with mock data...");
        
        // Create Students
        createStudents();
        
        // Create Teachers
        createTeachers();
        
		/*
		 * log.info("Database initialization completed!");
		 * log.info("Total Students: {}", studentRepository.count());
		 * log.info("Total Teachers: {}", teacherRepository.count());
		 */
    }
    
    private void createStudents() {
        List<Student> students = Arrays.asList(
            createStudent("Emma", "Johnson", "emma.johnson@school.com", "2010-03-15", 
                         "Female", "10", "A", "10A001", "123 Main St", "555-0101", 
                         "Robert Johnson", "555-0102", "Excellent student"),
            
            createStudent("Liam", "Smith", "liam.smith@school.com", "2010-07-22",
                         "Male", "10", "A", "10A002", "456 Oak Ave", "555-0103",
                         "Sarah Smith", "555-0104", "Good in sports"),
            
            createStudent("Olivia", "Brown", "olivia.brown@school.com", "2009-11-08",
                         "Female", "11", "B", "11B001", "789 Pine Rd", "555-0105",
                         "Michael Brown", "555-0106", "Active in extracurriculars"),
            
            createStudent("Noah", "Davis", "noah.davis@school.com", "2011-04-30",
                         "Male", "9", "A", "9A001", "321 Elm St", "555-0107",
                         "Jennifer Davis", "555-0108", "Needs improvement in math"),
            
            createStudent("Ava", "Wilson", "ava.wilson@school.com", "2010-09-14",
                         "Female", "10", "B", "10B001", "654 Maple Dr", "555-0109",
                         "David Wilson", "555-0110", "Very creative"),
            
            createStudent("Ethan", "Martinez", "ethan.martinez@school.com", "2009-12-25",
                         "Male", "11", "A", "11A001", "987 Cedar Ln", "555-0111",
                         "Maria Martinez", "555-0112", "Leadership qualities"),
            
            createStudent("Sophia", "Anderson", "sophia.anderson@school.com", "2011-02-18",
                         "Female", "9", "B", "9B001", "147 Birch Ct", "555-0113",
                         "James Anderson", "555-0114", "Good attendance"),
            
            createStudent("Mason", "Taylor", "mason.taylor@school.com", "2010-06-05",
                         "Male", "10", "C", "10C001", "258 Walnut Way", "555-0115",
                         "Emily Taylor", "555-0116", "Improving steadily"),
            
            createStudent("Isabella", "Thomas", "isabella.thomas@school.com", "2009-08-12",
                         "Female", "11", "C", "11C001", "369 Spruce St", "555-0117",
                         "William Thomas", "555-0118", "Excellent in science"),
            
            createStudent("Lucas", "Lee", "lucas.lee@school.com", "2011-05-20",
                         "Male", "9", "A", "9A002", "741 Ash Blvd", "555-0119",
                         "Lisa Lee", "555-0120", "Very punctual"),
            
            createStudent("Mia", "White", "mia.white@school.com", "2010-10-03",
                         "Female", "10", "A", "10A003", "852 Poplar Rd", "555-0121",
                         "Kevin White", "555-0122", "Great team player"),
            
            createStudent("Aiden", "Harris", "aiden.harris@school.com", "2009-01-28",
                         "Male", "11", "B", "11B002", "963 Willow Ave", "555-0123",
                         "Michelle Harris", "555-0124", "Strong in mathematics")
        );
        
        studentRepository.saveAll(students);
    }
    
    private Student createStudent(String firstName, String lastName, String email,
                                 String dob, String gender, String grade, String section,
                                 String rollNumber, String address, String phone,
                                 String parentName, String parentPhone, String remarks) {
        Student student = new Student();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setEmail(email);
        student.setDateOfBirth(LocalDate.parse(dob));
        student.setGender(gender);
        student.setGrade(grade);
        student.setClassSection(section);
        student.setRollNumber(rollNumber);
        student.setAddress(address);
        student.setPhoneNumber(phone);
        student.setParentName(parentName);
        student.setParentPhone(parentPhone);
        student.setRemarks(remarks);
        student.setStatus(Student.Status.ACTIVE);
        student.setEnrollmentDate(LocalDate.now().minusYears(1));
        return student;
    }
    
    private void createTeachers() {
        List<Teacher> teachers = Arrays.asList(
            createTeacher("John", "Doe", "john.doe@school.com", "1985-04-15",
                         "Male", "Mathematics", "M.Sc in Mathematics", "T001",
                         "111 Teacher St", "555-1001", "2015-06-01", 8, 55000.0,
                         "Algebra and Calculus", "Department Head"),
            
            createTeacher("Mary", "Johnson", "mary.johnson@school.com", "1988-09-20",
                         "Female", "English", "M.A in English Literature", "T002",
                         "222 Faculty Ave", "555-1002", "2016-08-15", 7, 52000.0,
                         "British Literature", ""),
            
            createTeacher("Robert", "Williams", "robert.williams@school.com", "1982-12-10",
                         "Male", "Science", "M.Sc in Physics", "T003",
                         "333 Education Rd", "555-1003", "2012-04-01", 11, 58000.0,
                         "Physics and Chemistry", "Lab Coordinator"),
            
            createTeacher("Jennifer", "Brown", "jennifer.brown@school.com", "1990-03-25",
                         "Female", "History", "M.A in History", "T004",
                         "444 Campus Dr", "555-1004", "2017-09-01", 6, 50000.0,
                         "World History", ""),
            
            createTeacher("Michael", "Jones", "michael.jones@school.com", "1986-07-08",
                         "Male", "Physical Education", "B.P.Ed", "T005",
                         "555 Sports Ln", "555-1005", "2014-01-15", 9, 48000.0,
                         "Athletics and Sports", "Sports Coordinator"),
            
            createTeacher("Sarah", "Davis", "sarah.davis@school.com", "1992-11-30",
                         "Female", "Computer Science", "M.Tech in CS", "T006",
                         "666 Tech Blvd", "555-1006", "2018-07-01", 5, 56000.0,
                         "Programming and Web Development", ""),
            
            createTeacher("David", "Miller", "david.miller@school.com", "1984-05-18",
                         "Male", "Chemistry", "M.Sc in Chemistry", "T007",
                         "777 Science St", "555-1007", "2013-03-01", 10, 57000.0,
                         "Organic Chemistry", ""),
            
            createTeacher("Emily", "Wilson", "emily.wilson@school.com", "1989-08-22",
                         "Female", "Biology", "M.Sc in Biology", "T008",
                         "888 Nature Way", "555-1008", "2016-05-15", 7, 53000.0,
                         "Genetics and Botany", "")
        );
        
        teacherRepository.saveAll(teachers);
    }
    
    private Teacher createTeacher(String firstName, String lastName, String email,
                                 String dob, String gender, String subject, String qualification,
                                 String employeeId, String address, String phone, String joiningDate,
                                 int experience, double salary, String specialization, String remarks) {
        Teacher teacher = new Teacher();
        teacher.setFirstName(firstName);
        teacher.setLastName(lastName);
        teacher.setEmail(email);
        teacher.setDateOfBirth(LocalDate.parse(dob));
        teacher.setGender(gender);
        teacher.setSubject(subject);
        teacher.setQualification(qualification);
        teacher.setEmployeeId(employeeId);
        teacher.setAddress(address);
        teacher.setPhoneNumber(phone);
        teacher.setJoiningDate(LocalDate.parse(joiningDate));
        teacher.setExperienceYears(experience);
        teacher.setSalary(salary);
        teacher.setSpecialization(specialization);
        teacher.setRemarks(remarks);
        teacher.setStatus(Teacher.Status.ACTIVE);
        return teacher;
    }
}
