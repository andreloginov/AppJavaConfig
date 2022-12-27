package com.myApp.service;

import com.myApp.dao.EmployeeDao;
import com.myApp.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDao employeeDao;

    public EmployeeServiceImpl() {

    }

    @Autowired
    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        super();
        this.employeeDao = employeeDao;
    }


    @Override
    public List<Employee> getAllEmployees() {
        return employeeDao.findAllEmployees();
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeDao.save(employee);
    }
}

