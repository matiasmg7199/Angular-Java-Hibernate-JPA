package ttps.spring.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table (name="FoodTrucks")
public class FoodTruck {
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private long id;
	
	@Column(name= "nombre", nullable = false)
	private String nombre;
	
	@Column(name= "descripcion", nullable = true)
	private String descripcion;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_Zona", referencedColumnName = "id")
	private Zona zona;
	
	@ManyToMany(cascade = CascadeType.ALL)
	 @JoinTable(
	            name = "FoodTrucks_TipoComidas", 
	            joinColumns = { @JoinColumn(name = "foodtrucks_id") }, 
	            inverseJoinColumns = { @JoinColumn(name = "tipocomidas_id") }
	        )
	private List<TipoComida> comidas= new ArrayList<TipoComida>();
	
	@Column(name= "url", nullable = false)
	private String url;
	
	@Column(name= "redesSociales", nullable = false)
	private String redesSociales;

	//private List<String> imagenes= new ArrayList<String>();
	@OneToMany(mappedBy = "foodtruck", cascade = CascadeType.ALL)
    private List<Invitacion> invitaciones = new ArrayList<>();
	
    @ManyToOne
    @JoinColumn(name="foodtrucker_id", nullable = false)
    private FoodTrucker foodtrucker;
    
	public FoodTruck(String nombre, String descripcion, Zona zona, String url,
			String redesSociales) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.zona = zona;
		this.url = url;
		this.redesSociales = redesSociales;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getRedesSociales() {
		return redesSociales;
	}

	public void setRedesSociales(String redesSociales) {
		this.redesSociales = redesSociales;
	}
	
	//public void addImagen(String imagen) {
	//	imagenes.add(imagen);
	//}	
	
	public void addInvitacion(Invitacion I) {
		invitaciones.add(I);
	}	
	
	public Zona getZona() {
		return zona;
	}

	public void setZona(Zona zona) {
		this.zona = zona;
	}
	
	public void addComida(TipoComida C) {
		comidas.add(C);
	}
	
	public List<TipoComida> getComidas() {
		return comidas;
	}


	//public List<String> getImagenes() {
	//	return imagenes;
	//}
	
	public List<Invitacion> getInvitaciones() {
		return invitaciones;
	}

	public FoodTruck() {
		super();
	}
}
