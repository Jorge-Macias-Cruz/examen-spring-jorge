package com.examen.jorge.repository;

import com.examen.jorge.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryAirport extends JpaRepository<Airport, Integer> {
}
