package com.examen.jorge.service;

import com.examen.jorge.model.Employee;
import com.examen.jorge.repository.RepositoryEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceEmployee implements  IEmployeeService{

    @Autowired
    private RepositoryEmployee repositoryEmployee;

    @Override
    public Employee findById(Integer id){       //FINDBYID
        Optional<Employee> employeeBD = this.repositoryEmployee.findById(id);
        if(employeeBD.isPresent()){
            return employeeBD.get();
        }else{
            throw new RuntimeException("Error al encontrar el Id: " + id);
        }
    }
    @Override
    public List<Employee> findAll() {           //FINDALL
        return (List<Employee>) this.repositoryEmployee.findAll();
    }

    @Override
    public void delete(Integer id) {               //DELETE
        Optional<Employee> employeeDB = this.repositoryEmployee.findById(id);
        if(employeeDB.isPresent()){
            this.repositoryEmployee.delete(employeeDB.get());
        }else{
            throw new RuntimeException("Error al encontrar el Id: " + id);
        }
    }
    @Override
    public Employee update(Employee employee) {         //UPDATE
        Optional<Employee> employeeDB = this.repositoryEmployee.findById(employee.getId());
        if(employeeDB.isPresent()){
            Employee employeeUpdate = employeeDB.get();
            employeeUpdate.setId(employee.getId());
            employeeUpdate.setFirstname(employee.getFirstname());
            employeeUpdate.setSurname(employee.getSurname());
            repositoryEmployee.save(employeeUpdate);
            return employeeUpdate;
        }else{
            throw new RuntimeException("Error al encontrar el Id:" + employee.getId());
        }
    }
    @Override
    public Employee addEmployee(Employee employee){     //ADD
        return repositoryEmployee.save(employee);
    }
}



