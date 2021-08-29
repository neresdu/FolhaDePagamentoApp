package com.example.folhadepagamento.model;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    private static List<Employee> EmployeeList = new ArrayList<>();

    public void save(Employee employee){
        EmployeeList.add(employee);
    }
    public List<Employee> getEmployeeList(){
        return EmployeeList;
    }
    public void delete(int p){
        EmployeeList.remove(p);
    }
    public Employee getEmployee(int p){
        return EmployeeList.get(p);
    }

}
