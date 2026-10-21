# Employee Manager

**A Java console application for managing employee records using PostgreSQL and JDBC.**

---

## Technologies

- **Java 21**


- **PostgreSQL**


- **JDBC**


- **Maven**


- **PreparedStatement**


- **IntelliJ IDEA**

## Overview

Employee Manager is a console-based application that allows users to manage employee records stored in a PostgreSQL database.



The application uses **JDBC** to connect to the database and execute SQL queries. Its code is organized into separate classes for employee data, business logic, database operations, and application entry point.

## Features

- **View All Employees** — retrieve and display employee records.


- **Find Employee by ID** — search for a specific employee.


- **Add Employee** — create a new employee record.


- **Update Employee** — modify an employee's name, salary, and department.


- **Delete Employee** — remove an employee by ID.


- **Input Handling** — check menu input and handle invalid menu choices.


- **Database Integration** — store and retrieve data using PostgreSQL.



## Project Architecture

The application follows a simple layered structure.

- **Main** — displays the console menu and handles user interaction.


- **Employee** — represents an employee with a name, salary, and department.


- **EmployeeService** — provides the application logic and delegates database operations.


- **EmployeeRepository** — executes SQL queries to retrieve, insert, update, and delete employee records.


- **DatabaseConnection** — establishes a connection to PostgreSQL using environment variables.



**Application flow:**

`Main → EmployeeService → EmployeeRepository → PostgreSQL`

## Database

The application requires a PostgreSQL database with an `employees` table.



Example table structure:

```sql
CREATE TABLE employees (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    salary INTEGER NOT NULL,
    department VARCHAR(255) NOT NULL
);
```

## Configuration

Database connection settings are read from environment variables.

- **`DB_URL`** — JDBC connection URL.


- **`DB_USER`** — PostgreSQL username.


- **`DB_PASSWORD`** — PostgreSQL password.

Example configuration:

```text
DB_URL=jdbc:postgresql://localhost:5432/employee_manager
DB_USER=postgres
DB_PASSWORD=your_password
```

Replace the example values with your local database settings.



**Security:** Keep database passwords in environment variables. Never commit real credentials to GitHub.

## How to Run

1. Install **JDK 21** and **PostgreSQL**.


2. Create the `employee_manager` database.


3. Create the `employees` table using the SQL statement above.


4. Configure the `DB_URL`, `DB_USER`, and `DB_PASSWORD` environment variables.


5. Open the project in IntelliJ IDEA as a Maven project.


6. Run the `Main` class.



After connecting to the database, the application displays a console menu for managing employee records.


## SQL and Database Operations

The project demonstrates:

- **SELECT** — retrieve employee records.


- **INSERT** — add new employees.


- **UPDATE** — modify existing employee records.


- **DELETE** — remove employee records.


- **PreparedStatement** — execute parameterized SQL queries.

## Project Goals

- Practice Java backend programming.


- Learn how Java connects to PostgreSQL using JDBC.


- Understand CRUD operations.


- Practice SQL queries and database interaction.


- Separate application logic from database access.


- Understand the responsibilities of service and repository classes.
