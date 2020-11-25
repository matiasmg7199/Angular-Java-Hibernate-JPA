package ttps.spring.clasesDAO;

import java.util.List;

import ttps.spring.model.*;

public interface OrganizadorDAO extends GenericDAO<Organizador> {
	
	public Organizador buscarPorIDdeUsuario(long idUsuario);
	public List<Organizador> recuperarTodos();
	/*public Usuario devolverUsuario();
	public List<Evento> devolverEventos();*/
	public Organizador buscarPorUsername(String nombreUsuario);
	
}
