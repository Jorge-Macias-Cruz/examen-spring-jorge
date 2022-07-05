package com.examen.jorge.service;

import com.examen.jorge.model.Employee;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService {
    public List<Employee>listar();
    public Optional<Employee>listarId(int id);
    public  int save(Employee e);
    public  void delete(int id);
}
