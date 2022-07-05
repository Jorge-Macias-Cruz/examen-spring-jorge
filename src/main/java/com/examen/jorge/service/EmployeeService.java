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
        return data.findById(id);
    }

    @Override
    public int save(Employee e) {
        int res=0;
        Employee employee=data.save(e);
        if (!employee.equals(null)){
            res=1;
        }
        return res;
    }

    @Override
    public void delete(int id) {
        data.deleteById(id);

    }
}
