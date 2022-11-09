package com.example.centreformation.Repositories;

import com.example.centreformation.Entities.Matiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatiereRepoJPA extends JpaRepository<Matiere, Long> {
}
