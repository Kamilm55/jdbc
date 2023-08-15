package org.example.DAO;
;
import org.example.Employee.ColumnLabel;
import org.example.Employee.Employee;

import java.util.LinkedList;


public class EmployeesDAO implements EmployeeDAO {
    @Override
    public void deleteAllEmployees() {
        DataBaseUtils.ConnectToDataBase(connection -> {
            String query = "TRUNCATE TABLE employees";
            QueryUtils.deleteWithQuery(connection,query);
        });
    }
        @Override
    public LinkedList<Employee> getEmployeesWithColumnLabel(ColumnLabel columnLabel, String value) {
       LinkedList<Employee> employees = DataBaseUtils.ConnectToDataBase(connection -> {
            String query = "SELECT * FROM employees WHERE " + columnLabel.label + " = " + "'"+value+"'";
           System.out.println(query);
            return QueryUtils.fetchMultipleDataWithQuery(connection,query);
        });
       return employees;
    }
    public void deleteWithId(int id){
        DataBaseUtils.ConnectToDataBase(connection -> {
            String query = "DELETE FROM employees WHERE user_id = " + id;
            QueryUtils.deleteWithQuery(connection,query);
        });
    }

    @Override
    public void updateOneEmployeeWithId(int id, ColumnLabel columnLabel, String name, String lastName) {
        /// Uncompleted
    }
//    @Override
//    public void updateOneEmployeeWithId(int id, ColumnLabel columnLabel, String name, String lastName) {
//        DataBaseUtils.ConnectToDataBase(connection -> {
//            String query = "UPDATE employees SET" + columnLabel + " = ? WHERE user_id = ?";
//             QueryUtils.modifyDataWithQuery(connection,query,id,name,lastName);
//        });
//    }

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
