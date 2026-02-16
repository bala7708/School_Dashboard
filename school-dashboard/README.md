# 🏫 School Dashboard - Management System

A comprehensive web-based school management system built with **Spring Boot** and **Thymeleaf**, featuring student and teacher information management with a modern, responsive UI.

## 📋 Table of Contents
- [Features](#-features)
- [Technologies](#-technologies)
- [Database Schema](#-database-schema)
- [Installation](#-installation)
- [Usage](#-usage)
- [API Endpoints](#-api-endpoints)
- [Screenshots](#-screenshots)

## ✨ Features

### Student Management
- ✅ Add, edit, view, and delete students
- ✅ Search students by name, email, or roll number
- ✅ Track student information: personal details, academic info, parent/guardian details
- ✅ Grade and section management
- ✅ Status tracking (Active, Inactive, Graduated, Transferred)
- ✅ Enrollment date tracking

### Teacher Management
- ✅ Add, edit, view, and delete teachers
- ✅ Search teachers by name, email, subject, or employee ID
- ✅ Track qualifications, experience, and specialization
- ✅ Salary management
- ✅ Status tracking (Active, On Leave, Resigned, Retired)
- ✅ Subject assignment

### Dashboard
- ✅ Real-time statistics (total students, total teachers)
- ✅ Recent students and teachers overview
- ✅ Quick access to all modules

### Technical Features
- ✅ RESTful API design
- ✅ Form validation
- ✅ Responsive UI (mobile-friendly)
- ✅ Mock data initialization
- ✅ H2 in-memory database
- ✅ JPA/Hibernate ORM
- ✅ Search functionality
- ✅ CRUD operations

## 🛠️ Technologies

- **Backend**: Spring Boot 3.2.0, Java 17
- **Frontend**: Thymeleaf, HTML5, CSS3
- **Database**: H2 (in-memory), JPA/Hibernate
- **Build Tool**: Maven
- **Validation**: Jakarta Bean Validation
- **Logging**: SLF4J with Logback

## 🗄️ Database Schema

### Students Table
```sql
CREATE TABLE students (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    date_of_birth DATE NOT NULL,
    gender VARCHAR(50) NOT NULL,
    grade VARCHAR(50) NOT NULL,
    class_section VARCHAR(50) NOT NULL,
    roll_number VARCHAR(50) UNIQUE NOT NULL,
    address TEXT,
    phone_number VARCHAR(20),
    parent_name VARCHAR(255),
    parent_phone VARCHAR(20),
    remarks TEXT,
    status VARCHAR(50) DEFAULT 'ACTIVE',
    enrollment_date DATE
);
```

### Teachers Table
```sql
CREATE TABLE teachers (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    date_of_birth DATE NOT NULL,
    gender VARCHAR(50) NOT NULL,
    subject VARCHAR(255) NOT NULL,
    qualification VARCHAR(255) NOT NULL,
    employee_id VARCHAR(50) UNIQUE NOT NULL,
    phone_number VARCHAR(20),
    address TEXT,
    joining_date DATE NOT NULL,
    experience_years INTEGER,
    salary DECIMAL(10,2),
    specialization TEXT,
    remarks TEXT,
    status VARCHAR(50) DEFAULT 'ACTIVE'
);
```

## 🚀 Installation

### Prerequisites
- **Java 17** or higher
- **Maven 3.6+**

### Steps

1. **Clone or extract the project**
```bash
cd school-dashboard
```

2. **Build the project**
```bash
mvn clean install
```

3. **Run the application**
```bash
mvn spring-boot:run
```

Or run the JAR:
```bash
java -jar target/school-dashboard-1.0.0.jar
```

4. **Access the application**
- Main Application: http://localhost:8080
- H2 Database Console: http://localhost:8080/h2-console
  - JDBC URL: `jdbc:h2:mem:schooldb`
  - Username: `sa`
  - Password: (leave empty)

## 💻 Usage

### Dashboard
Navigate to `http://localhost:8080` to see the main dashboard with:
- Total students and teachers count
- Quick access to recent students and teachers
- Navigation to Students and Teachers modules

### Managing Students

**View All Students:**
- Navigate to Students → Shows list of all students
- Use search to find specific students

**Add New Student:**
1. Click "Add New Student" button
2. Fill in all required fields (marked with *)
3. Click "Create Student"

**Edit Student:**
1. Click "Edit" button next to a student
2. Modify the information
3. Click "Update Student"

**View Student Details:**
- Click "View" button to see complete student information

**Delete Student:**
- In student details page, click "Delete Student" (requires confirmation)

### Managing Teachers

**View All Teachers:**
- Navigate to Teachers → Shows list of all teachers
- Use search functionality

**Add New Teacher:**
1. Click "Add New Teacher" button
2. Fill in required information
3. Click "Create Teacher"

**Edit/View/Delete:**
- Similar to student management

## 📡 API Endpoints

### Dashboard
```
GET  /                  - Main dashboard
```

### Students
```
GET  /students          - List all students (with optional search)
GET  /students/{id}     - View student details
GET  /students/new      - Show create form
POST /students          - Create new student
GET  /students/{id}/edit - Show edit form
POST /students/{id}     - Update student
POST /students/{id}/delete - Delete student
```

### Teachers
```
GET  /teachers          - List all teachers (with optional search)
GET  /teachers/{id}     - View teacher details
GET  /teachers/new      - Show create form
POST /teachers          - Create new teacher
GET  /teachers/{id}/edit - Show edit form
POST /teachers/{id}     - Update teacher
POST /teachers/{id}/delete - Delete teacher
```

## 📊 Mock Data

The application automatically initializes with mock data:

**Students:** 12 sample students across grades 9-11
- Names: Emma Johnson, Liam Smith, Olivia Brown, Noah Davis, etc.
- Various grades (9, 10, 11) and sections (A, B, C)
- Complete personal and academic information

**Teachers:** 8 sample teachers
- Subjects: Mathematics, English, Science, History, Physical Education, Computer Science, Chemistry, Biology
- Experience ranging from 5-11 years
- Complete employment information

## 🎨 UI Features

- **Modern Design:** Clean, professional interface with gradient headers
- **Responsive:** Works on desktop, tablet, and mobile devices
- **Color-Coded:** Status badges (green for active, red for inactive, yellow for warnings)
- **Search:** Real-time search functionality
- **Forms:** Comprehensive forms with validation
- **Tables:** Sortable, clean data presentation

## 🔧 Configuration

### Database
Edit `src/main/resources/application.properties`:

```properties
# Switch to MySQL (optional)
spring.datasource.url=jdbc:mysql://localhost:3306/schooldb
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
```

### Server Port
```properties
server.port=8080  # Change to your preferred port
```

### Logging
```properties
logging.level.com.school=DEBUG  # Change log level
```

## 📁 Project Structure

```
school-dashboard/
├── src/
│   ├── main/
│   │   ├── java/com/school/
│   │   │   ├── controller/
│   │   │   │   ├── DashboardController.java
│   │   │   │   ├── StudentController.java
│   │   │   │   └── TeacherController.java
│   │   │   ├── service/
│   │   │   │   ├── StudentService.java
│   │   │   │   └── TeacherService.java
│   │   │   ├── repository/
│   │   │   │   ├── StudentRepository.java
│   │   │   │   └── TeacherRepository.java
│   │   │   ├── model/
│   │   │   │   ├── Student.java
│   │   │   │   └── Teacher.java
│   │   │   ├── config/
│   │   │   │   └── DataInitializer.java
│   │   │   └── SchoolDashboardApplication.java
│   │   └── resources/
│   │       ├── static/css/
│   │       │   └── style.css
│   │       ├── templates/
│   │       │   ├── dashboard.html
│   │       │   ├── students/
│   │       │   │   ├── list.html
│   │       │   │   ├── form.html
│   │       │   │   └── view.html
│   │       │   └── teachers/
│   │       │       ├── list.html
│   │       │       ├── form.html
│   │       │       └── view.html
│   │       └── application.properties
│   └── test/
├── pom.xml
└── README.md
```

## 🧪 Testing

Run tests:
```bash
mvn test
```

## 🚢 Deployment

### Build JAR
```bash
mvn clean package
```

### Run in Production
```bash
java -jar target/school-dashboard-1.0.0.jar --spring.profiles.active=prod
```

### Docker (Optional)
```dockerfile
FROM openjdk:17-jdk-slim
COPY target/school-dashboard-1.0.0.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
```

## 🔒 Security Notes

⚠️ **This is a demonstration application. For production:**

1. Add Spring Security for authentication
2. Use a production database (MySQL/PostgreSQL)
3. Implement proper authorization
4. Add HTTPS/SSL
5. Implement proper password hashing
6. Add input sanitization
7. Enable CSRF protection

## 🐛 Troubleshooting

**Port 8080 already in use:**
```bash
# Use different port
mvn spring-boot:run -Dspring-boot.run.arguments=--server.port=8081
```

**Build fails:**
```bash
# Clean and rebuild
mvn clean install -U
```

**H2 Console not accessible:**
- Verify `spring.h2.console.enabled=true` in application.properties
- Check the correct JDBC URL: `jdbc:h2:mem:schooldb`

## 📄 License

This project is provided for educational purposes.

## 👤 Author

**Created by:** Development Team
**Version:** 1.0.0
**Last Updated:** 2025

## 🤝 Contributing

Contributions welcome! Please:
1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Submit a pull request

## 📧 Support

For issues or questions:
- Check the troubleshooting section
- Review the code documentation
- Verify Java and Maven versions

## 🎓 Learn More

- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Thymeleaf Documentation](https://www.thymeleaf.org/)
- [JPA/Hibernate Guide](https://hibernate.org/orm/documentation/)

---

**Built with ☕ Java & 🍃 Spring Boot**

*Happy Learning!* 📚
