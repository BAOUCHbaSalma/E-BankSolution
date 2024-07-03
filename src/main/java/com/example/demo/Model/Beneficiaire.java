package com.example.demo.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Beneficiaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBeneficiaire;
    @Column
    private String nomBeneficiaire;
    @Column
    private String banque;
    @Column
    private  Integer numeroCompte;
    @ManyToOne
    @JoinColumn(name = "idCompte")
    private Compte compte;
}
