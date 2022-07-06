package com.examen.jorge.controller;

import com.examen.jorge.model.Employee;
import com.examen.jorge.service.IEmployeeService;
import com.examen.jorge.service.ServiceEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class ControladorEmployee {
    @Autowired
    private ServiceEmployee serviceEmployee;

    @GetMapping("/employeeDetails/{id}")
    public ResponseEntity<Employee> findProductById(@PathVariable int id){
        return ResponseEntity.ok().body(serviceEmployee.findById(id));
    }

    @GetMapping("/employeeList")
    public ResponseEntity<?> findAll(){
        List<Employee> lista = serviceEmployee.findAll();
        if (lista.isEmpty()){
            return new ResponseEntity<>("Sin datos.", HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok().body(serviceEmployee.findAll());
    }

    @DeleteMapping("employeeDelete/{id}")
    public HttpStatus deleteEmployee(@PathVariable int id){
        this.serviceEmployee.delete(id);
        return HttpStatus.OK;
    }

    @PutMapping("/employeeUpdate/{id}")
    public ResponseEntity<Employee> update(@PathVariable int id, @RequestBody Employee employee){
        employee.setId(id);
        return ResponseEntity.ok().body(this.serviceEmployee.update(employee));
    }
    @PostMapping("/apiv1/clientes/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        return ResponseEntity.ok().body(this.serviceEmployee.addEmployee(employee));
    }


}
