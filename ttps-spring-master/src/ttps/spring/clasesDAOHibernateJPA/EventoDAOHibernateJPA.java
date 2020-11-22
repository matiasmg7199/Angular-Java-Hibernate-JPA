package ttps.spring.clasesDAOHibernateJPA;

import ttps.spring.model.*;

import org.springframework.stereotype.Repository;

import ttps.spring.clasesDAO.EventoDAO;

@Repository
public class EventoDAOHibernateJPA extends GenericDAOHibernateJPA<Evento> implements EventoDAO{
	 
	public EventoDAOHibernateJPA() {
		super(Evento.class);
	 }

}
