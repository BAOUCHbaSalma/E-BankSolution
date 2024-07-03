package com.example.demo.Service;

import com.example.demo.Model.Compte;
import com.example.demo.Repository.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CompteService {
    @Autowired
    CompteRepository compteR;
    public Compte addCompte(Compte compte){
        System.out.print("//////////////"+ compte.getIdCompte()+"/////////////"+compte.getTypeCompte()+"////////////////"+compte.getDateCreation());
        return compteR.save(compte);
    }
    public ArrayList<Compte>showAllCompte(){
        return (ArrayList<Compte>) compteR.findAll();
    }

}
