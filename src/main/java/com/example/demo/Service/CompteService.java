package com.example.demo.Service;

import com.example.demo.Model.CarteBancaire;
import com.example.demo.Model.Compte;
import com.example.demo.Repository.CarteBancaireRepository;
import com.example.demo.Repository.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

@Service
public class CompteService {
    @Autowired
    CompteRepository compteR;
    @Autowired
    CarteBancaireRepository carteBancaireRepository;
    public Compte addCompte(Compte compte, String typeCarte){
        Compte cmpt=compteR.save(compte);
        System.out.print("//////////////"+ compte.getIdCompte()+"/////////////"+compte.getTypeCompte()+"////////////////"+compte.getDateCreation());
        CarteBancaire carteBancaire = new CarteBancaire();
        carteBancaire.setNumero(generateCardNumber());
        carteBancaire.setStatus("Activer");
        carteBancaire.setTypeCarte(typeCarte);
        carteBancaire.setDateExpiration(LocalDate.now().plusYears(3)); // Date d'expiration après 3 ans
        carteBancaire.setCompte(cmpt);
        carteBancaireRepository.save(carteBancaire);
        return cmpt;
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
        compte1.setStatus("Fermer");
        compte1.setRaisonFermeture(compte.getRaisonFermeture());
        return compteR.save(compte1);
    }
    private String generateCardNumber() {
        return UUID.randomUUID().toString().replace("-", "").substring(0, 16);
    }

}
