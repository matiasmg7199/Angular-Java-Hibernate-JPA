package ttps.spring.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table (name="Organizadores")
public class Organizador extends Usuario {

	@JsonIgnore
	@OneToMany(mappedBy = "organizador")
	private List<Evento> eventos = new ArrayList<Evento>();
	

	public Organizador() {
		super();
	}

	public boolean addEvento(Evento f) {
		 eventos.add(f);
		 return true;
	 }

	public List<Evento> getEventos() {
		return eventos;
	}

	public boolean removeEvento(Evento f) {
		 eventos.remove(f);
		 return true;
	 }
	
	public boolean soyOrganizador(){
		return true;
	}
	
}
