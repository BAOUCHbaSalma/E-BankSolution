package com.example.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompteRequest {

    //    private Compte compte;
    private User user;
    private String typeCarte;
    private String typeCompte;

}
