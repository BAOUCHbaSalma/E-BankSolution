package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
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
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsser;
    @Column
    private String nomUser;
    @Column
    private Integer ageUser;
    @Column
    private String cin;
    @Column
    private String genre;
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Compte> listeCompte;

}
