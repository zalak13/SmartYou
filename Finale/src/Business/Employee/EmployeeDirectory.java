/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee;

import java.util.ArrayList;

/**
 *
 * @author Zak
 */
public class EmployeeDirectory {
      private ArrayList<Employee> employeeList;

    public EmployeeDirectory() {
        //if(employeeList)
         employeeList = new ArrayList<Employee>();
    }

    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }
    
    public Employee createEmployee(String name){
        Employee employee = new Employee();
        employee.setName(name);
        employee.setId(employeeList.size()+1);
        employeeList.add(employee);
        return employee;
    }
    
    public Employee searchEmployee(String name){
        for (Employee employee : employeeList) {
            if(employee.getName().equals(name) ){
                return employee;
            }
        }
        return null;
    } 
    
    public void deleteEmployee(Employee e){
        employeeList.remove(e);
    }
}
