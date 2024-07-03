package com.example.demo.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class carteBancaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCarte;
    @Column
    private Integer numero;
    @Column
    private LocalDate dateExpiration;
    @Column
    private String typeCarte;
    @Column
    private String status;
    @ManyToOne
    @JoinColumn(name = "idCompte")
    private Compte compte;
}
