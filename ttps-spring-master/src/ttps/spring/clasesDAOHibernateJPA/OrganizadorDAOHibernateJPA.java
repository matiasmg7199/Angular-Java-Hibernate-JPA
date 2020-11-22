package ttps.spring.clasesDAOHibernateJPA;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import ttps.spring.model.*;
import ttps.spring.clasesDAO.OrganizadorDAO;

@Repository
public class OrganizadorDAOHibernateJPA extends GenericDAOHibernateJPA<Organizador> implements OrganizadorDAO{
	 
	public OrganizadorDAOHibernateJPA() {
		super(Organizador.class);
	 }

	@Override
	public Organizador buscarPorIDdeUsuario(long idUsuario) {
		EntityManagerFactory emf = new EMFactory().getEMF();
		EntityManager em = emf.createEntityManager();
		
		 String sql = " SELECT o "
		 			+ " FROM Organizador as o"
		 			+ " INNER JOIN Usuario u on (u.id = o.usuario)"
		 			+ " WHERE u.id = :usuarioID";
		 
		 Query consulta = EMFactory.getEMF().createEntityManager().createQuery(sql);
		 consulta.setParameter("usuarioID", idUsuario);
		 Organizador resultado = (Organizador)consulta.getSingleResult();
		 return resultado;
	}

}
