package org.example.DAO;
;
import org.example.Employee.Employee;

import java.sql.*;
import java.util.function.Consumer;
import java.util.function.Function;

public class EmployeesDAO {

    public void getEmployeeWithId(int id) { // only one employee

        ConnectToDataBase(c ->{ // I give you c variable that is instantiated from Consumer type is Consumer<Connection> and i say (implement) what should method of this obj does.
            //Every time that I give you variable , I say what should method of this obj does.
            // rest of this code shows what accept method does

            try {
                String query = "SELECT * FROM employees WHERE user_id =" + id;
                PreparedStatement statement = c.prepareStatement(query);
                ResultSet resultSet = statement.executeQuery();

                resultSet.next(); // move the cursor
                Employee employee = new Employee(resultSet.getInt("user_id"), resultSet.getString("user_name"), resultSet.getString("user_lastName"));
                System.out.println(employee.getId() + " | " + employee.getName()+ " | " + employee.getLastName());
            }
            catch (Exception ex){
                throw new RuntimeException(ex);
            }
        });
    }

    public void addOneEmployee(int id,String name , String lastName){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "kamil29057202");
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

//    public void showEmployee() {
//
//            ConnectToDataBase(c ->{ // I give you c variable that is instantiated from Consumer type is Consumer<Connection> and i say (implement) what should method of this obj does.
//              //Every time that I give you variable , I say what should method of this obj does.
//
//                // rest of this code shows what accept does
//
//                try {
//                    String query = "SELECT * FROM employees WHERE user_id = 1" ;
//                    PreparedStatement statement = c.prepareStatement(query);
//                    ResultSet resultSet = statement.executeQuery();
//
//                    resultSet.next(); // move the cursor
//                    System.out.println(resultSet.getInt("user_id") + resultSet.getString("user_name") + resultSet.getString("user_lastName"));
//                }
//                catch (Exception ex){
//                    throw new RuntimeException(ex);
//                }
//            });
//    }

    //This is for updating,deleting or other data manipulations:void
    public void ConnectToDataBase(Consumer<Connection> operation) {//we have Consumer<Connection> type "operation" variable but this variable implementation is not defined , it can behave differently,we can use fetching data or updating query
        // operation is object that is instantiated from Consumer,it has "accept" method that can accept parameters and process it
        //accept method accept one data process into other one , not defined yet , it depends on us
        //c = operation

        //load class
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        // Try with resources , finally it auto close
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "")) {
            operation.accept(connection);//operation is start and end in this line
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //This is for fetching data: return value
//    public <T> T ConnectToDataBase(Function<Connection, T> operation) {}

}
