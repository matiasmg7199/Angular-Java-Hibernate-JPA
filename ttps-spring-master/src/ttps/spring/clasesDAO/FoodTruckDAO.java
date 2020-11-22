package ttps.spring.clasesDAO;

import java.util.List;
import ttps.spring.model.*;

public interface FoodTruckDAO extends GenericDAO<FoodTruck> {

	public List<FoodTruck> encontrarTodosParaUsuarioID(long usuarioID);
	public FoodTruck encontrarPorNombre(String nombre);
	/*public FoodTrucker devolverFoodTrucker();
	public List<TipoDeServicio> devolverTipos();
	public List<Contratacion> devolverSolicitudes();*/
	
}
