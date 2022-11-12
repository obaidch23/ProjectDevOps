package com.esprit.examen.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.esprit.examen.entities.Facture;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class FactureServiceImplTest {

	@Autowired
	IFactureService factureService;
	
	
	@Test
	@Order(1)
	public void testAddFacture() throws ParseException{
		float montantFacture = (float) 50.5;
		float montantRemise = (float) 100.5;
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date dateCreationFacture = dateFormat.parse("30/01/2022");
		Date dateDerniereModificationFacture = dateFormat.parse("30/07/2022");
		List<Facture> factures = factureService.retrieveAllFactures();
			int expected=factures.size();
			Facture f = new Facture(null, montantFacture,montantRemise,dateCreationFacture,dateDerniereModificationFacture,true, null, null, null);
			Facture savedFacture= factureService.addFacture(f);
			assertEquals(expected+1, factureService.retrieveAllFactures().size());
			factureService.cancelFacture(savedFacture.getIdFacture());
	}
	
	
	@Test
	@Order(2)
	public void testRetrieveFacture() throws ParseException {
		float montantFacture = (float) 60.5;
		float montantRemise = (float) 200.5;
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date dateCreationFacture = dateFormat.parse("10/01/2022");
		Date dateDerniereModificationFacture = dateFormat.parse("30/03/2022");
		
		Facture f = new Facture(null, montantFacture,montantRemise,dateCreationFacture,dateDerniereModificationFacture,true, null, null, null);
		Facture facture = factureService.addFacture(f);
		factureService.retrieveFacture(facture.getIdFacture());
		assertEquals( facture.getIdFacture() , factureService.retrieveFacture(facture.getIdFacture()).getIdFacture());
		factureService.cancelFacture(facture.getIdFacture());
	
	}
	
	
	@Test
	@Order(3)
	public void testRetrieveAllFactures() throws ParseException {
		float montantFacture = (float) 60.5;
		float montantRemise = (float) 200.5;
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date dateCreationFacture = dateFormat.parse("10/01/2022");
		Date dateDerniereModificationFacture = dateFormat.parse("30/03/2022");
		List<Facture> factures = factureService.retrieveAllFactures();
		int expected = factures.size();
		Facture f = new Facture(null, montantFacture,montantRemise,dateCreationFacture,dateDerniereModificationFacture,true, null, null, null);
		Facture facture = factureService.addFacture(f);
		assertEquals(expected + 1, factureService.retrieveAllFactures().size());
		factureService.cancelFacture(facture.getIdFacture());

	}
	
	
	@Test
	@Order(4)
	public void testCancelFacture() throws ParseException {
		float montantFacture = (float) 70.5;
		float montantRemise = (float) 250.5;
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date dateCreationFacture = dateFormat.parse("10/01/2022");
		Date dateDerniereModificationFacture = dateFormat.parse("30/03/2022");
		Facture c = new Facture(null, montantFacture,montantRemise,dateCreationFacture,dateDerniereModificationFacture,false, null, null, null);
		Facture facture = factureService.addFacture(c);
		factureService.cancelFacture(facture.getIdFacture());
		assertEquals(true, factureService.retrieveFacture(facture.getIdFacture()).getArchivee());
		
	}
	
	

	
	
	
	
	
	
}