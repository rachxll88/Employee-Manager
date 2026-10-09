package org.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        System.out.println("Connected!");

        EmployeeRepository repository = new EmployeeRepository(connection);
        EmployeeService service = new EmployeeService(repository);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Employee Manager ===");
            System.out.println("1. Show all employees");
            System.out.println("2. Find employee by ID");
            System.out.println("3. Add employee");
            System.out.println("4. Update employee");
            System.out.println("5. Delete employee");
            System.out.println("0. Exit");

            System.out.print("Choose an option: ");

            if (!scanner.hasNextInt()) {
                scanner.nextLine();
                System.out.println("Please enter a number!");
                continue;
            }

            int choice = scanner.nextInt();

            if (choice == 0) {
                break;
            } else if (choice == 1) {
                List<Employee> employees = service.findAll();

                for (Employee employee : employees) {
                    System.out.println(
                            employee.getName() + " " + employee.getSalary()
                    );
                }

            } else if (choice == 2) {
                System.out.print("Enter employee ID: ");
                int id = scanner.nextInt();

                Employee employee = service.findById(id);

                if (employee != null) {
                    System.out.println(
                            employee.getName() + " " + employee.getSalary()
                    );
                } else {
                    System.out.println("Employee not found");
                }

            } else if (choice == 3) {
                scanner.nextLine();

                System.out.print("Enter name: ");
                String name = scanner.nextLine();

                System.out.print("Enter salary: ");
                int salary = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Enter department: ");
                String department = scanner.nextLine();

                Employee employee = new Employee(name, salary, department);
                service.addEmployee(employee);

                System.out.println("Employee added!");

            } else if (choice == 4) {
                System.out.print("Enter employee ID: ");
                int id = scanner.nextInt();

                Employee employee = service.findById(id);

                if (employee == null) {
                    System.out.println("Employee not found");
                } else {
                    scanner.nextLine();

                    System.out.print("Enter new name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter new salary: ");
                    int salary = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter new department: ");
                    String department = scanner.nextLine();

                    Employee updatedEmployee =
                            new Employee(name, salary, department);

                    service.updateEmployee(id, updatedEmployee);

                    System.out.println("Employee updated!");
                }

            } else if (choice == 5) {
                System.out.print("Enter employee ID: ");
                int id = scanner.nextInt();

                Employee employee = service.findById(id);

                if (employee != null) {
                    service.deleteEmployee(id);
                    System.out.println("Employee deleted!");
                } else {
                    System.out.println("Employee not found");
                }

            } else {
                System.out.println("Invalid option!");
            }
        }

        scanner.close();
        connection.close();
    }
}
















