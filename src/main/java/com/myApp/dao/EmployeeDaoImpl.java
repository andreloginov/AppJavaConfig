package com.myApp.dao;

import com.myApp.entity.Employee;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;




@Repository()
@Transactional(readOnly = true)
public class EmployeeDaoImpl implements EmployeeDao {

    public EmployeeDaoImpl() {

    }
    @PersistenceContext
    private EntityManager entityManager;

    public EmployeeDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Transactional
    public List<Employee> findAllEmployees() {
        List<Employee> employee = entityManager
                .createQuery("FROM Employee")
                .getResultList();
        return employee;
    }

    public void save(Employee user) {

    }



}
