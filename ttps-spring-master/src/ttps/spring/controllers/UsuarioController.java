package ttps.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.*;

import ttps.spring.clasesDAO.UsuarioDAO;
import ttps.spring.model.Usuario;

@RestController
@RequestMapping(value="/usuarios", produces = MediaType.APPLICATION_JSON_VALUE)

public class UsuarioController {
	@Autowired
	private UsuarioDAO uDAO;	

	@GetMapping
	public ResponseEntity<List<Usuario>> getUsuarios( ){		
		List< Usuario > users = uDAO.recuperarTodos();
		if(users.isEmpty()){
			return new ResponseEntity<List<Usuario>>(HttpStatus.NO_CONTENT);
		}	
	    return new ResponseEntity< List<Usuario> > (users, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity <Usuario> crearUsuario (@RequestBody Usuario user) {
		Usuario exist = uDAO.buscarPorUsername(user.getNombreUsuario());
	    if ( exist != null ) {
	    	return new ResponseEntity <Usuario> (user, HttpStatus.CONFLICT);
	    } else {
	    	uDAO.persistir(user);
	    	return new ResponseEntity <Usuario> (user, HttpStatus.CREATED);
	    }		       
    }

	@GetMapping("/{id}")
	public ResponseEntity<Usuario> getUsuario(@PathVariable("id") long id) {
		Usuario user = uDAO.recuperar(id);
		if (user == null) {
			return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Usuario>(user, HttpStatus.OK);
	 }

	@PutMapping("/{id}")
	public ResponseEntity<Usuario> modificarUsuario(@PathVariable("id") long id, @RequestBody Usuario user) {
		Usuario u = uDAO.recuperar(id);
		if(!u.equals(null)) {
			if(user.getNombreUsuario() != null) {
				u.setNombreUsuario(user.getNombreUsuario());
			}
			if(user.getNombre() != null) {
				u.setNombre(user.getNombre());
			}
			if(user.getContraseña() != null) {
				u.setContraseña(user.getContraseña());
			}
			if(user.getEmail() != null) {
				u.setEmail(user.getEmail());
			}
			if(user.getApellido() != null) {
				u.setApellido(user.getApellido());
			}
			return new ResponseEntity<Usuario>(user, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
		}
	}
	
	
}