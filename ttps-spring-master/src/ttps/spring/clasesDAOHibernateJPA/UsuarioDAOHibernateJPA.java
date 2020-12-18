package ttps.spring.clasesDAOHibernateJPA;

import java.util.List;

import javax.persistence.*;

import org.springframework.stereotype.Repository;
import ttps.spring.model.*;
import ttps.spring.clasesDAO.UsuarioDAO;

@Repository
public class UsuarioDAOHibernateJPA extends GenericDAOHibernateJPA<Usuario> implements UsuarioDAO{

	 public UsuarioDAOHibernateJPA() {
		super(Usuario.class);
	 }
	 
	 @Override
	 public Usuario buscarPorUsername(String nombreusuario) {
		 String sql = " SELECT u "
		 			+ " FROM Usuario as u"
		 			+ " WHERE u.nombreUsuario = :nombreusuario ";		 
		 Query consulta = getEntityManager().createQuery(sql);
		 consulta.setParameter("nombreusuario", nombreusuario);
		 List <Usuario> resultList = consulta.getResultList();
		 if( resultList.size() != 0 ) {
			return (Usuario) resultList.get(0); }
		 else { return null; }
	 }

	@Override
	public List<Usuario> recuperarTodos() {
		 String sql = " SELECT u "
		 			+ " FROM Usuario as u ";		 
		 Query consulta = getEntityManager().createQuery(sql);
		 return consulta.getResultList();
	}
	 

	@Override
	public Usuario login (String username, String password) {		
		Usuario resultado = null; 
		String sql = " SELECT u "
	 			   + " FROM Usuario as u"
	 			   + " WHERE u.nombreUsuario = :username AND u.contraseña = :password ";		 
		Query consulta = getEntityManager().createQuery(sql);
		consulta.setParameter("username", username);
		consulta.setParameter("password", password);
		List <Usuario> result = consulta.getResultList(); 
		if( !result.isEmpty() ) {
			 resultado = (Usuario)result.get(0); }
		 return resultado;
	}
	 
	 
	 
}
