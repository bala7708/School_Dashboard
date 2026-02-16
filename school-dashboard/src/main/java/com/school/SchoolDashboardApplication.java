package com.school;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * School Dashboard Application
 * Main entry point for the Spring Boot application
 */
@SpringBootApplication
public class SchoolDashboardApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(SchoolDashboardApplication.class, args);
        System.out.println("\n");
        System.out.println("========================================");
        System.out.println("   SCHOOL DASHBOARD APPLICATION        ");
        System.out.println("========================================");
        System.out.println("Access the application at:");
        System.out.println("http://localhost:8080");
        System.out.println("\nH2 Console (Database):");
        System.out.println("http://localhost:8080/h2-console");
        System.out.println("========================================\n");
    }
}
