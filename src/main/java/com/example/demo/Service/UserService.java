package com.example.demo.Service;

import com.example.demo.Model.CarteBancaire;
import com.example.demo.Model.Compte;
import com.example.demo.Model.User;
import com.example.demo.Repository.CarteBancaireRepository;
import com.example.demo.Repository.CompteRepository;
import com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CarteBancaireRepository carteBancaireRepository;
    @Autowired
    private CompteRepository compteRepository;


   //=====>Générer un compte bancaire et une carte apres l'insertion d'un user _____________________
   //**********************************************************************************************
    public User addUser(User user, String typeCompte, String typeCarte){

        User user1=userRepository.save(user);
        //===>Générer un compte----------------------------
        Compte compte=new Compte();
        compte.setUser(user1);
        compte.setTypeCompte(typeCompte);
        compte.setSolde(0.0);
        compte.setDateCreation(LocalDate.now());
        compte.setStatus("Actif");
        compte.setNumeroCompte(generateAccountNumber());
        compte.setRaisonFermeture("aucune");
        Compte savedCompte = compteRepository.save(compte);
       //-----------------------------------------------------
        //===>Générer une carte bancaire-----------------------
        CarteBancaire carteBancaire = new CarteBancaire();
        carteBancaire.setNumero(generateCardNumber());
        carteBancaire.setStatus("Activer");
        carteBancaire.setTypeCarte(typeCarte);
        carteBancaire.setDateExpiration(LocalDate.now().plusYears(3));
        carteBancaire.setCompte(savedCompte);
        carteBancaireRepository.save(carteBancaire);
       //---------------------------------------------------------
        return user1;

    }
    //___________________________________________________________________________________________
    //*******************************************************************************************


    //====>Générer un numéro de compte unique ______________________________________________________
    //*********************************************************************************************
    private String generateAccountNumber() {

        String uuid = UUID.randomUUID().toString().replaceAll("[^0-9]", ""); // Supprime tous les caractères non numériques
        return uuid.substring(0, Math.min(uuid.length(), 10)); // Prend les 10 premiers chiffres ou moins si la longueur est inférieure à 10
    }
    //___________________________________________________________________________________________
    //*******************************************************************************************


    //====>Générer un numéro de carte bancaire unique _____________________________________________
    //********************************************************************************************
    private String generateCardNumber() {

        return UUID.randomUUID().toString().replace("-", "").substring(0, 16);

    }
    //_____________________________________________________________________________________________
    //*********************************************************************************************
}


