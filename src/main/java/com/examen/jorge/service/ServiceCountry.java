package com.examen.jorge.service;

import com.examen.jorge.model.Country;
import com.examen.jorge.model.Employee;
import com.examen.jorge.repository.RepositoryCountry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceCountry implements ICountryService{

    @Autowired
    private RepositoryCountry repositoryCountry;

    public Country findById(Integer id){       //FINDBYID
        Optional<Country> countryBD = this.repositoryCountry.findById(id);
        if(countryBD.isPresent()){
            return countryBD.get();
        }else{
            throw new RuntimeException("Error al encontrar el Id: " + id);
        }
    }
    @Override
    public List<Country> findAll() {           //FINDALL
        return (List<Country>) this.repositoryCountry.findAll();
    }

    @Override
    public void delete(Integer id) {               //DELETE
        Optional<Country> countryDB = this.repositoryCountry.findById(id);
        if(countryDB.isPresent()){
            this.repositoryCountry.delete(countryDB.get());
        }else{
            throw new RuntimeException("Error al encontrar el Id: " + id);
        }
    }
    @Override
    public Country update(Country country) {         //UPDATE
        Optional<Country> countryDB = this.repositoryCountry.findById(country.getId());
        if(countryDB.isPresent()){
            Country countryUpdate = countryDB.get();
            countryUpdate.setId(country.getId());
            countryUpdate.setName(country.getName());
            countryUpdate.setCode(country.getCode());
            repositoryCountry.save(countryUpdate);
            return countryUpdate;
        }else{
            throw new RuntimeException("Error al encontrar el Id:" + country.getId());
        }
    }
}
