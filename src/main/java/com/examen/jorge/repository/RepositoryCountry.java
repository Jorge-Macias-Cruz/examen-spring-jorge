package com.examen.jorge.repository;

import com.examen.jorge.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryCountry extends JpaRepository<Country, Integer> {
}
