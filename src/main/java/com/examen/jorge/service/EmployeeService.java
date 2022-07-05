package com.examen.jorge.service;

import com.examen.jorge.interfaces.IEmployee;
import com.examen.jorge.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements  IEmployeeService{

    @Autowired
    private IEmployee data;

    @Override
    public List<Employee> listar() {
        return (List<Employee>)data.findAll();
    }

    @Override
    public Optional<Employee> listarId(int id) {
        return Optional.empty();
    }

    @Override
    public int save(Employee e) {
        return 0;
    }

    @Override
    public void delete(int id) {

    }
}
