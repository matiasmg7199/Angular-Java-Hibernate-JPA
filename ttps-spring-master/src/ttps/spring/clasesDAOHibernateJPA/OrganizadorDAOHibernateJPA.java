package ttps.spring.clasesDAOHibernateJPA;

import java.util.List;

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
	
	@Override
	public List<Organizador> recuperarTodos() {
		String sql = " SELECT o "
	 				+ " FROM Organizador as o ";		 
	 Query consulta = getEntityManager().createQuery(sql);
	 return consulta.getResultList();
	}

	@Override
	public Organizador buscarPorUsername(String nombreUsuario) {
		 String sql = " SELECT o "
		 			+ " FROM Organizador as o"
		 			+ " WHERE o.nombreUsuario = :nombreusuario ";		 
		 Query consulta = getEntityManager().createQuery(sql);
		 consulta.setParameter("nombreusuario", nombreUsuario);
		 List <Usuario> resultList = consulta.getResultList();
		 if( resultList.size() != 0 ) {
			return (Organizador) resultList.get(0); }
		 else { return null; }
	 }

}
