package org.example.DAO;

import org.example.Employee.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class QueryUtils {
    public static void modifyDataWithQuery(Connection c,String query, int id, String name , String lastName){
        try {
            PreparedStatement statement = c.prepareStatement(query);
            // modify preparedStatement
            statement.setInt(1,id);
            statement.setString(2,name);
            statement.setString(3,lastName);
            int updatedResult = statement.executeUpdate();
            System.out.println(updatedResult + " rows affected");
        }
        catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }
    public static void deleteWithQuery(Connection c,String query){
        try {
            PreparedStatement statement = c.prepareStatement(query);
            int updatedResult = statement.executeUpdate();
            System.out.println(updatedResult + " rows affected");
        }
        catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }
    public static Employee fetchOneDataWithQuery(Connection connection,String query){
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            resultSet.next(); // move the cursor
            Employee employee = new Employee(resultSet.getInt("user_id"), resultSet.getString("user_name"), resultSet.getString("user_lastName"));
            return employee;
        }
        catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }
    public static LinkedList<Employee> fetchMultipleDataWithQuery(Connection connection,String query){
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            LinkedList<Employee> allEmps = new LinkedList<Employee>();

          while (resultSet.next()){
            Employee employee = new Employee(resultSet.getInt("user_id"), resultSet.getString("user_name"), resultSet.getString("user_lastName"));
            allEmps.add(employee);
          }
            Employee.setAllEmployees(allEmps);
          return Employee.getAllEmployees();
        }
        catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }
}
