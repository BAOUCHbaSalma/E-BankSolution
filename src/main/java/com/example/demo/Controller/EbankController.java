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
    public Double findSoldeByIdCompte(@PathVariable Integer id){
        return compteSrv.ConsulterSoldeCompte(id);
    }
    //_________________________________________________________________________________________
    //*****************************************************************************************
    @PutMapping("/compte/{id}/status")
    public String closeCompte(@PathVariable Integer id,@RequestBody Compte compte){
        return compteSrv.fermetureCompte(id,compte);
    }
    //________________________________________________________________________________________
    //****************************************************************************************

    //=====>Ajouter Transaction d'un compte___________________________________________________
    //****************************************************************************************
    @PostMapping("/transaction/{idCompte}")
     public String addTransaction(@PathVariable Integer idCompte,@RequestBody Transaction transaction){
       return transactionService.addTransaction(idCompte,transaction);
    }
    //________________________________________________________________________________________
    //****************************************************************************************

    
    //=====>Afficher Transactions d'un compte___________________________________________________
    //****************************************************************************************
    @GetMapping("/transactions/{idCompte}")
    public List<Transaction> showAllTransactionByIdCompte(@PathVariable Integer idCompte){
        return transactionService.showTransactionByIdCompte(idCompte);
    }
    //________________________________________________________________________________________
    //****************************************************************************************

}

