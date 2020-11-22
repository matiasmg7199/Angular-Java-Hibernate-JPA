package ttps.spring.clasesDAOHibernateJPA;

import ttps.spring.model.*;
import org.springframework.stereotype.Repository;
import ttps.spring.clasesDAO.InvitacionDAO;

@Repository
public class InvitacionDAOHibernateJPA extends GenericDAOHibernateJPA<Invitacion> implements InvitacionDAO{
	 
	public InvitacionDAOHibernateJPA() {
		super(Invitacion.class);
	 }

}
