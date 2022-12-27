package com.myApp.service;

import com.myApp.dao.EmployeeDao;
import com.myApp.entity.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDao employeeDao;

    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }


    @Override
    @Transactional(readOnly = true)
    public List<Employee> getAllEmployees() {
        return employeeDao.findAllEmployees();
    }

    @Override
    @Transactional
    public void saveEmployee(Employee employee) {
        employeeDao.save(employee);
    }

    @Override
    @Transactional(readOnly = true)
    public Employee getEmpFromId(int id) {
        return employeeDao.getEmpFromId(id);
    }

    @Override
    @Transactional
    public void deleteEmployee(int id) {
        employeeDao.deleteEmployee(id);
    }
}

