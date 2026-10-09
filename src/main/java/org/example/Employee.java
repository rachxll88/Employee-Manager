package org.example;

 public class Employee {
     private String name;
     private  int salary;
     private String department;

public Employee(String name,int salary,String department) {
    this.name = name;
    this.salary = salary;
    this.department = department;
}
     public String getName() {
    return name;
     }
     public  int getSalary() {
    return  salary;
     }
     public String getDepartment() {
         return department;
     }
public  void setName (String newName) {
    this.name = newName;
}
public  void setSalary(int newSalary) {
    this.salary = newSalary;
     }
public  void setDepartment(String newDepartment) {
    this.department = newDepartment;
}
}

