package ttps.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ttps.spring.clasesDAO.FoodTruckDAO;
import ttps.spring.clasesDAO.FoodTruckerDAO;
import ttps.spring.model.FoodTruck;
import ttps.spring.model.FoodTrucker;
import ttps.spring.model.Usuario;

@RestController
@RequestMapping(value="/foodtrucks", produces = MediaType.APPLICATION_JSON_VALUE)

public class FoodTruckController {

	@Autowired
	private FoodTruckDAO foodtruckDAO;
	private FoodTruckerDAO ftrDAO;
	
	
	
	
	@GetMapping("/{id}")
	public ResponseEntity<List<FoodTruck>> getFoodTrucksByUserID(@PathVariable("id") long id, @RequestHeader String token ){
		FoodTrucker foodtrucker = ftrDAO.recuperar(id);
	    if (foodtrucker != null) {
			if (!token.equals(foodtrucker.getId() + "123456")) {
				System.out.println(" <-- Token Invalido --> ");
				return new ResponseEntity<List<FoodTruck>>(HttpStatus.UNAUTHORIZED);
			} else {
				List<FoodTruck> foodTrucks = foodtruckDAO.encontrarTodosParaUsuarioID(id);
				System.out.println("< Se encontraron " + foodTrucks.size() + " >");
				System.out.println("< lista " + foodTrucks + " >");
				if(foodTrucks.isEmpty()){
					return new ResponseEntity<List<FoodTruck>>(HttpStatus.NO_CONTENT);
				}	
				return new ResponseEntity<List<FoodTruck>>(foodTrucks, HttpStatus.OK);
		}
	    } else {  System.out.println("!!-- No se encontro el usuario con id " + id + " --!!");
			  return new ResponseEntity<List<FoodTruck>>(HttpStatus.OK); }
			
	}

//	@PostMapping
//	public ResponseEntity<FoodTrucker> crearFoodTruckers(@RequestBody FoodTrucker ft ){
//		FoodTrucker exist = fDAO.buscarPorUsername(ft.getNombreUsuario());
//	    if ( exist != null ) {
//	    	return new ResponseEntity <FoodTrucker> (ft, HttpStatus.CONFLICT);
//	    } else {
//	    	fDAO.persistir(ft);
//	    	return new ResponseEntity <FoodTrucker> (ft, HttpStatus.CREATED);
//	    }	
//	} 
	
}