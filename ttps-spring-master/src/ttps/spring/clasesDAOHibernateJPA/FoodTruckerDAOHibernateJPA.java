package ttps.spring.clasesDAOHibernateJPA;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import ttps.spring.model.*;
import ttps.spring.clasesDAO.FoodTruckerDAO;

@Repository
public class FoodTruckerDAOHibernateJPA extends GenericDAOHibernateJPA<FoodTrucker> implements FoodTruckerDAO{
	
	 public FoodTruckerDAOHibernateJPA() {
		super(FoodTrucker.class);
	 }
	 
	 @Override
	 public FoodTrucker buscarPorIDdeUsuario(long usuarioID) {
		FoodTrucker resultado = null;
		String sql = " SELECT f "
		 			+ " FROM FoodTrucker as f"
		 			+ " INNER JOIN Usuario u on (u.id = f.usuario)"
		 			+ " WHERE u.id = :usuarioID";
		 Query consulta =  this.getEntityManager().createQuery(sql);
		 consulta.setParameter("usuarioID", usuarioID);
		 List <FoodTrucker> result = consulta.getResultList(); 
		 if( !result.isEmpty() ) {
			 resultado = (FoodTrucker)result.get(0); }
		 return resultado;
	 }

	@Override
	public List<FoodTrucker> recuperarTodos() {
		String sql = " SELECT f "
	 				+ " FROM FoodTrucker as f ";		 
	 Query consulta = getEntityManager().createQuery(sql);
	 return consulta.getResultList();
	}

	@Override
	public FoodTrucker buscarPorUsername(String nombreUsuario) {
		 String sql = " SELECT f "
		 			+ " FROM FoodTrucker as f"
		 			+ " WHERE f.nombreUsuario = :nombreusuario ";		 
		 Query consulta = getEntityManager().createQuery(sql);
		 consulta.setParameter("nombreusuario", nombreUsuario);
		 List <Usuario> resultList = consulta.getResultList();
		 if( resultList.size() != 0 ) {
			return (FoodTrucker) resultList.get(0); }
		 else { return null; }
	 }
	
}


