package com.myApp.dao;

import com.myApp.entity.Employee;

import java.util.List;

public interface EmployeeDao {


    void save(Employee employee);


    List<Employee> findAllEmployees();
}
