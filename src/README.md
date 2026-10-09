# Employee Manager

A console-based Java application for managing employees in a PostgreSQL database.

## Features

- View all employees
- Find an employee by ID
- Add a new employee
- Update employee information
- Delete an employee
- Handle invalid menu input and missing employees

## Technologies

- Java
- JDBC
- PostgreSQL
- SQL
- Maven
- IntelliJ IDEA

## Project Structure

- `Employee` — represents an employee.
- `DatabaseConnection` — creates a connection to PostgreSQL.
- `EmployeeRepository` — executes SQL queries.
- `EmployeeService` — handles employee operations through the repository.
- `Main` — provides the console menu.

## Database

The application uses a PostgreSQL table named `employees` with the following fields:

- `id`
- `name`
- `salary`
- `department`

## How to Run

1. Install Java and PostgreSQL.
2. Create the database and the `employees` table.
3. Configure the following environment variables:
    - `DB_URL` — PostgreSQL connection URL.
    - `DB_USER` — PostgreSQL username.
    - `DB_PASSWORD` — PostgreSQL password.
4. Open the project in IntelliJ IDEA.
5. Configure the environment variables in the run configuration for `Main`.
6. Run `Main.java`.

## Purpose

This project was created to practice Java, JDBC, SQL, PostgreSQL, object-oriented programming, and CRUD operations.