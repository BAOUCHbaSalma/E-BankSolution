package com.example.demo.Service;

import com.example.demo.Model.Compte;
import com.example.demo.Model.Transaction;
import com.example.demo.Repository.CompteRepository;
import com.example.demo.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private CompteService compteSrv;

    // ========>Ajouter Transaction ____________________________________________________________
    // *****************************************************************************************
    public String addTransaction(Integer idCompte, Transaction transaction) {

        Compte compte = compteSrv.findCompteById(idCompte);

        if (transaction.getMontant() == 0) {
            return "Impossible de transférer ou poser ce montant";
        }

        if (("Transfert externe".equals(transaction.getTypeTransaction()) || "Transfert interne".equals(transaction.getTypeTransaction())) &&
                transaction.getMontant() > compte.getSolde()) {

            return "Impossible de transférer ce montant";
        }

        transaction.setDateTransaction(LocalDate.now());
        transaction.setHeursTransaction(LocalTime.now());
        transaction.setCompte(compte);

        if ("Transfert externe".equals(transaction.getTypeTransaction())) {
            transactionRepository.save(transaction);
            Double newSolde = compte.getSolde() - transaction.getMontant();
            compteSrv.updateSolde(idCompte, newSolde);
            return transaction.getMontant() + "Dh transféré avec succès à " + transaction.getBeneficiaire().getNomBeneficiaire();

        }

        else if ("Transfert interne".equals(transaction.getTypeTransaction())) {
            transaction.setBanque("Ebank");
            transactionRepository.save(transaction);
            Double newSolde = compte.getSolde() - transaction.getMontant();
            compteSrv.updateSolde(idCompte, newSolde);
            return transaction.getMontant() + "Dh transféré avec succès à " + compte.getUser().getNomUser();
        }

        else {
            transaction.setBanque("Ebank");
            transactionRepository.save(transaction);
            Double newSolde = compte.getSolde() + transaction.getMontant();
            compteSrv.updateSolde(idCompte, newSolde);
            return "Débit ajouté avec succès";
        }
    }
    //____________________________________________________________________________________________
    //********************************************************************************************


    //=======>Afficher transactions d'un compte __________________________________________________
    //********************************************************************************************
    public List<Transaction> showTransactionByIdCompte(Integer idCompte){

        return transactionRepository.findAllByCompte_IdCompte(idCompte);

    }
    //____________________________________________________________________________________________
    //********************************************************************************************
}
