package org.example.DAO;

import com.google.protobuf.Enum;
import org.example.Employee.ColumnLabel;
import org.example.Employee.Employee;

import java.util.LinkedList;

public interface EmployeeDAO {
    LinkedList<Employee> getAllEmployees();
    void deleteAllEmployees();
    Employee getEmployeeWithId(int id);// id must be unique
    LinkedList<Employee> getEmployeesWithColumnLabel(ColumnLabel columnLabel, String value);
    void addOneEmployee(int id,String name , String lastName);
    void deleteWithId(int id);
    void updateOneEmployeeWithId(int id, ColumnLabel columnLabel, String name, String lastName);

}
