package com.example.demo.Repository;

import com.example.demo.Model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction,Integer> {

    //====>Afficher transaction By IdCompte________________________________________
    //*****************************************************************************
    List<Transaction> findAllByCompte_IdCompte(Integer idCompte);
    //_____________________________________________________________________________
    //*****************************************************************************
}
