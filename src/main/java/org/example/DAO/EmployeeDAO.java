package org.example.DAO;

import org.example.Employee.Employee;

import java.util.LinkedList;

public interface EmployeeDAO {
    LinkedList<Employee> getAllEmployees();
    void deleteAllEmployees();
    Employee getEmployeeWithId(int id);// id must be unique
    LinkedList<Employee> getEmployeesWithColumnLabel(String columnLabel);
    void addOneEmployee(int id,String name , String lastName);
    void deleteWithId(int id);

}
