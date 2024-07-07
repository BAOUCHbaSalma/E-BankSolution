package com.example.demo.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTransaction;
    @Column
    private LocalDate dateTransaction;
    @Column
    private LocalTime heursTransaction;
    @Column
    private Integer montant;
    @Column
    private String typeTransaction;
    @Column
    private String descriptionTransaction;
    @Column
    private String banque;
    @ManyToOne
    @JoinColumn(name = "idBeneficiaire")
    private Beneficiaire beneficiaire;
    @ManyToOne
    @JoinColumn(name = "idCompte")
    private Compte compte;

    public Transaction(LocalDate dateTransaction, LocalTime heursTransaction, Integer montant, String typeTransaction, String descriptionTransaction, String banque, Beneficiaire beneficiaire, Compte compte) {
        this.dateTransaction = dateTransaction;
        this.heursTransaction = heursTransaction;
        this.montant = montant;
        this.typeTransaction = typeTransaction;
        this.descriptionTransaction = descriptionTransaction;
        this.banque = banque;
        this.beneficiaire = beneficiaire;
        this.compte = compte;
    }
}
