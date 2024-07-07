package com.example.demo.Service;

import com.example.demo.Model.Beneficiaire;
import com.example.demo.Repository.BeneficiaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BeneficiaireService {

    @Autowired
    BeneficiaireRepository beneficiaireRepository;

    //====>Ajouter bénéficiaire a un compte ________________________________________________
    //**************************************************************************************
    public Beneficiaire addBeneficiaire(Beneficiaire beneficiaire){

        return beneficiaireRepository.save(beneficiaire);

    }
    //______________________________________________________________________________________
    //***************************************************************************************

    //====>Afficher tous les beneficiaires _________________________________________________
    //**************************************************************************************
    //public ArrayList<Beneficiaire> showAllBeneficiaire(){
    //
    //    return (ArrayList<Beneficiaire>) beneficiaireRepository.findAll();
    //
    //}
    //______________________________________________________________________________________
    //***************************************************************************************

    //=====>Afficher bénéficiaires d'un compte ______________________________________________
    //***************************************************************************************
    public List<Beneficiaire> showBeneficiaireByIdCompte(Integer id){

    return beneficiaireRepository.findBeneficiaireByCompte_IdCompte(id);

    }
    //______________________________________________________________________________________
    //***************************************************************************************

    //=====>Supprimer bénéficiaire d'un compte ______________________________________________
    //***************************************************************************************
    public void deleteBeneficiaire(Integer id){

        beneficiaireRepository.deleteById(id);
    }
    //______________________________________________________________________________________
    //***************************************************************************************

    //=====>Récuperer bénéficiaire by id ____________________________________________________
    //***************************************************************************************
    public Beneficiaire recupaireById(Integer id){

        return beneficiaireRepository.findById(id).orElseThrow();

    }
    //______________________________________________________________________________________
    //***************************************************************************************


    //======>Modifier informations d'un bénéficiaire _______________________________________
    //***************************************************************************************
    public Beneficiaire updateBeneficiaire(Integer id,Beneficiaire beneficiaire){

        Beneficiaire beneficiaire1= recupaireById(id);
        beneficiaire1.setNomBeneficiaire(beneficiaire.getNomBeneficiaire());
        beneficiaire1.setBanque(beneficiaire.getBanque());
        beneficiaire1.setNumeroCompte(beneficiaire.getNumeroCompte());
       return beneficiaireRepository.save(beneficiaire1);

    }
    //______________________________________________________________________________________
    //**************************************************************************************
}
