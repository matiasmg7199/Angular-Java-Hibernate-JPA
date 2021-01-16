package ttps.spring.clasesDAO;

import java.util.List;
import ttps.spring.model.*;

public interface ZonaDAO extends GenericDAO<Zona> {

	public Zona buscarPorNombre(String nombre);
	/*public List<FoodTrucker> devolverFoodTruckers();*/
	public List<Zona> recuperarTodas();
	
}