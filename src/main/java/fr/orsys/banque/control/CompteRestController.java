package fr.orsys.banque.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.orsys.banque.entity.Compte;
import fr.orsys.banque.service.Banque;


@RestController
@RequestMapping("/comptes")
public class CompteRestController {

	   @Autowired
	   Banque  banque;
	   @RequestMapping(value="/{numero}", method=RequestMethod.GET, 
		           produces={MediaType.APPLICATION_XML_VALUE,
	 				           MediaType.APPLICATION_JSON_VALUE})
	   public ResponseEntity<?> getCompte(@PathVariable Integer numero ) {
			System.out.println("/comptes/"+ numero);
			Compte compte   =  banque.rechercherCompte(numero);
			if(compte == null)
				return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			return new ResponseEntity<Compte>(compte, HttpStatus.OK);
		}
}

