package com.example.demo;

import com.example.demo.Model.CarteBancaire;
import com.example.demo.Model.Compte;
import com.example.demo.Model.CompteRequest;
import com.example.demo.Model.User;
import com.example.demo.Service.CarteBancaireService;
import com.example.demo.Service.CompteService;
import com.example.demo.Service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class DemoApplicationTests {
	@Autowired
	private CompteService compteService;
	@Autowired
	private UserService userService;
	@Autowired
	private CarteBancaireService carteBancaireService;
@Test
	public void addCompteTest() {

	User user = new User("Wissal",23,"WA13245","F");
	User user1=userService.addUser(user,"Courant","Débit");

	assertNotNull(user1.getIdUsser());
	assertEquals("Wissal",user1.getNomUser());
	assertEquals(23,user1.getAgeUser());
	assertEquals("WA13245",user1.getCin());
	assertEquals("F",user1.getGenre());

	List<Compte> compte =compteService.showAllCompteByIdUser(user1.getIdUsser());
	assertNotNull(compte);
	assertNotNull(compte.get(0).getIdCompte());
	assertNotNull(compte.get(0).getNumeroCompte());
	assertEquals("Courant", compte.get(0).getTypeCompte());
	assertEquals("Actif", compte.get(0).getStatus());
	assertEquals("aucune", compte.get(0).getRaisonFermeture());
	assertEquals(0.0,compte.get(0).getSolde());
	assertEquals(LocalDate.now(),compte.get(0).getDateCreation());

	List<CarteBancaire> carteBancaire=carteBancaireService.showListCarteByIdCompte(compte.get(0).getIdCompte());
	assertNotNull(carteBancaire);
	assertNotNull(carteBancaire.get(0).getIdCarte());
	assertNotNull(carteBancaire.get(0).getNumero());
	assertEquals(LocalDate.now().plusYears(3),carteBancaire.get(0).getDateExpiration());
	assertEquals("Débit",carteBancaire.get(0).getTypeCarte());
	

	}
	@Test
	void Somme() {
		Integer a=5;
		Integer b=1;

		assertEquals(6,a+b);

	}

}