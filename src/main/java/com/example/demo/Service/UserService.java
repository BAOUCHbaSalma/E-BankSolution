package com.example.demo.Service;

import com.example.demo.Model.CarteBancaire;
import com.example.demo.Model.Compte;
import com.example.demo.Model.User;
import com.example.demo.Repository.CarteBancaireRepository;
import com.example.demo.Repository.CompteRepository;
import com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
   private CarteBancaireRepository carteBancaireRepository;
    @Autowired
  private CompteRepository compteRepository;

    public User addUser(User user, String typeCompte, String typeCarte){
        User user1=userRepository.save(user);
        //Générer un compte
        Compte compte=new Compte();
        compte.setUser(user1);
        compte.setTypeCompte(typeCompte);
        compte.setSolde(0);
        compte.setDateCreation(LocalDate.now());
        compte.setStatus("active");
        compte.setNumeroCompte(generateAccountNumber());
        compte.setRaisonFermeture("aucune");
        Compte savedCompte = compteRepository.save(compte);

        // Générer une carte bancaire
        CarteBancaire carteBancaire = new CarteBancaire();
        carteBancaire.setNumero(generateCardNumber());
        carteBancaire.setStatus("Activer");
        carteBancaire.setTypeCarte(typeCarte);
        carteBancaire.setDateExpiration(LocalDate.now().plusYears(3));
        carteBancaire.setCompte(savedCompte);
        carteBancaireRepository.save(carteBancaire);

        return user1;



    }

    // Générer un numéro de compte unique

    private String generateAccountNumber() {
        return UUID.randomUUID().toString().replace("-", "").substring(0, 10);
    }

    // Générer un numéro de carte bancaire unique
    private String generateCardNumber() {
        return UUID.randomUUID().toString().replace("-", "").substring(0, 16);
    }
}
