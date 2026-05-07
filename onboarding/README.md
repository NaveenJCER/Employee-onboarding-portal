# 🧑‍💼 Employee Onboarding System

A full-stack **Employee Onboarding Management** web application built with **Spring Boot**, featuring a modern dark-themed UI, Spring Security authentication, and a persistent H2 file-based database.

---

## ✨ Features

- 🔐 **Secure Login** — Spring Security with BCrypt-encrypted admin credentials
- 📋 **Employee Dashboard** — View, add, update, and delete employees in real time
- ✅ **Onboarding Checklist** — Track 3 key steps per employee:
  - Document Submitted
  - IT Setup Done
  - Training Completed
- 💾 **Persistent Storage** — H2 file-based database (data survives restarts)
- 🎨 **Modern UI** — Glassmorphism design with particle animations and micro-interactions
- 🗄️ **H2 Console** — Built-in web console for direct SQL access

---

## 🛠️ Tech Stack

| Layer | Technology |
|-------|-----------|
| Backend | Spring Boot 3.4.5 |
| Language | Java 17 |
| Security | Spring Security 6 |
| ORM | Spring Data JPA / Hibernate |
| Database | H2 (file-based) |
| Templating | Thymeleaf (login page) |
| Frontend | HTML5, Vanilla CSS, JavaScript |
| Build | Maven Wrapper (`mvnw`) |

---

## 🚀 Getting Started

### Prerequisites

- **Java 17+** installed and `JAVA_HOME` set
- No other tools needed — Maven Wrapper is bundled

### Run the Application

**Option 1 — One-click (Windows):**

```
Double-click run.bat
```

**Option 2 — Command line:**

```bash
./mvnw spring-boot:run
```

The app will start at **http://localhost:8080**

---

## 🔑 Default Login Credentials

| Field | Value |
|-------|-------|
| Username | `admin` |
| Password | `admin123` |

> ⚠️ Change these in `SecurityConfig.java` before deploying to production.

---

## 📁 Project Structure

```
onboarding/
├── src/
│   ├── main/
│   │   ├── java/com/example/onboarding/
│   │   │   ├── OnboardingApplication.java       # Entry point
│   │   │   ├── config/
│   │   │   │   └── SecurityConfig.java          # Auth & route protection
│   │   │   ├── controller/
│   │   │   │   ├── EmployeeController.java      # REST API endpoints
│   │   │   │   └── LoginController.java         # Login page controller
│   │   │   ├── model/
│   │   │   │   └── Employee.java                # JPA entity
│   │   │   ├── repository/
│   │   │   │   └── EmployeeRepository.java      # Spring Data JPA repo
│   │   │   └── service/
│   │   │       └── EmployeeService.java         # Business logic
│   │   └── resources/
│   │       ├── application.properties           # App configuration
│   │       ├── static/
│   │       │   └── index.html                   # Main dashboard UI
│   │       └── templates/
│   │           └── login.html                   # Thymeleaf login page
│   └── test/
│       └── java/com/example/onboarding/
│           └── OnboardingApplicationTests.java
├── data/                                        # H2 database files (git-ignored)
├── pom.xml                                      # Maven dependencies
├── mvnw / mvnw.cmd                              # Maven Wrapper scripts
├── run.bat                                      # One-click Windows launcher
└── sql.md                                       # Useful SQL queries for H2 console
```

---

## 🔌 API Endpoints

| Method | Endpoint | Description | Auth Required |
|--------|----------|-------------|---------------|
| `GET` | `/` | Dashboard (index.html) | ✅ Yes |
| `GET` | `/login` | Login page | ❌ No |
| `POST` | `/login` | Submit credentials | ❌ No |
| `POST` | `/logout` | Logout | ✅ Yes |
| `GET` | `/employees` | Get all employees | ✅ Yes |
| `POST` | `/employees` | Add new employee | ✅ Yes |
| `PUT` | `/employees/{id}` | Update employee | ✅ Yes |
| `DELETE` | `/employees/{id}` | Delete employee | ✅ Yes |
| `GET` | `/h2-console` | H2 database console | ✅ Admin only |

---

## 🗄️ H2 Database Console

Access the database directly at **http://localhost:8080/h2-console**

| Field | Value |
|-------|-------|
| JDBC URL | `jdbc:h2:file:./data/onboardingdb` |
| Username | `sa` |
| Password | *(leave empty)* |

See [`sql.md`](sql.md) for ready-to-use SQL queries (SELECT, INSERT, UPDATE, DELETE, reporting).

---

## ⚙️ Configuration

Key settings in `src/main/resources/application.properties`:

```properties
# File-based H2 database (persists across restarts)
spring.datasource.url=jdbc:h2:file:./data/onboardingdb;AUTO_SERVER=TRUE

# Auto-create/update tables on startup
spring.jpa.hibernate.ddl-auto=update

# H2 web console
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
```

---

## 📸 Screenshots

| Login Page | Dashboard |
|------------|-----------|
| Dark glassmorphism login with particle animations | Employee table with onboarding status tracking |

---

## 📄 License

This project is for educational/internal use. Feel free to modify and extend.
