package com.example.demo.Repository;

import com.example.demo.Model.Beneficiaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeneficiaireRepository extends JpaRepository<Beneficiaire,Integer> {
}
