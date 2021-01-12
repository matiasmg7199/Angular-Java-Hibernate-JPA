package ttps.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ttps.spring.clasesDAO.OrganizadorDAO;
import ttps.spring.model.Organizador;

@CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600)
@RestController
@RequestMapping(value="/organizadores", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrganizadorController {
	@Autowired
	private OrganizadorDAO oDAO;	
	
	@CrossOrigin(origins = "http://localhost:4200/")
	@GetMapping
	public ResponseEntity<List<Organizador>> getOrganizadores(){		
		List< Organizador > organizadores = oDAO.recuperarTodos();
		if(organizadores.isEmpty()){
			return new ResponseEntity<List<Organizador>>(HttpStatus.NO_CONTENT);
		}	
	    return new ResponseEntity< List<Organizador> > (organizadores, HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:4200/")
	@PostMapping
	public ResponseEntity<Organizador> crearOrganizadores(@RequestBody Organizador ft ){
		Organizador exist = oDAO.buscarPorUsername(ft.getNombreUsuario());
	    if ( exist != null ) {
	    	return new ResponseEntity <Organizador> (ft, HttpStatus.CONFLICT);
	    } else {
	    	oDAO.persistir(ft);
	    	return new ResponseEntity <Organizador> (ft, HttpStatus.CREATED);
	    }	
	} 
}
