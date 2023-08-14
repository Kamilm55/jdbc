package org.example.Employee;

import java.util.LinkedList;
import java.util.List;

public class Employee
{
    public static LinkedList<Employee> getAllEmployees() {
        return allEmployees;
    }

    public static void setAllEmployees(LinkedList<Employee> allEmployees) {
        Employee.allEmployees = allEmployees;
    }

    private static LinkedList<Employee> allEmployees;


    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private String name;
    private String lastName;
    public Employee(int id, String name, String lastName) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
    }

}
