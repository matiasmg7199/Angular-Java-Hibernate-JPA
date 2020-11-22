package ttps.spring.clasesDAOHibernateJPA;
import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import ttps.spring.clasesDAO.GenericDAO;
import ttps.spring.config.*;


@Transactional
public class GenericDAOHibernateJPA<T> implements GenericDAO<T>{

	protected Class<T> clasePersistente;
	private EntityManager entityManager;
	
	@PersistenceContext
	public void setEntityManager(EntityManager em){
		this.entityManager = em;
	 } 
	 
	public EntityManager getEntityManager() {
		return entityManager;
	 }

	public GenericDAOHibernateJPA(Class<T> clase) {
		clasePersistente = clase;
	}

	@Override
	public T actualizar(T entity) {
		this.getEntityManager().merge(entity);
		return entity;
	}

	@Override
	public T borrar(Serializable id) {		
		T entity = this.getEntityManager().find(clasePersistente,id);
		this.getEntityManager().remove(entity);
		return entity; 
	}

	@Override
	public boolean existe(Serializable id) {
		return !this.recuperar(id).equals(null);
	}

	@Override
	public T persistir(T entity) {		
		this.getEntityManager().persist(entity);
		return entity;
	} 

	@Override
	public T recuperar(Serializable id) {
		T entity = this.getEntityManager().find(clasePersistente, id);
		return entity;
	}

}
