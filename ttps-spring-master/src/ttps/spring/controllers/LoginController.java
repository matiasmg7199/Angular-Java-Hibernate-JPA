package ttps.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import ttps.spring.services.Credentials;
import ttps.spring.services.TokenServices;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ttps.spring.clasesDAO.*;
import ttps.spring.model.Usuario;


@CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600)
@RestController
@RequestMapping(value="/login", produces = MediaType.APPLICATION_JSON_VALUE)

public class LoginController {

	@Autowired
	private UsuarioDAO uDAO;
	

	/*@CrossOrigin(origins = "http://localhost:4200/")
	@PostMapping
	public ResponseEntity<Usuario> login(@RequestHeader String username, @RequestHeader String password){
		Usuario u = uDAO.login(username, password);
		if( u != null ) {
			HttpHeaders header =  new HttpHeaders();
			header.set("token", u.getId()+"123456");
			if ( u.soyFoodTrucker() ) {
				header.set("tipo", "FoodTrucker");
				return new ResponseEntity<Usuario> (u, HttpStatus.OK);
			} else if ( u.soyOrganizador() ) {
				header.set("tipo", "Organizador");
				return new ResponseEntity<Usuario> (u, HttpStatus.OK);
			} else { return new ResponseEntity<Usuario> (u, HttpStatus.NOT_FOUND); }
		}
		return  new ResponseEntity<Usuario> (u, HttpStatus.NOT_FOUND);
	}*/
	
	@CrossOrigin(origins = "http://localhost:4200/")
	@PostMapping
	public ResponseEntity<?> loginNuevo (@RequestHeader String username, @RequestHeader String password){
		Usuario u = uDAO.login( username, password );
		System.out.print("Se llama a la api login");
		if( u != null ) {
			
			String token = TokenServices.generateToken(username, 900000);
			String status = "ok";
			String tipo;
			String userID = Long.toString(u.getId()) ;
			
			if (u.soyFoodTrucker()) {
				tipo = "foodtrucker";
			} else { tipo = "organizador"; }
			
		    return ResponseEntity.ok(new Credentials(token, 900000,status, tipo, userID));
		
		} else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuario o password incorrecto"); }
	}	
	
}