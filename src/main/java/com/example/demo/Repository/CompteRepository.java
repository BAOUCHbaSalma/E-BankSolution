package com.example.demo.Repository;

import com.example.demo.Model.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompteRepository extends JpaRepository<Compte,Integer> {

    //====>Afficher Solde par idCompte____________________________________________
    //****************************************************************************
    @Query("SELECT c.solde FROM Compte c WHERE c.idCompte= :id")
    Double findSoldeByIdCompte(@Param("id") Integer id);
    //____________________________________________________________________________
    //*****************************************************************************


    //=======>Afficher Comptes par IdUser_________________________________________
    //****************************************************************************
    List<Compte> findAllByUser_IdUsserAndStatus(Integer userId, String status);

    //____________________________________________________________________________
    //****************************************************************************

}
