package com.example.demo;

import com.example.demo.Model.*;
import com.example.demo.Service.*;
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
	@Autowired
	private BeneficiaireService beneficiaireService;
	@Autowired
	private TransactionService transactionService;

//=============>Ajouter user avec la generation automatique du compte et carte ______________________________________________________________________________
	//*******************************************************************************************************************************************************
@Test
	public void addCompteTest() {

//	User user = new User("Wissal",23,"WA13245","F");
//	User user1=userService.addUser(user,"Courant","Débit");

  //Tester user

//	assertNotNull(user1.getIdUsser());
//	assertEquals("Wissal",user1.getNomUser());
//	assertEquals(23,user1.getAgeUser());
//	assertEquals("WA13245",user1.getCin());
//	assertEquals("F",user1.getGenre());

    //Tester compte

//	List<Compte> compte =compteService.showAllCompteByIdUser(user1.getIdUsser());
//	assertNotNull(compte);
//	assertNotNull(compte.get(0).getIdCompte());
//	assertNotNull(compte.get(0).getNumeroCompte());
//	assertEquals("Courant", compte.get(0).getTypeCompte());
//	assertEquals("Actif", compte.get(0).getStatus());
//	assertEquals("aucune", compte.get(0).getRaisonFermeture());
//	assertEquals(0.0,compte.get(0).getSolde());
//	assertEquals(LocalDate.now(),compte.get(0).getDateCreation());

    //Tester carte

//	List<CarteBancaire> carteBancaire=carteBancaireService.showListCarteByIdCompte(compte.get(0).getIdCompte());
//	assertNotNull(carteBancaire);
//	assertNotNull(carteBancaire.get(0).getIdCarte());
//	assertNotNull(carteBancaire.get(0).getNumero());
//	assertEquals(LocalDate.now().plusYears(3),carteBancaire.get(0).getDateExpiration());
//	assertEquals("Débit",carteBancaire.get(0).getTypeCarte());

	}
//_____________________________________________________________________________________________________________________________________________________________
	//*********************************************************************************************************************************************************


//=========>Tester la methode add transaction___________________________________________________________________________________________________________________
	//**********************************************************************************************************************************************************
	@Test
	void addTransactionTest() {

       //Montant 0

//	    Compte compte=compteService.findCompteById(23);
//		Beneficiaire beneficiaire=beneficiaireService.recupaireById(12);
		//		Transaction transaction=new Transaction(LocalDate.now(),LocalTime.now(),0,"Transfert interne","Achat","",beneficiaire,compte);
		//		String transactionResponse=transactionService.addTransaction(23,transaction);
		//        assertEquals("Impossible de transférer ou poser ce montant",transactionResponse);


       //Montant>Solde


		//		Transaction transaction2=new Transaction(LocalDate.now(),LocalTime.now(),1000,"Transfert interne","Achat","",beneficiaire,compte);
		//		String transactionResponse2=transactionService.addTransaction(23,transaction2);
		//		assertEquals("Impossible de transférer ce montant",transactionResponse2);


        //Transfert interne


//				Transaction transaction3=new Transaction(LocalDate.now(),LocalTime.now(),1000,"Transfert interne","Achat","",beneficiaire,compte);
//				String transactionResponse3=transactionService.addTransaction(23,transaction3);
//				assertEquals(1000 + "Dh transféré avec succès à "+ "BAOUCH SALMA",transactionResponse3);



		//Transfert externe

//		        Beneficiaire beneficiaire2=beneficiaireService.recupaireById(10);
//		        Transaction transaction4=new Transaction(LocalDate.now(),LocalTime.now(),1000,"Transfert externe","Achat","CHAABI",beneficiaire2,compte);
//				String transactionResponse4=transactionService.addTransaction(23,transaction4);
//				assertEquals( 1000+ "Dh transféré avec succès à " + "DOUAA BAOUCH",transactionResponse4);


         //Débit

//		Transaction transaction5=new Transaction(LocalDate.now(),LocalTime.now(),1000,"Débit","debit de 1000 dh","",beneficiaire,compte);
//		String transactionResponse5=transactionService.addTransaction(23,transaction5);
//        assertEquals( "Débit ajouté avec succès",transactionResponse5);
	}
//_______________________________________________________________________________________________________________________________________________________________________
	//*******************************************************************************************************************************************************************

}