package com.example.demo.Controller;


import com.example.demo.Model.*;
import com.example.demo.Service.BeneficiaireService;
import com.example.demo.Service.CompteService;
import com.example.demo.Service.TransactionService;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@RestController
public class EbankController {
    @Autowired
       private CompteService compteSrv;
    @Autowired
    private BeneficiaireService beneficiaireService;
    @Autowired
    private UserService userService;
    @Autowired
    private TransactionService transactionService;


     //===========>Ajouter user___________________________________________________________
    //************************************************************************************
    @PostMapping("/user")
    public User addUser(@RequestBody CompteRequest compteRequest){
        return  userService.addUser(compteRequest.getUser(), compteRequest.getTypeCompte(), compteRequest.getTypeCarte());
    }
     //_____________________________________________________________________________________
    //*************************************************************************************

     //==========>Ajouter compte____________________________________________________________
    //**************************************************************************************

    //    @PostMapping("/compte")
    //    public Compte addCompte(@RequestBody CompteRequest compteRequest) {
    //        System.out.println("///////////////"+compteRequest.getCompte().getUser().getIdUsser());
    //        System.out.println("///////////////"+compteRequest.getCompte().getTypeCompte());
    //        return compteSrv.addCompte(compteRequest.getCompte(), compteRequest.getTypeCarte());
    //
    //    }

    //_______________________________________________________________________________________
    //***************************************************************************************
    //=======>Afficher les comptes d'un user_________________________________________________
    //***************************************************************************************
    @GetMapping("/comptes/{idUser}")
    public List<Compte> showComptes(@PathVariable Integer idUser){
        return compteSrv.showAllCompteByIdUser(idUser);
    }
    //______________________________________________________________________________________
    //**************************************************************************************

    //==========> Ajouter beneficiaire __________________________________________________
    //***********************************************************************************
    @PostMapping("/beneficiaire")
    public Beneficiaire addBeneficiaire(@RequestBody Beneficiaire beneficiaire){
        return beneficiaireService.addBeneficiaire(beneficiaire);
    }
    //***********************************************************************************
    //___________________________________________________________________________________

    //===========>Show beneficiaires_______________________________________________________
    //*************************************************************************************
    @GetMapping("/beneficiaires/{idCompte}")
    public List<Beneficiaire> showBeneficiaire(@PathVariable Integer idCompte){

        return beneficiaireService.showBeneficiaireByIdCompte(idCompte);
    }
    //________________________________________________________________________________________
    //****************************************************************************************

    //==========>Delete beneficiaire__________________________________________________________
    //****************************************************************************************
    @DeleteMapping("/beneficiaire/{id}")
    public void deleteBeneficiaire(@PathVariable Integer id){
        beneficiaireService.deleteBeneficiaire(id);
    }
    //_________________________________________________________________________________________
    //******************************************************************************************

    //=======>Update beneficiaire_____________________________________________________________
    //****************************************************************************************
    @PutMapping("/beneficiaire/{id}")
    public Beneficiaire updateBeneficiaire(@PathVariable Integer id,@RequestBody Beneficiaire beneficiaire){
       return beneficiaireService.updateBeneficiaire(id,beneficiaire);
    }
    //_________________________________________________________________________________________
    //****************************************************************************************

    //=========>Afficher Solde d'un compte_____________________________________________________
    //*****************************************************************************************
    @GetMapping("/compte/{id}/solde")
    public Integer findSoldeByIdCompte(@PathVariable Integer id){
        return compteSrv.ConsulterSoldeCompte(id);
    }
    //_________________________________________________________________________________________
    //*****************************************************************************************
    @PutMapping("/compte/{id}/status")
    public String closeCompte(@PathVariable Integer id,@RequestBody Compte compte){
      Compte compte1=compteSrv.findCompteById(id);
      if (compte1.getSolde()>=0){

          compteSrv.fermetureCompte(id,compte);
          return "Compte fermé avec succès";

      }else {

         return  "Impossible de fermer ce compte a cause de votre solde";

      }


    }
    //________________________________________________________________________________________
    //****************************************************************************************
@PostMapping("/transaction/{idCompte}")
    public String addTransaction(@PathVariable Integer idCompte,@RequestBody Transaction transaction){

       Compte compte = compteSrv.findCompteById(idCompte);
        if ("Transfert externe".equals(transaction.getTypeTransaction()) &&
        transaction.getMontant() > compte.getSolde()){

        return "Impossible de transférer ce montant";

        }else if("Transfert externe".equals(transaction.getTypeTransaction()) &&
         transaction.getMontant() <= compte.getSolde()){
         transaction.setDateTransaction(LocalDate.now());
         transaction.setHeursTransaction(LocalTime.now());
         transaction.setCompte(compte);
          transactionService.addTransaction(transaction);
          Integer solde=compte.getSolde()-transaction.getMontant();
          compteSrv.updateSolde(idCompte,solde);
          return transaction.getMontant() + "Dh transféré avec succès à " + transaction.getBeneficiaire().getNomBeneficiaire();

        } else if("Transfert interne".equals(transaction.getTypeTransaction()) &&
          transaction.getMontant() <= compte.getSolde()){

            Compte compte1=compteSrv.findCompteById(idCompte);
            transaction.setDateTransaction(LocalDate.now());
            transaction.setBanque("Ebank");
            transaction.setHeursTransaction(LocalTime.now());
            transaction.setCompte(compte);
            transactionService.addTransaction(transaction);
            Integer solde=compte.getSolde()-transaction.getMontant();
            compteSrv.updateSolde(idCompte,solde);
            return transaction.getMontant() + "Dh transféré avec succès à "+compte1.getUser().getNomUser();

        } else if("Transfert interne".equals(transaction.getTypeTransaction()) &&
          transaction.getMontant() > compte.getSolde()){

            return "Impossible de transférer ce montant";

        }
        else{
            transaction.setDateTransaction(LocalDate.now());
            transaction.setBanque("Ebank");
            transaction.setHeursTransaction(LocalTime.now());
            transaction.setCompte(compte);
            Integer solde=compte.getSolde()+transaction.getMontant();
            compteSrv.updateSolde(idCompte,solde);
            transactionService.addTransaction(transaction);
            return "Débit ajouté avec succès";
        }


}

}

