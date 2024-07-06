package com.example.demo.Service;

import com.example.demo.Model.CarteBancaire;
import com.example.demo.Repository.CarteBancaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
