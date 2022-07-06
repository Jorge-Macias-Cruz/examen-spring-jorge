package com.examen.jorge.repository;

import com.examen.jorge.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryLanguage extends JpaRepository<Language, Integer> {
}
