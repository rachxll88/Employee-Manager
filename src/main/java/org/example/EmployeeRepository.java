package org.example;
import  java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import  java.util.List;
import  java.util.ArrayList;
import  java.sql.SQLException;
public class EmployeeRepository {
    private Connection connection;

    public EmployeeRepository(Connection connection) {
        this.connection = connection;
    }

    public List<Employee> findAll() throws SQLException {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM employees";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            int salary = resultSet.getInt("salary");
            String department = resultSet.getString("department");

            Employee employee = new Employee(name, salary, department);
            employees.add(employee);
        }
        return employees;
    }


    public Employee findById(int id) throws SQLException {
        String sql = "SELECT * FROM employees WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            String name = resultSet.getString("name");
            int salary = resultSet.getInt("salary");
            String department = resultSet.getString("department");

            Employee employee = new Employee(name, salary, department);

            return employee;
        }
        return null;

    }

    public void addEmployee(Employee employee) throws SQLException {
        String sql = "INSERT INTO employees(name,salary,department) VALUES(?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, employee.getName());
        statement.setInt(2, employee.getSalary());
        statement.setString(3, employee.getDepartment());
        statement.executeUpdate();
    }

    public void updateEmployee(int id, Employee employee) throws SQLException {
        String sql = "UPDATE employees SET name = ?, salary = ?, department = ?  WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, employee.getName());
        statement.setInt(2, employee.getSalary());
        statement.setString(3, employee.getDepartment());
        statement.setInt(4, id);
        statement.executeUpdate();
    }
    public  void deleteEmployee(int id) throws SQLException {
        String sql = "DELETE FROM employees WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1,id);
        statement.executeUpdate();
    }
}



