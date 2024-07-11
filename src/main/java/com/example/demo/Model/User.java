package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jdk.jfr.Name;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "users")
public class User implements UserDetails {

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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
