package com.example.centreformation.Repositories;

import com.example.centreformation.Entities.Formateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormateurRepoJPA extends JpaRepository<Formateur, Long> {
}
