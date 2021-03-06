package ttps.spring.controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ttps.spring.clasesDAO.FoodTruckDAO;
import ttps.spring.clasesDAO.FoodTruckerDAO;
import ttps.spring.model.FoodTruck;
import ttps.spring.model.FoodTrucker;
import ttps.spring.model.TipoComida;
import ttps.spring.services.TokenServices;

@CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600)
@RestController
@RequestMapping(value="/foodtrucks", produces = MediaType.APPLICATION_JSON_VALUE)

public class FoodTruckController {

	@Autowired
	private FoodTruckDAO foodtruckDAO;
	@Autowired
	private FoodTruckerDAO ftrDAO;
	
	
	
	@CrossOrigin(origins = "http://localhost:4200/")
	@GetMapping("/{id}")
	public ResponseEntity<List<FoodTruck>> getFoodTrucksByUserID(@PathVariable("id") String ftrId, @RequestHeader String token ){
		FoodTrucker foodtrucker = ftrDAO.recuperar(Long.parseLong(ftrId));
		System.out.println("Se llama a la api listar foodtrucks");
	    if (foodtrucker != null) {
			if (!TokenServices.validateToken(token)) {
				System.out.print("No se valido el token");
				return new ResponseEntity<List<FoodTruck>>(HttpStatus.UNAUTHORIZED);
			} else {
				List<FoodTruck> foodTrucks = foodtruckDAO.encontrarTodosParaUsuarioID(Long.parseLong(ftrId));
				if(foodTrucks.isEmpty()){
					return new ResponseEntity<List<FoodTruck>>(HttpStatus.NO_CONTENT);
				}	
				return new ResponseEntity<List<FoodTruck>>(foodTrucks, HttpStatus.OK);
		}
	    } else {  System.out.println("!!-- No se encontro el usuario con id " + Long.parseLong(ftrId) + " --!!");
			  return new ResponseEntity<List<FoodTruck>>(HttpStatus.OK); }
			
	}
	@CrossOrigin(origins = "http://localhost:4200/")
	@PostMapping("/{id}")
	public ResponseEntity<FoodTruck> createFoodTruck(@RequestBody FoodTruck unFoodTruck,@PathVariable("id") long id, @RequestHeader String token ){
		FoodTrucker FT = ftrDAO.recuperar(id);
		if(FT != null) {
			if (!TokenServices.validateToken(token)) {
				return new ResponseEntity<FoodTruck>(HttpStatus.UNAUTHORIZED);
			} else {
				unFoodTruck.setFoodtrucker(FT);
				//A�ado las comidas
				//Creo una lista
				ListIterator it = unFoodTruck.getComidas().listIterator();
				//Creo un arreglo donde poder guardar las comidas
				//Todo este mecanismo es para insertar las comidas en la tabla intermedia a su vez
				List<TipoComida> comidas = new ArrayList();
				while(it.hasNext()) {
					//Tomo la comida en el nodo actual de la lista
					TipoComida TC = (TipoComida) it.next();
					//Recupero la comida con ese Id en la tabla
					comidas.add(TC);
				}
				//Para que no haya conflictos seteo la lista de comidas del foodtruck que me llega por parametro en null
				unFoodTruck.setComidas(null);
				
				//Creo al food truck con la lista de comidas vacia 
				foodtruckDAO.persistir(unFoodTruck);
				
				//Le asigno al foodtruck la lista de comidas y actualizo
				unFoodTruck.setComidas(comidas);
				foodtruckDAO.actualizar(unFoodTruck);
				
				return new ResponseEntity<FoodTruck>(unFoodTruck, HttpStatus.CREATED);
			}
		}
		else { return new ResponseEntity<FoodTruck>(HttpStatus.NOT_FOUND); }
	}
	@CrossOrigin(origins = "http://localhost:4200/")
	@PutMapping("/{id}")
	public ResponseEntity<FoodTruck> modifyFoodTruck(@RequestBody FoodTruck unFoodTruck,@PathVariable("id") long id, @RequestHeader String token ){
		FoodTruck f = foodtruckDAO.recuperar(id);
		if(f != null) {
			if (!TokenServices.validateToken(token)) {
				return new ResponseEntity<FoodTruck>(HttpStatus.UNAUTHORIZED);
			} else {
				if (unFoodTruck.getNombre() != null) {
					f.setNombre(unFoodTruck.getNombre());
				}
				if (unFoodTruck.getDescripcion() != null) {
					f.setDescripcion(unFoodTruck.getDescripcion());
				}
				if (unFoodTruck.getUrl() != null) {
					f.setUrl(unFoodTruck.getUrl());
				}
				if (unFoodTruck.getRedesSociales() != null) {
					f.setRedesSociales(unFoodTruck.getRedesSociales());
				}
				if (f.getComidas() != null) {

					//A�ado las comidas
					//Creo una lista
					ListIterator it = unFoodTruck.getComidas().listIterator();
					//Creo un arreglo donde poder guardar las comidas
					//Todo este mecanismo es para insertar las comidas en la tabla intermedia a su vez
					Set<TipoComida> comidas = new HashSet<>();
					while(it.hasNext()) {
						//Tomo la comida en el nodo actual de la lista
						TipoComida TC = (TipoComida) it.next();
						//Recupero la comida con ese Id en la tabla
						comidas.add(TC);
					}
					//Le asigno al foodtruck la lista de comidas
					unFoodTruck.setComidas((List)comidas);
				}
				foodtruckDAO.actualizar(f);
				return new ResponseEntity<FoodTruck>(unFoodTruck, HttpStatus.CREATED);
			}
		}
		else { return new ResponseEntity<FoodTruck>(HttpStatus.NOT_FOUND); }
	}
	@CrossOrigin(origins = "http://localhost:4200/")
	@DeleteMapping("/{id}")
	public ResponseEntity<FoodTruck> modifyFoodTruck(@PathVariable("id") String id, @RequestHeader String token ){
		long idConverted = Long.parseLong(id); 
		FoodTruck f = foodtruckDAO.recuperar(idConverted);
		if(f != null) {
			//Verifico el token
			if (!TokenServices.validateToken(token)) {
				return new ResponseEntity<FoodTruck>(HttpStatus.UNAUTHORIZED);
			} else {
				//Si no existe el foodtruck a eliminar
				if(!(foodtruckDAO.existe(idConverted))) {
					return new ResponseEntity<FoodTruck>(HttpStatus.NOT_FOUND);
				}
				foodtruckDAO.borrar(idConverted);
				return new ResponseEntity<FoodTruck>(HttpStatus.NO_CONTENT);
			}
		}
		else { return new ResponseEntity<FoodTruck>(HttpStatus.NOT_FOUND); }
	}
	
}