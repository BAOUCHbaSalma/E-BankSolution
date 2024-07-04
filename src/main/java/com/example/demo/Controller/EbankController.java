package com.example.demo.Controller;


import com.example.demo.Model.Beneficiaire;
import com.example.demo.Model.Compte;
import com.example.demo.Service.BeneficiaireService;
import com.example.demo.Service.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class EbankController {
    @Autowired
       private CompteService compteSrv;
    @Autowired
    private BeneficiaireService beneficiaireService;

    @PostMapping("/compte")
    public Compte addCompte(@RequestBody Compte compte){
      return compteSrv.addCompte(compte);
    }

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

