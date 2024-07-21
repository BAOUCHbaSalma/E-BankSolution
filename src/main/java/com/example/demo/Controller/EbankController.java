package com.example.demo.Controller;


import com.example.demo.Model.*;
import com.example.demo.Security.JwtAuth;
import com.example.demo.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")

public class EbankController {
   @Autowired
   private CompteService compteService;
    @Autowired
    private BeneficiaireService beneficiaireService;
    @Autowired
    private UserService userService;
    @Autowired
    private TransactionService transactionService;
    @Autowired
    private CarteBancaireService carteBancaireService;
    @Autowired
    AuthenticationManager authenticationManager;


     //===========>Ajouter user___________________________________________________________
    //************************************************************************************
    @PostMapping("/user")
    public void addUser(@RequestBody CompteRequest compteRequest){
        userService.addUser(compteRequest.getUser(), compteRequest.getTypeCompte(), compteRequest.getTypeCarte());

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
        return compteService.showAllCompteByIdUser(idUser);
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
        return compteService.ConsulterSoldeCompte(id);
    }
    //_________________________________________________________________________________________
    //*****************************************************************************************
    @PutMapping("/compte/{id}/status")
    public String closeCompte(@PathVariable Integer id,@RequestBody String statusF){
        return compteService.fermetureCompte(id,statusF);
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


    //=====>Afficher Details d'une carte___________________________________________________
    //****************************************************************************************
    @GetMapping("/carte/{idCarte}")
    public CarteBancaire showDetailsByIdCard(@PathVariable Integer idCarte){
        return carteBancaireService.showDetailsCard(idCarte);
    }
    //________________________________________________________________________________________
    //****************************************************************************************

    //=====>Afficher list des cartes id compte________________________________________________
    //****************************************************************************************
    @GetMapping("/cartes/{idCompte}")
    public List<CarteBancaire> showListCarteBancaire(@PathVariable Integer idCompte){
        return carteBancaireService.showListCarteByIdCompte(idCompte);
    }

    //________________________________________________________________________________________
    //****************************************************************************************


    //====>Changer status du carte bancaire_____________________________________________
    //***********************************************************************************
    @PostMapping("/carte/{idCarte}/status")
    public CarteBancaire updateStatusCarte(@PathVariable Integer idCarte,@RequestBody String status){
        return carteBancaireService.updateStatusCarteBancaire(idCarte,status);
    }

    //________________________________________________________________________________________
    //****************************************************************************************
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
            System.out.println("///////////////////"+user.getPassword()+"//////////////"+user.getUsername());
             authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
            );
            String token = JwtAuth.generateToken(user.getUsername());
        Map<String, String> response = new HashMap<>();
        response.put("token", token);
            return ResponseEntity.ok(response);

        }

 @GetMapping("/findB/{id}")
    public Beneficiaire findBeneficiaireById(@PathVariable Integer id){
        return beneficiaireService.recupaireById(id);

 }


 @GetMapping("/user/id")
    public  Integer findIdByUsername(@RequestParam String username){
    return userService.findIdByUsername(username);
    }
}


