package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "compte")
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_compte")
    private Integer idCompte;
    @Column
    private String typeCompte;
    @Column
    private Integer solde;
    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateCreation;
    @Column
    private String status;
    @Column
    private Integer numeroCompte;
    @Column
    private String raisonFermeture;

    @OneToMany(mappedBy = "compte")
    @JsonIgnore
    private List<Beneficiaire> listOfBeneficiaire;
    @ManyToOne
    @JoinColumn(name = "idUsser")
    private User user;
    @OneToMany(mappedBy = "compte")
    @JsonIgnore
    private List<carteBancaire> listOfCarteBancaires;
    @OneToMany(mappedBy = "compte")
    @JsonIgnore
    private List<Transaction> listOfTransaction;


    public Compte( LocalDate dateCreation, Integer numeroCompte, Integer solde, String status, String typeCompte, User user) {
        this.typeCompte = typeCompte;
        this.solde = solde;
        this.dateCreation = dateCreation;
        this.status = status;
        this.numeroCompte = numeroCompte;
        this.user=user;
    }


}
