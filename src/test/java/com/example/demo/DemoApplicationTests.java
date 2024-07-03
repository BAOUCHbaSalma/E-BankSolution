package com.example.demo;

import com.example.demo.Model.Compte;
import com.example.demo.Service.CompteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class DemoApplicationTests {
	@Autowired
	private CompteService compteService;
@Test
	public void addCompteTest() {
		Compte compte = new Compte(LocalDate.now(), 123456, 1000, "active", "courant", 1);
		Compte savedCompte = compteService.addCompte(compte);

		assertNotNull(savedCompte.getIdCompte());

	  assertEquals("courant", savedCompte.getTypeCompte());
	  assertEquals(1000, savedCompte.getSolde());
	  assertEquals("active", savedCompte.getStatus());
	   assertEquals(123456, savedCompte.getNumeroCompte());

	}
	@Test
	void Somme() {
		Integer a=5;
		Integer b=1;

		assertEquals(6,a+b);

	}

}