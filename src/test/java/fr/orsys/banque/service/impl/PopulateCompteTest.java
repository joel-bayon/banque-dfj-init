package fr.orsys.banque.service.impl;

import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.orsys.banque.service.Banque;

public class PopulateCompteTest {
	static ConfigurableApplicationContext spring = new AnnotationConfigApplicationContext(SpringConfigTest.class);
	
	@Test
	public void run() {
	
		
		Banque banque = spring.getBean(Banque.class);
		
		int id1 = banque.ouvrirCompte(100);
		int id2 = banque.ouvrirCompteEpargne(10000, 0.2f);
		banque.ouvrirCompteEpargne(10000, 0.2f);
		banque.ouvrirCompte(1999f);
		

		
		System.out.println("\n**** Fin la création de comptes en base  *****\n");
			
	}
}
