package org.example;
import java.sql.*;
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String jdbcDriver = "com.mysql.cj.jdbc.Driver";
        Class.forName(jdbcDriver);

        String url = "jdbc:mysql://localhost:3306/mydb" ;
        String user = "root";
        String password = "root";
        Connection connection = DriverManager.getConnection(url,user,password);
        Statement statement = connection.createStatement();

        String query = "SELECT * from employees;";

        String updateQuery = "INSERT INTO employees(user_id,user_lastName) VALUES(5,'Hesenov')";
        ResultSet resultSet = statement.executeQuery(query);

//        ResultSet insertValues = statement.executeUpdate(updateQuery);


//        boolean result = resultSet.next();
//        while (result != false){
//        String name = resultSet.getString("user_name");
//        String email = resultSet.getString("user_email");
//        int id = resultSet.getInt("user_id");
//
//        System.out.println( id  + " | " + name+ " | " + email);
//            result = resultSet.next();
//        }
        // shorten this

            while (resultSet.next()){
                String name = resultSet.getString("user_name");
                String email = resultSet.getString("user_email");
                int id = resultSet.getInt("user_id");

                System.out.println( id  + " | " + name+ " | " + email);
            }

        connection.close();


    }
}