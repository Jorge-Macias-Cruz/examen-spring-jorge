package com.examen.jorge.service;

import com.examen.jorge.model.Employee;

import java.util.List;


public interface IEmployeeService {

    public Employee findById(Integer id);
    public List<Employee> findAll();
    public void delete(Integer id);
    public Employee update(Employee employee);
    public  Employee addEmployee(Employee employee);

}
