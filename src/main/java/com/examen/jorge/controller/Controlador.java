package com.examen.jorge.controller;

import com.examen.jorge.model.Employee;
import com.examen.jorge.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping
public class Controlador {

    @Autowired
    private IEmployeeService service;

    @GetMapping("/listar")
    public String listar(Model model){
        List<Employee>employees= service.listar();
        model.addAttribute("employees", employees);
        return "index";
    }
}
