package ttps.spring.clasesDAOHibernateJPA;

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
		EntityManagerFactory emf = new EMFactory().getEMF();
		EntityManager em = emf.createEntityManager();
		
		 String sql = " SELECT z "
		 			+ " FROM Zona as z"
		 			+ " WHERE z.nombre = :nombre ";
		 
		 Query consulta = EMFactory.getEMF().createEntityManager().createQuery(sql);
		 consulta.setParameter("nombre", nombre);
		 Zona resultado = (Zona)consulta.getSingleResult();
		 return resultado;
	}

}
