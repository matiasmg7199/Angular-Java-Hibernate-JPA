package ttps.spring.clasesDAOHibernateJPA;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import ttps.spring.model.*;
import ttps.spring.clasesDAO.ZonaDAO;

@Repository
public class ZonaDAOHibernateJPA extends GenericDAOHibernateJPA<Zona> implements ZonaDAO{
	 
	public ZonaDAOHibernateJPA() {
		super(Zona.class);
	 }
	
	@Override
	public Zona buscarPorNombre(String nombre) {
		//EntityManagerFactory emf = new EMFactory().getEMF();
		//EntityManager em = emf.createEntityManager();
		
		 String sql = " SELECT z "
		 			+ " FROM Zona as z"
		 			+ " WHERE z.nombre = :nombre ";
		 
		 Query consulta = EMFactory.getEMF().createEntityManager().createQuery(sql);
		 consulta.setParameter("nombre", nombre);
		 Zona resultado = (Zona)consulta.getSingleResult();
		 return resultado;
	}
	
	@Override
	public List<Zona> recuperarTodas() {
		//EntityManagerFactory emf = new EMFactory().getEMF();
		//EntityManager em = emf.createEntityManager();
		
		 String sql = " SELECT z "
		 			+ " FROM Zona z";
		 
		 Query consulta = getEntityManager().createQuery(sql);
		 List<Zona> resultado = consulta.getResultList();
		 return resultado;
	}

}
