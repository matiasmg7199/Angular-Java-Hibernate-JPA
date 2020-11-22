package ttps.spring.clasesDAO;

import java.util.List;
import ttps.spring.model.*;

public interface UsuarioDAO extends GenericDAO<Usuario> {

	 public Usuario buscarPorUsername(String username);
	 public List <Usuario> recuperarTodos();
}
