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
    public Integer ConsulterSoldeCompte(Integer id){
        return compteR.findSoldeByIdCompte(id);
    }
    public Compte findCompteById(Integer id){
        return compteR.findById(id).orElseThrow();
    }
    public Compte fermetureCompte(Integer id,Compte compte){
        Compte compte1=findCompteById(id);
        compte1.setStatus(compte.getStatus());
        compte1.setRaisonFermeture(compte.getRaisonFermeture());
        return compteR.save(compte1);
    }

}
