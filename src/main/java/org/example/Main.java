package org.example;
import org.example.DAO.EmployeesDAO;
import org.example.Employee.*;

import java.util.LinkedList;

//DAO design pattern data access object
public class Main {
    public static void main(String[] args)  {
        EmployeesDAO dao = new EmployeesDAO();

//        dao.addOneEmployee(19,"DDDSA" , "Hacibeyov");
//
//        Employee employee = dao.getEmployeeWithId(19);
//        if (employee != null) {
//            System.out.println("Employee ID: " + employee.getId());
//            System.out.println("Employee Name: " + employee.getName());
//            System.out.println("Employee Last Name: " + employee.getLastName());
//        } else {
//            System.out.println("No employee found with the specified ID.");
//        }
        LinkedList<Employee> allEmployees = dao.getAllEmployees();

        if(allEmployees != null)
        for (Employee employee : allEmployees)
            System.out.println("ID: " + employee.getId() + " | Name: " + employee.getName() + " | LastName: " + employee.getLastName());

        System.out.println("App continue...");

    }
}


