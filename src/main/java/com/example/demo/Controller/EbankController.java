package com.example.demo.Controller;


import com.example.demo.Model.Beneficiaire;
import com.example.demo.Model.Compte;
import com.example.demo.Model.CompteRequest;
import com.example.demo.Model.User;
import com.example.demo.Service.BeneficiaireService;
import com.example.demo.Service.CompteService;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class EbankController {
    @Autowired
       private CompteService compteSrv;
    @Autowired
    private BeneficiaireService beneficiaireService;
    @Autowired
    private UserService userService;


    @PostMapping("/user")
    public User addUser(@RequestBody CompteRequest compteRequest){
        return  userService.addUser(compteRequest.getUser(), compteRequest.getTypeCompte(), compteRequest.getTypeCarte());
    }


//    @PostMapping("/compte")
//    public Compte addCompte(@RequestBody CompteRequest compteRequest) {
//        System.out.println("///////////////"+compteRequest.getCompte().getUser().getIdUsser());
//        System.out.println("///////////////"+compteRequest.getCompte().getTypeCompte());
//        return compteSrv.addCompte(compteRequest.getCompte(), compteRequest.getTypeCarte());
//
//    }

    @GetMapping("/comptes")
    public ArrayList<Compte> showComptes(){
        return compteSrv.showAllCompte();
    }

    @PostMapping("/beneficiaire")
    public Beneficiaire addBeneficiaire(@RequestBody Beneficiaire beneficiaire){
        return beneficiaireService.addBeneficiaire(beneficiaire);
    }
    @GetMapping("/beneficiaires")
    public ArrayList<Beneficiaire> showBeneficiaire(){
        return beneficiaireService.showAllBeneficiaire();
    }
    @DeleteMapping("/beneficiaire/{id}")
    public void deleteBeneficiaire(@PathVariable Integer id){
        beneficiaireService.deleteBeneficiaire(id);
    }
    @PutMapping("/beneficiaire/{id}")
    public Beneficiaire updateBeneficiaire(@PathVariable Integer id,@RequestBody Beneficiaire beneficiaire){
       return beneficiaireService.updateBeneficiaire(id,beneficiaire);
    }
    @GetMapping("/compte/{id}/solde")
    public Integer findSoldeByIdCompte(@PathVariable Integer id){
        return compteSrv.ConsulterSoldeCompte(id);
    }
    @PutMapping("/compte/{id}/status")
    public Compte closeCompte(@PathVariable Integer id,@RequestBody Compte compte){
        return compteSrv.fermetureCompte(id,compte);

    }


}

