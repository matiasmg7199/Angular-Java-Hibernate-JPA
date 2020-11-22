package ttps.spring.clasesDAOHibernateJPA;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import ttps.spring.model.*;
import ttps.spring.clasesDAO.TipoDeServicioDAO;

@Repository
public class TipoComidaDAOHibernateJPA extends GenericDAOHibernateJPA<TipoComida> implements TipoDeServicioDAO{
	 
	public TipoComidaDAOHibernateJPA() {
		super(TipoComida.class);
	 }

	@Override
	public List<TipoComida> traerTodos() {
		EntityManagerFactory emf = new EMFactory().getEMF();
		EntityManager em = emf.createEntityManager();
		
		String sql = " SELECT ts "
				   + " FROM TipoDeServicio ts";
		 
		Query consulta = EMFactory.getEMF().createEntityManager().createQuery(sql);	 
		List<TipoComida> resultado = consulta.getResultList();	 
		return resultado;
	}

	@Override
	public TipoComida encontrarPorNombre(String nombre) {
		EntityManagerFactory emf = new EMFactory().getEMF();
		EntityManager em = emf.createEntityManager();
		
		String sql = " SELECT ts "
					+ " FROM TipoDeServicio ts"
		 			+ " WHERE ts.nombre = :nombre ";
		 
		 Query consulta = EMFactory.getEMF().createEntityManager().createQuery(sql);
		 consulta.setParameter("nombre", nombre);
		 TipoComida resultado = (TipoComida)consulta.getSingleResult();
		 return resultado;
	}
	
	

}
