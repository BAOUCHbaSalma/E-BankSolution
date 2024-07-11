package com.example.demo.Service;

import com.example.demo.Model.CarteBancaire;
import com.example.demo.Model.Compte;
import com.example.demo.Repository.CarteBancaireRepository;
import com.example.demo.Repository.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CompteService {
    @Autowired
    CompteRepository compteR;
    @Autowired
    CarteBancaireRepository carteBancaireRepository;


    //======> Pour générer une carte apres l'ajout d'un compte__________________________________
    //********************************************************************************************
    //    public Compte addCompte(Compte compte, String typeCarte){
    //
    //        Compte cmpt=compteR.save(compte);
    //        System.out.print("//////////////"+ compte.getIdCompte()+"/////////////"+compte.getTypeCompte()+"////////////////"+compte.getDateCreation());
    //        CarteBancaire carteBancaire = new CarteBancaire();
    //        carteBancaire.setNumero(generateCardNumber());
    //        carteBancaire.setStatus("Activer");
    //        carteBancaire.setTypeCarte(typeCarte);
    //        carteBancaire.setDateExpiration(LocalDate.now().plusYears(3)); // Date d'expiration après 3 ans
    //        carteBancaire.setCompte(cmpt);
    //        carteBancaireRepository.save(carteBancaire);
    //        return cmpt;
    //    }
    //
    //________________________________________________________________________________________
    //****************************************************************************************


    //======>Pour Afficher tous les comptes d'un user_____________________________________
    //**************************************************************************************
    public List<Compte> showAllCompteByIdUser(Integer idUser){

        return compteR.findAllByUser_UserIdAndStatus(idUser,"actif");

    }
    //________________________________________________________________________________________
    //****************************************************************************************



    //======>Pour Afficher le solde d'un compte_______________________________________________
    //*****************************************************************************************
    public Double ConsulterSoldeCompte(Integer id){

        return compteR.findSoldeByIdCompte(id);

    }
    //_________________________________________________________________________________________
    //*****************************************************************************************


    //======>Pour Trouver un compte par id____________________________________________________
    //*****************************************************************************************
    public Compte findCompteById(Integer id){

        return compteR.findById(id).orElseThrow();

    }
    //_________________________________________________________________________________________
    //******************************************************************************************


    //======>Pour fermer un compte_____________________________________________________________
    //*****************************************************************************************
    public String fermetureCompte(Integer id,Compte compte){

        Compte compte1=findCompteById(id);
        if (compte1.getSolde()>=0) {
            compte1.setStatus("Fermer");
            compte1.setRaisonFermeture(compte.getRaisonFermeture());
            compteR.save(compte1);
            carteBancaireRepository.deleteAllByCompte_IdCompte(id);
            return "Compte fermé avec succès";
        }else {

            return  "Impossible de fermer ce compte a cause de votre solde";

        }

    }
    //_________________________________________________________________________________________
    //******************************************************************************************


    //======>Pour generer un string___________________________________________________________
    //****************************************************************************************
    private String generateCardNumber() {

        return UUID.randomUUID().toString().replace("-", "").substring(0, 16);
    }
    //_________________________________________________________________________________________
    //*****************************************************************************************


    //=====>Update Solde By id Compte__________________________________________________________
    //*****************************************************************************************
    public Compte updateSolde(Integer idCompte,Double solde){

        Compte compte=findCompteById(idCompte);
        compte.setSolde(solde);
         return compteR.save(compte);

    }
    //_________________________________________________________________________________________
    //******************************************************************************************
}
