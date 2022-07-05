package com.examen.jorge.controller;

import com.examen.jorge.model.Employee;
import com.examen.jorge.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

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
    @PostMapping("/editar/{id}")
    public String editar(@PathVariable int id, Model model){
        Optional<Employee>employee=service.listarId(id);
        model.addAttribute("employee",employee);
        return "form";
    }
    @GetMapping("/save")
    public String save(@Validated Employee e, Model model){
        service.save(e);
        return "redirect:/listar";
    }
    @GetMapping("/eliminar/{id}")
    public String delete(Model model, @PathVariable int id){
        service.delete(id);
        return "redirect:/listar";
    }

}
