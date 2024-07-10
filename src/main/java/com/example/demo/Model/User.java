package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jdk.jfr.Name;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsser;
    @Column(name = "username")
    private String nomUser;
    @Column
    private Integer ageUser;
    @Column(name = "password")
    private String motDePasse;
    @Column
    private String confirmationMDP;
    @Column
    private String cin;
    @Column
    private String genre;
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Compte> listeCompte;

    public User(String nomUser, Integer ageUser, String cin, String genre,String motDePasse,String confirmationMDP) {
        this.nomUser = nomUser;
        this.ageUser = ageUser;
        this.cin = cin;
        this.genre = genre;
        this.motDePasse=motDePasse;
        this.confirmationMDP=confirmationMDP;
    }

}
