# School_Dashboard

# 🏫 School Management Dashboard

<div align="center">

![Java](https://img.shields.io/badge/Java-17-orange?style=for-the-badge&logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.0-brightgreen?style=for-the-badge&logo=spring)
![Maven](https://img.shields.io/badge/Maven-3.6+-blue?style=for-the-badge&logo=apache-maven)
![H2](https://img.shields.io/badge/H2-Database-blue?style=for-the-badge)
![License](https://img.shields.io/badge/License-MIT-green?style=for-the-badge)

**A comprehensive web-based school management system with student and teacher information management**

[Features](#-features) • [Demo](#-demo) • [Installation](#-installation) • [Usage](#-usage) • [API](#-api-endpoints) • [Contributing](#-contributing)

</div>

---

## 📖 About

School Management Dashboard is a full-stack web application built with **Spring Boot** and **Thymeleaf** that streamlines the management of student and teacher information. It features a modern, responsive UI with complete CRUD operations, search functionality, and real-time statistics.

### 🎯 Built For

- 📚 Educational Institutions
- 👨‍🏫 Teachers & Administrators
- 🎓 School Management Teams
- 💻 Developers learning Spring Boot

---

## ✨ Features

### 👨‍🎓 Student Management
- ✅ **Complete CRUD Operations** - Add, view, edit, and delete student records
- ✅ **Comprehensive Information** - Personal details, academic info, parent/guardian contact
- ✅ **Grade & Section Tracking** - Organize students by grade and class section
- ✅ **Status Management** - Active, Inactive, Graduated, Transferred
- ✅ **Search & Filter** - Find students by name, email, or roll number
- ✅ **Enrollment Tracking** - Monitor enrollment dates and history

### 👨‍🏫 Teacher Management
- ✅ **Employee Records** - Complete teacher information management
- ✅ **Qualification Tracking** - Education, experience, and specializations
- ✅ **Subject Assignment** - Track teaching subjects and responsibilities
- ✅ **Salary Management** - Compensation and experience tracking
- ✅ **Status Monitoring** - Active, On Leave, Resigned, Retired
- ✅ **Search Functionality** - Find teachers by name, subject, or employee ID

### 📊 Dashboard & Analytics
- ✅ **Real-time Statistics** - Total students, teachers, and more
- ✅ **Quick Overview** - Recent students and teachers at a glance
- ✅ **Visual Cards** - Clean, informative statistics display
- ✅ **Quick Navigation** - Easy access to all modules

### 🎨 UI/UX Features
- ✅ **Modern Design** - Clean, professional gradient interface
- ✅ **Responsive Layout** - Works on desktop, tablet, and mobile
- ✅ **Color-Coded Status** - Visual badges for easy identification
- ✅ **Form Validation** - Client and server-side validation
- ✅ **User-Friendly Forms** - Intuitive data entry
- ✅ **Alert Messages** - Success and error notifications

---

## 🚀 Quick Start

### Prerequisites

- **Java 17** or higher
- **Maven 3.6+**

### Installation

```bash
# Clone the repository
git clone https://github.com/yourusername/school-dashboard.git
cd school-dashboard

# Build the project
mvn clean install

# Run the application
mvn spring-boot:run
```

### Access the Application

- **Main Application**: http://localhost:8080
- **H2 Database Console**: http://localhost:8080/h2-console
  - JDBC URL: `jdbc:h2:mem:schooldb`
  - Username: `sa`
  - Password: _(leave empty)_

---

## 💻 Usage

### Managing Students

**Add New Student:**
1. Click "Add New Student" button
2. Fill in required fields (marked with *)
3. Click "Create Student"

**Edit Student:**
1. Find student in list or use search
2. Click "Edit" button
3. Update information
4. Click "Update Student"

**Search Students:**
- Use search box to find by name, email, or roll number

### Managing Teachers

**Add New Teacher:**
1. Navigate to Teachers section
2. Click "Add New Teacher"
3. Enter employment and qualification details
4. Submit the form

**Search Teachers:**
- Search by name, subject, employee ID

---

## 📡 API Endpoints

### Dashboard
```http
GET  /                           # Main dashboard
```

### Students
```http
GET  /students                   # List all students
GET  /students?search={keyword}  # Search students
GET  /students/{id}              # View student details
GET  /students/new               # Show create form
POST /students                   # Create new student
GET  /students/{id}/edit         # Show edit form
POST /students/{id}              # Update student
POST /students/{id}/delete       # Delete student
```

### Teachers
```http
GET  /teachers                   # List all teachers
GET  /teachers?search={keyword}  # Search teachers
GET  /teachers/{id}              # View teacher details
GET  /teachers/new               # Show create form
POST /teachers                   # Create new teacher
GET  /teachers/{id}/edit         # Show edit form
POST /teachers/{id}              # Update teacher
POST /teachers/{id}/delete       # Delete teacher
```

---

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

---

## 📁 Project Structure

```
school-dashboard/
├── src/
│   ├── main/
│   │   ├── java/com/school/
│   │   │   ├── controller/           # MVC Controllers
│   │   │   ├── service/              # Business Logic
│   │   │   ├── repository/           # Data Access Layer
│   │   │   ├── model/                # Entity Models
│   │   │   ├── config/               # Configuration
│   │   │   └── SchoolDashboardApplication.java
│   │   └── resources/
│   │       ├── static/css/           # Stylesheets
│   │       ├── templates/            # Thymeleaf Templates
│   │       └── application.properties
│   └── test/
├── pom.xml                            # Maven Configuration
└── README.md                          # This file
```

---

## 🛠️ Technology Stack

| Layer | Technology |
|-------|------------|
| **Backend** | Spring Boot 3.2.0 |
| **Language** | Java 17 |
| **Web Framework** | Spring MVC |
| **Template Engine** | Thymeleaf |
| **ORM** | Spring Data JPA / Hibernate |
| **Database** | H2 (in-memory) |
| **Build Tool** | Maven 3.6+ |
| **Validation** | Jakarta Bean Validation |

---

## 📊 Mock Data

The application comes pre-loaded with sample data:

### 12 Students
- Emma Johnson, Liam Smith, Olivia Brown, Noah Davis
- Ava Wilson, Ethan Martinez, Sophia Anderson, Mason Taylor
- Isabella Thomas, Lucas Lee, Mia White, Aiden Harris

### 8 Teachers
- John Doe (Mathematics), Mary Johnson (English)
- Robert Williams (Science), Jennifer Brown (History)
- Michael Jones (PE), Sarah Davis (Computer Science)
- David Miller (Chemistry), Emily Wilson (Biology)

---

## ⚙️ Configuration

### Switch to MySQL

Edit `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/schooldb
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
```

### Change Server Port

```properties
server.port=8081
```

---

## 🐛 Troubleshooting

**Port 8080 already in use:**
```bash
mvn spring-boot:run -Dspring-boot.run.arguments=--server.port=8081
```

**Build fails:**
```bash
mvn clean install -U
```

**H2 Console not accessible:**
- Verify `spring.h2.console.enabled=true`
- Check JDBC URL: `jdbc:h2:mem:schooldb`

---

## 🤝 Contributing

Contributions are welcome!

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

---

## 🙏 Acknowledgments

- Spring Framework Team
- Thymeleaf Team
- Open Source Community

---

<div align="center">

**Made with ☕ Java & 🍃 Spring Boot**

**Happy Learning & Teaching! 📚**

[⬆ Back to Top](#-school-management-dashboard)

</div>
