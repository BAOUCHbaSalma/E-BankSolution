package com.example.demo.Repository;

import com.example.demo.Model.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CompteRepository extends JpaRepository<Compte,Integer> {
    @Query("SELECT c.solde FROM Compte c WHERE c.idCompte= :id")
    Integer findSoldeByIdCompte(@Param("id") Integer id);
}
