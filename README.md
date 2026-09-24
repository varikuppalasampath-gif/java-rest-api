# Java REST API

A professional Spring Boot REST API portfolio project demonstrating backend development, CRUD operations, validation, exception handling, search, JPA/Hibernate and database integration.

## Technologies
- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA / Hibernate
- Maven
- REST / JSON
- Bean Validation
- H2 for local demo
- Microsoft SQL Server support

## Features
- Create, read, update and delete employees
- Search by name or department
- Validation and global exception handling
- Duplicate email validation
- Layered Controller → Service → Repository architecture
- H2 quick-start database
- SQL Server profile for database integration

## API
| Method | Endpoint | Description |
|---|---|---|
| GET | `/api/employees` | Get all employees |
| GET | `/api/employees/{id}` | Get employee by ID |
| GET | `/api/employees/search?name=John` | Search by name |
| GET | `/api/employees/search?department=IT` | Search by department |
| POST | `/api/employees` | Create employee |
| PUT | `/api/employees/{id}` | Update employee |
| DELETE | `/api/employees/{id}` | Delete employee |

## Run
Requirements: JDK 17+ and Maven 3.9+.

```bash
mvn clean install
mvn spring-boot:run
```

API: `http://localhost:8080/api/employees`

H2 console: `http://localhost:8080/h2-console`

JDBC URL: `jdbc:h2:mem:employeedb`

## SQL Server
Use the SQL Server profile and set environment variables rather than committing credentials:

```bash
mvn spring-boot:run -Dspring-boot.run.profiles=sqlserver
```

Environment variables: `DB_URL`, `DB_USERNAME`, `DB_PASSWORD`.

## Sample POST
```json
{
  "name": "Sampath Kumar",
  "email": "sampath@example.com",
  "department": "IT",
  "designation": "Software Developer"
}
```

## Author
**V. Sampath** — Full-Stack Developer | Java | React.js | Android | SQL Server

LinkedIn: https://www.linkedin.com/in/sampath-varikuppala-9566802b0/
Email: varikuppalaa.sampath@gmail.com
