package com.example.demo.Repository;

import com.example.demo.Model.CarteBancaire;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarteBancaireRepository extends JpaRepository<CarteBancaire,Integer> {

    List<CarteBancaire> findAllByCompte_IdCompte(Integer idCompte);
    void deleteAllByCompte_IdCompte(Integer idCompte);
}
