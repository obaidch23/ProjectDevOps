package com.esprit.examen.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.esprit.examen.entities.Facture;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FactureServiceImplTest {

	@Autowired
	IFactureService factureService;
	
	@Test
	public void testAddFacture() throws ParseException{
		float montantFacture = (float) 50.5;
		float montantRemise = (float) 100.5;
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date dateCreation = dateFormat.parse("30/01/2022");
		Date dateLastModification = dateFormat.parse("30/07/2022");
		List<Facture> factures = factureService.retrieveAllFactures();
			int expected=factures.size();
			Facture f = new Facture(null, montantFacture,montantRemise,dateCreation,dateLastModification,true, null, null, null);
			Facture savedFacture= factureService.addFacture(f);
			
			assertEquals(expected+1, factureService.retrieveAllFactures().size());
			assertNotNull(savedFacture.getMontantRemise());
			factureService.cancelFacture(savedFacture.getIdFacture());
	}
	
}
