package com.examen.jorge.interfaces;

import com.examen.jorge.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployee extends CrudRepository <Employee, Integer>{
}
