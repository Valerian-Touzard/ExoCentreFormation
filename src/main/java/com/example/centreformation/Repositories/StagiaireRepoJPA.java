package com.example.centreformation.Repositories;

import com.example.centreformation.Entities.Stagiaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StagiaireRepoJPA extends JpaRepository<Stagiaire, Long> {
}
