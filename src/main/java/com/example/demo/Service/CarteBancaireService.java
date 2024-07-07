package com.example.demo.Service;

import com.example.demo.Model.CarteBancaire;
import com.example.demo.Repository.CarteBancaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarteBancaireService {

    @Autowired
    CarteBancaireRepository carteBancaireRepository;

    //====>Afficher les details d'une carte______________________________________________
    //***********************************************************************************
    public CarteBancaire showDetailsCard(Integer idCarte){

        return carteBancaireRepository.findById(idCarte).orElseThrow();

    }
    //____________________________________________________________________________________
    //*************************************************************************************


    //====>Afficher la liste des cartes by id compte_____________________________________
    //***********************************************************************************
    public List<CarteBancaire> showListCarteByIdCompte(Integer idCompte){

        return carteBancaireRepository.findAllByCompte_IdCompte(idCompte);
    }
    //____________________________________________________________________________________
    //*************************************************************************************



    //====>Changer status du carte bancaire_____________________________________________
    //***********************************************************************************
     public CarteBancaire updateStatusCarteBancaire(Integer idCarte,String status){

       CarteBancaire carteBancaire= carteBancaireRepository.findById(idCarte).orElseThrow();
       carteBancaire.setStatus(status);
       return carteBancaireRepository.save(carteBancaire);

     }
    //____________________________________________________________________________________
    //*************************************************************************************


}
