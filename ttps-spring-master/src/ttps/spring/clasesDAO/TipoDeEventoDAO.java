package ttps.spring.clasesDAO;

import java.util.List;

import ttps.spring.model.*;

public interface TipoDeEventoDAO extends GenericDAO<TipoDeEvento> {

	public TipoDeEvento buscarPorNombre(String nombre);
	/*public List<Organizador> devolverOrganizadores();*/
	
	
}
