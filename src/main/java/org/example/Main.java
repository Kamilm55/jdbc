package org.example;
import org.example.DAO.EmployeesDAO;
import org.example.Employee.*;

//DAO design pattern data access object
public class Main {
    public static void main(String[] args)  {
        EmployeesDAO dao = new EmployeesDAO();

        dao.addOneEmployee(14,"DSA" , "Hacibeyli");

        Employee employee = dao.getEmployeeWithId(14);
        System.out.println(employee.getId() + " | " + employee.getName()+ " | " + employee.getLastName());
    }
}


