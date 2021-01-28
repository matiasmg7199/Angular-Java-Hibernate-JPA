package ttps.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ttps.spring.clasesDAO.FoodTruckerDAO;
import ttps.spring.model.FoodTrucker;
import ttps.spring.services.TokenServices;
@CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600)
@RestController
@RequestMapping(value="/foodtruckers", produces = MediaType.APPLICATION_JSON_VALUE)

public class FoodTruckerController {

	@Autowired
	private FoodTruckerDAO fDAO;	
	
	@CrossOrigin(origins = "http://localhost:4200/")
	@GetMapping
	public ResponseEntity<List<FoodTrucker>> getFoodTruckers(){		
		List< FoodTrucker > foodTruckers = fDAO.recuperarTodos();
		if(foodTruckers.isEmpty()){
			return new ResponseEntity<List<FoodTrucker>>(HttpStatus.NO_CONTENT);
		}	
	    return new ResponseEntity< List<FoodTrucker> > (foodTruckers, HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://localhost:4200/")
	@PostMapping
	public ResponseEntity<FoodTrucker> crearFoodTruckers(@RequestBody FoodTrucker ft ){
		FoodTrucker exist = fDAO.buscarPorUsername(ft.getNombreUsuario());
	    if ( exist != null ) {
	    	return new ResponseEntity <FoodTrucker> (ft, HttpStatus.CONFLICT);
	    } else {
	    	fDAO.persistir(ft);
	    	return new ResponseEntity <FoodTrucker> (ft, HttpStatus.CREATED);
	    }	
	} 
	
	@CrossOrigin(origins = "http://localhost:4200/")
	@PutMapping("/{id}")
	public ResponseEntity<FoodTrucker> editarFoodTruckers(@PathVariable("id") String ftrId, @RequestBody FoodTrucker f, @RequestHeader String token ){
		FoodTrucker u = fDAO.recuperar(Long.parseLong(ftrId));
	    if ( u != null ) {
	    	if(!TokenServices.validateToken(token)) {
	    		System.out.print("No se valido el token");
				return new ResponseEntity<FoodTrucker>(u, HttpStatus.UNAUTHORIZED);
	    	}
	    	else {
	    		if(f.getNombre() != null) {
	    			u.setNombre(f.getNombre());
	    		}
	    		if(f.getNombreUsuario() != null) {
	    			u.setNombreUsuario(f.getNombreUsuario());
	    		}
	    		if(f.getEmail() != null) {
	    			u.setEmail(f.getEmail());
	    		}
	    		if(f.getApellido() != null) {
	    			u.setApellido(f.getApellido());
	    		}
	    		if(f.getContraseña() != null) {
	    			u.setContraseña(f.getContraseña());
	    		}
	    		fDAO.actualizar(u);
	    		return new ResponseEntity <FoodTrucker> (u, HttpStatus.OK);
	    		
	    	}
	    } 
	    return new ResponseEntity <FoodTrucker> (u, HttpStatus.CONFLICT);	
	} 
}
