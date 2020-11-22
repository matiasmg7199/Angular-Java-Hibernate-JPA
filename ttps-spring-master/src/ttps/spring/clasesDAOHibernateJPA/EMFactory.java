package ttps.spring.clasesDAOHibernateJPA;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMFactory {
	private static final EntityManagerFactory em = Persistence.createEntityManagerFactory("EMFoodTrucks");

	public static EntityManagerFactory getEMF() {
		return em;
	}

	
}
