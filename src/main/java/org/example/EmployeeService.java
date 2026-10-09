package org.example;
import java.sql.SQLException;
import java.util.List;

public class EmployeeService {
    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }
    public List<Employee> findAll() throws SQLException {
       return repository.findAll();
    }
    public Employee findById(int id) throws SQLException {
        return  repository.findById(id);
    }
    public void   addEmployee(Employee employee) throws SQLException {
        repository.addEmployee(employee);
    }
    public void updateEmployee(int id,Employee employee) throws SQLException{
        repository.updateEmployee(id,employee);
    }
    public void deleteEmployee(int id) throws SQLException {
        repository.deleteEmployee(id);
    }
}



