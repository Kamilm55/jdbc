package org.example.DAO;
;
import org.example.Employee.Employee;
import java.sql.*;

public class EmployeesDAO {

    public Employee getEmployeeWithId(int id) { // only one employee
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "");
            String query = "SELECT * FROM employees WHERE user_id =" + id;
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            resultSet.next(); // move the cursor
            Employee employee = new Employee(resultSet.getInt("user_id"), resultSet.getString("user_name"), resultSet.getString("user_lastName"));
            connection.close();
            return employee;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void addOneEmployee(int id,String name , String lastName){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "");
            String query = "INSERT INTO employees(user_id,user_name,user_lastName) VALUES(?,?,?)" ;
            PreparedStatement statement = connection.prepareStatement(query);
            // modify preparedStatement
            statement.setInt(1,id);
            statement.setString(2,name);
            statement.setString(3,lastName);
            int updatedResult = statement.executeUpdate();

            connection.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteWithId(int id){}

    public void ConnectToDataBase() throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "");) {
            //i want to use this area independently , not define before ,implement when i use it

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
