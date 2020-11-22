package ttps.spring.clasesDAO;

import org.springframework.transaction.annotation.Transactional;
import ttps.spring.clasesDAOHibernateJPA.*;

@Transactional
public class DAOFactory {

	public static UsuarioDAO getUsuarioDAO(){
			return new UsuarioDAOHibernateJPA();
		}
		
	public static InvitacionDAO getContratacionDAO(){
			return new InvitacionDAOHibernateJPA();
		}
	
	public static EventoDAO getEventoDAO(){
			return new EventoDAOHibernateJPA();
		}
	
	public static FoodTruckDAO getFoodTruckDAO(){
			return new FoodTruckDAOHibernateJPA();
		}
	
	public static FoodTruckerDAO getFoodTruckerDAO(){
			return new FoodTruckerDAOHibernateJPA();
		}
	
	public static OrganizadorDAO getOrganizadorDAO(){
			return new OrganizadorDAOHibernateJPA();
		}
	
	public static TipoDeEventoDAO getTipoDeEventoDAO(){
			return new TipoDeEventoDAOHibernateJPA();
		}
	
	public static TipoDeServicioDAO getTipoDeServicioDAO(){
			return new TipoComidaDAOHibernateJPA();
		}
	
	public static ZonaDAO getZonaDAO(){
			return new ZonaDAOHibernateJPA();
		}
	
}
