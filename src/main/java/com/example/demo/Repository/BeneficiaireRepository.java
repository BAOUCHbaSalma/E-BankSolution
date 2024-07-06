package com.example.demo.Repository;

import com.example.demo.Model.Beneficiaire;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BeneficiaireRepository extends JpaRepository<Beneficiaire,Integer> {
//    void deleteByIdBeneficiaireAndCompte_IdCompte(Integer idCompte,Integer idBeneficiaire);
    List<Beneficiaire> findBeneficiaireByCompte_IdCompte(Integer id);
}
