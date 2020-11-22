package ttps.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ttps.spring.clasesDAO.FoodTruckerDAO;
import ttps.spring.model.FoodTrucker;
import ttps.spring.model.Usuario;

@RestController
@RequestMapping(value="/foodtruckers", produces = MediaType.APPLICATION_JSON_VALUE)

public class FoodTruckerController {

	@Autowired
	private FoodTruckerDAO fDAO;	
	
	@GetMapping
	public ResponseEntity<List<FoodTrucker>> getFoodTruckers(){		
		List< FoodTrucker > foodTruckers = fDAO.recuperarTodos();
		if(foodTruckers.isEmpty()){
			return new ResponseEntity<List<FoodTrucker>>(HttpStatus.NO_CONTENT);
		}	
	    return new ResponseEntity< List<FoodTrucker> > (foodTruckers, HttpStatus.OK);
	}

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
	
}
