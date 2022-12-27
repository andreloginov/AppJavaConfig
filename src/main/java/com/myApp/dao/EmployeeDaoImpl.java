package com.myApp.dao;

import com.myApp.entity.Employee;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;




@Repository()
@Transactional
public class EmployeeDaoImpl implements EmployeeDao {

    public EmployeeDaoImpl() {

    }
    @PersistenceContext
    private EntityManager entityManager;

    public EmployeeDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    @Transactional
    public List<Employee> findAllEmployees() {
        return entityManager.createQuery("FROM Employee").getResultList();
    }

    @Override
    @Transactional
    public void deleteEmployee(int id) {
        entityManager.createQuery("delete Employee d where d.id =:var")
                .setParameter("var", id)
                .executeUpdate();
    }

    @Override
    @Transactional
    public Employee getEmpFromId(int id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    @Transactional
    public void save(Employee employee) {
        entityManager.merge(employee);
    }



}
