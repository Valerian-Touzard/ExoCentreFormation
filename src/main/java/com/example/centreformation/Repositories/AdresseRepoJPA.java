package com.example.centreformation.Repositories;


import com.example.centreformation.Entities.Adresse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdresseRepoJPA extends JpaRepository<Adresse, Long> {
}
