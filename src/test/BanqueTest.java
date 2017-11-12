package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import banque.Banque;
import banque.DebitNonAutoriseException;


public class BanqueTest {
	Banque banque = null;
	int id1; int id2;
	
	@Before
	public void initBanqueTest() {
		banque= new Banque("LCL", "121212");
		id1 = banque.ouvrirCompte(100.0f);
		id2 = banque.ouvrirCompte(100.0f);
		
	}

	@Test
	public void testEffectuerVirement() {
		try {
			banque.effectuerVirement(id1, 200.0f, id2);
			assertEquals(-100.0f, banque.getCompte(id1).getSolde(), 0.0f);
			assertEquals(300.0f, banque.getCompte(id2).getSolde(), 0.0f);
			
		} catch (DebitNonAutoriseException e) {
			// TODO Auto-generated catch block
			fail();
		}
		
	}

}
