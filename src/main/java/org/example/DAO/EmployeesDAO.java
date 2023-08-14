package org.example.DAO;
;
import org.example.Employee.Employee;
import java.sql.*;
import java.util.LinkedList;


public class EmployeesDAO implements EmployeeDAO {
    @Override
    public void deleteAllEmployees() {

    }

    @Override
    public LinkedList<Employee> getEmployeesWithColumnLabel(String columnLabel) {
    return null;//Uncompleted
    }

    public void deleteWithId(int id){

    }
    public LinkedList<Employee> getAllEmployees(){
        LinkedList<Employee> all = DataBaseUtils.ConnectToDataBase(connection -> {
            String query = "SELECT * FROM employees";
            return QueryUtils.fetchMultipleDataWithQuery(connection,query);
        });
        return all;
    }
    public Employee getEmployeeWithId(int id) { // only one employee
      Employee emp =  DataBaseUtils.ConnectToDataBase(connection -> {
                String query = "SELECT * FROM employees WHERE user_id =" + id;
                return QueryUtils.fetchOneDataWithQuery(connection,query);
        });
        return emp;
    }

    public void addOneEmployee(int id,String name , String lastName){
              DataBaseUtils.ConnectToDataBase(c ->{ // I give you c variable that is instantiated from Consumer type is Consumer<Connection> and i say (implement) what should method of this obj does.
            //Every time that I give you variable , I say what should method of this obj does.
            // rest of this code shows what accept method does

                String query = "INSERT INTO employees(user_id,user_name,user_lastName) VALUES(?,?,?)" ;
                QueryUtils.modifyDataWithQuery(c,query,id,name,lastName);
        });
    }

}
