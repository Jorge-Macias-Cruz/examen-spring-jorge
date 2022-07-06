package com.examen.jorge.service;

import com.examen.jorge.model.Country;
import com.examen.jorge.model.Employee;

import java.util.List;

public interface ICountryService {
    public Country findById(Integer id);
    public List<Country> findAll();
    public void delete(Integer id);
    public Country update(Country country);
}
