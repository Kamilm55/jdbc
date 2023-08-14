package org.example.DAO;

import org.example.Main;
import org.jetbrains.annotations.NotNull;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.function.Consumer;
import java.util.function.Function;

public class DataBaseUtils {
    // This is for accessing url name and password of the database
    public static Connection loadDatabaseConfig() throws SQLException {
        // access sensitive data from config file
        Properties prop = new Properties();
        InputStream input = Main.class.getClassLoader().getResourceAsStream("config.properties");
        try {
            prop.load(input);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String url = prop.getProperty("database.url");
        String username = prop.getProperty("database.username");
        String password = prop.getProperty("database.password");

        //load class
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return DriverManager.getConnection(url,username, password);
    }
    //This is for updating,deleting or other data manipulations:void
    public static void ConnectToDataBase(Consumer<Connection> operation) {
        //we have Consumer<Connection> type "operation" variable but this variable implementation is not defined , it can behave differently,we can use fetching data or updating query
        // operation is object that is instantiated from Consumer,it has "accept" method that can accept parameters and process it
        //accept method accept one data process into other one , not defined yet , it depends on us
        //c = operation

        // Try with resources , finally it auto close
      try(Connection connection = loadDatabaseConfig()){
          operation.accept(connection);//operation is start and end in this line
      }
       catch (SQLException e) {
          throw new RuntimeException(e);
      }
    }

    //This is for fetching data: return value
    public static  <T> T ConnectToDataBase(@NotNull Function<Connection, T> operation) {
        // Try with resources , finally it auto close
        try(Connection connection = loadDatabaseConfig()) {
            return (T) operation.apply(connection);//operation is start and end in this line; return value
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
