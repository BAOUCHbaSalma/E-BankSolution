package com.example.demo.Service;

import com.example.demo.Model.Beneficiaire;
import com.example.demo.Repository.BeneficiaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class BeneficiaireService {
@Autowired
    BeneficiaireRepository beneficiaireRepository;

public Beneficiaire addBeneficiaire(Beneficiaire beneficiaire){
   return beneficiaireRepository.save(beneficiaire);
}
public ArrayList<Beneficiaire> showAllBeneficiaire(){
    return (ArrayList<Beneficiaire>) beneficiaireRepository.findAll();
}
public void deleteBeneficiaire(Integer id){
    beneficiaireRepository.deleteById(id);
}
public Beneficiaire recupaireById(Integer id){
    return beneficiaireRepository.findById(id).orElseThrow();
}
public Beneficiaire updateBeneficiaire(Integer id,Beneficiaire beneficiaire){
    Beneficiaire beneficiaire1= recupaireById(id);
    beneficiaire1.setNomBeneficiaire(beneficiaire.getNomBeneficiaire());
    beneficiaire1.setBanque(beneficiaire.getBanque());
    beneficiaire1.setNumeroCompte(beneficiaire.getNumeroCompte());
   return beneficiaireRepository.save(beneficiaire1);
}
}
