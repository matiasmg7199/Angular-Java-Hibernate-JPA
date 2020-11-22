package ttps.spring.clasesDAO;

import java.util.List;
import ttps.spring.model.*;

public interface TipoDeServicioDAO extends GenericDAO<TipoComida> {
	
	public List<TipoComida> traerTodos();
	public TipoComida encontrarPorNombre(String nombre);
	/*public List<FoodTruck> devolverFoodTrucks();*/
	
}
