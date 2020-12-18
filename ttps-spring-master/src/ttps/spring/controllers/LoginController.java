package ttps.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ttps.spring.clasesDAO.*;
import ttps.spring.model.Usuario;

//@CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600)
@RestController
@RequestMapping(value="/login", produces = MediaType.APPLICATION_JSON_VALUE)

public class LoginController {

	@Autowired
	private UsuarioDAO uDAO;
	

	@CrossOrigin(origins = "http://localhost:4200/")
	@PostMapping
	public ResponseEntity<String> login(@RequestHeader String username, @RequestHeader String password){
		Usuario u = uDAO.login(username, password);
		if( u != null ) {
			HttpHeaders header =  new HttpHeaders();
			header.set("token", u.getId()+"123456");
			if ( u.soyFoodTrucker() ) {
				header.set("tipo", "FoodTrucker");
				return new ResponseEntity<String> (header, HttpStatus.OK);
			} else if ( u.soyOrganizador() ) {
				header.set("tipo", "Organizador");
				return new ResponseEntity<String> (header, HttpStatus.OK);
			} else { return new ResponseEntity<String> (header, HttpStatus.NOT_FOUND); }
		}
		return  new ResponseEntity<String> ("Usuario o contraseña incorrectos", HttpStatus.NOT_FOUND);
	}
	
	
}