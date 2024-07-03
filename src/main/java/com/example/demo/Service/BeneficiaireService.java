package com.example.demo.Service;

import com.example.demo.Model.Beneficiaire;
import com.example.demo.Repository.BeneficiaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BeneficiaireService {
@Autowired
    BeneficiaireRepository beneficiaireRepository;

public Beneficiaire addBeneficiaire(Beneficiaire beneficiaire){
   return beneficiaireRepository.save(beneficiaire);
}

}
