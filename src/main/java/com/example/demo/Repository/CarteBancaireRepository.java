package com.example.demo.Repository;

import com.example.demo.Model.CarteBancaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarteBancaireRepository extends JpaRepository<CarteBancaire,Integer> {
}
