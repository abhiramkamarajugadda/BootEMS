# BootEMS: Employee Management System (Spring Boot MVC)

A Spring Boot MVC web application for employee registration, login and admin-side employee management, using Spring Data JPA with MySQL and JSP views.

## Features

- Employee self-registration (name, email, password, age, gender, mobile, department, address)
- Login with email and password, with session handling and logout
- Admin view: list all employees, search by email, edit and delete records
- Spring Data JPA derived queries: `findByEmailAndPassword`, `findByEmail`
- Password is preserved on edit (the update loads the stored password before saving)

## Tech Stack

| Layer | Technology |
|---|---|
| Language | Java 21 |
| Framework | Spring Boot 4.1.1, Spring Web MVC |
| Persistence | Spring Data JPA, Hibernate, MySQL (`mysql-connector-j`) |
| Views | JSP, JSTL (Tomcat Jasper) |
| Build | Maven |

## Project Structure

```text
EMS/
  pom.xml
  src/main/java/com/mvc/
    EmsApplication.java
    controller/   HomeController, EmployeeController
    service/      EmployeeService
    repository/   EmployeeRepository (JpaRepository<Employee, Integer>)
    model/        Employee
  src/main/webapp/   index, register, login, admin, employee, viewemps, viewemp, search, edit JSP pages
```

## Routes

| Path | Description |
|---|---|
| `/` | Home page |
| `/save` | Register an employee |
| `/login` | Log in (employee or admin) |
| `/findAll` | List all employees |
| `/findByEmail` | Search an employee by email |
| `/edituser` | Update an employee |
| `/delete` | Delete an employee by id |
| `/logout` | End the session |

## Data Model

`Employee`: id (generated), name, email, password, age, gender, mobile, department, address.

## Getting Started

**Prerequisites:** JDK 21, MySQL 8, Maven.

```bash
git clone https://github.com/abhiramkamarajugadda/BootEMS.git
cd BootEMS/EMS
```

1. Create the database: `CREATE DATABASE bootems;`
2. Set the database credentials as environment variables (`application.properties` reads `${DB_USERNAME:root}` and `${DB_PASSWORD:}`):
   ```bash
   export DB_USERNAME=root
   export DB_PASSWORD=your_mysql_password
   ```
3. Run `mvn spring-boot:run` and open `http://localhost:8080`.

The admin login defined in `EmployeeController` is a demo-only default for local testing; change it before any real use.

## Author

**Abhiram Kamarajugadda**
GitHub: [abhiramkamarajugadda](https://github.com/abhiramkamarajugadda) | Portfolio: [abhiramkamarajugadda.github.io](https://abhiramkamarajugadda.github.io)
