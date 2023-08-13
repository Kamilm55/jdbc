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

        String query = "SELECT * from employees;";
        String prevName = "updated employee";
        int uId = 12;
        String uName = "Updated";
        String updateQuery = "DELETE FROM employees WHERE user_id >= 5;";
        PreparedStatement prStatement = connection.prepareStatement(updateQuery);
        // set values into ?
//        prStatement.setString(1,uName);
//        prStatement.setInt(2,uId);
//        prStatement.setString(3,prevName);
        int insertValues = prStatement.executeUpdate(); // inserting and updating data

        ResultSet resultSet = prStatement.executeQuery(query);// fetching data

        System.out.println(insertValues + "row affected");
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
                String lastName = resultSet.getString("user_lastName");
                int id = resultSet.getInt("user_id");

                System.out.println( id  + " | " + name+ " | " + email + " | " + lastName );
            }

        connection.close();


    }
}