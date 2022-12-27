package com.myApp.dao;

import com.myApp.entity.Employee;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;


@Repository()
public class EmployeeDaoImpl implements EmployeeDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Employee> findAllEmployees() {
        return entityManager.createQuery("FROM Employee").getResultList();
    }

    @Override
    public void deleteEmployee(int id) {
        entityManager.createQuery("delete Employee d where d.id =:var")
                .setParameter("var", id)
                .executeUpdate();
    }

    @Override
    public Employee getEmpFromId(int id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public void save(Employee employee) {
        entityManager.merge(employee);
    }



}
