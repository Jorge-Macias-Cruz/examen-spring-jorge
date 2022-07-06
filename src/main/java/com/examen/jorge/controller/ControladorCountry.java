package com.examen.jorge.controller;

import com.examen.jorge.model.Country;
import com.examen.jorge.service.ServiceCountry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/country")
public class ControladorCountry {
    @Autowired
    private ServiceCountry serviceCountry;

    @GetMapping("/countryDetails/{id}")
    public ResponseEntity<Country> findProductById(@PathVariable int id){
        return ResponseEntity.ok().body(serviceCountry.findById(id));
    }

    @GetMapping("/countryList")
    public ResponseEntity<?> findAll(){
        List<Country> lista = serviceCountry.findAll();
        if (lista.isEmpty()){
            return new ResponseEntity<>("Sin datos.", HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok().body(serviceCountry.findAll());
    }

    @DeleteMapping("countryDelete/{id}")
    public HttpStatus deleteCountry(@PathVariable int id){
        this.serviceCountry.delete(id);
        return HttpStatus.OK;
    }

    @PutMapping("/countryUpdate/{id}")
    public ResponseEntity<Country> update(@PathVariable int id, @RequestBody Country country){
        country.setId(id);
        return ResponseEntity.ok().body(this.serviceCountry.update(country));
    }
}
