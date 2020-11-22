package ttps.spring.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table (name="Eventos")
public class Evento {
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private long id;
	
	@Column(name= "nombre", nullable = false)
	private String nombre;
	
	@Column(name= "direccion", nullable = false)
	private String direccion;
	
	@Column(name= "codigoPostal", nullable = false)
	private int codigoPostal;
	
	@Column(name= "provincia", nullable = false)
	private String provincia;
	
	@Column(name= "geolocalizacion", nullable = false)
	private String geolocalizacion;
	
	@Column(name= "fecha", nullable = false)
	private Date fecha;
	
	@Column(name= "hora", nullable = false)
	private Date hora;
	
	@Column(name= "email", nullable = false)
	private String email;
	
	@Column(name= "telefono", nullable = false)
	private int telefono;
	
	@Column(name= "descripcion", nullable = false)
	private String descripcion;
	
	@Column(name= "formaDePago", nullable = false)
	private Boolean formaDePago;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_Tipo", referencedColumnName = "id")
	private TipoDeEvento tipo;
	
	@OneToMany(mappedBy = "evento", cascade = CascadeType.ALL)
	private List<Invitacion> invitaciones = new ArrayList<>();
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "organizador_id", nullable = false)
	private Organizador organizador;
	
	public Evento() {
		super();
	}
	
	public Evento(String nombre, String direccion, int codigoPostal, String provincia, String geolocalizacion,
			Date fecha, Date hora, String email, int telefono, String descripcion, Boolean formaDePago,
			TipoDeEvento tipo) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.codigoPostal = codigoPostal;
		this.provincia = provincia;
		this.geolocalizacion = geolocalizacion;
		this.fecha = fecha;
		this.hora = hora;
		this.email = email;
		this.telefono = telefono;
		this.descripcion = descripcion;
		this.formaDePago = formaDePago;
		this.tipo = tipo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public int getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getGeolocalizacion() {
		return geolocalizacion;
	}
	public void setGeolocalizacion(String geolocalizacion) {
		this.geolocalizacion = geolocalizacion;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Date getHora() {
		return hora;
	}
	public void setHora(Date hora) {
		this.hora = hora;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Boolean getFormaDePago() {
		return formaDePago;
	}
	public void setFormaDePago(Boolean formaDePago) {
		this.formaDePago = formaDePago;
	}
	public TipoDeEvento getTipo() {
		return tipo;
	}
	public void setTipo(TipoDeEvento tipo) {
		this.tipo = tipo;
	}
	
	public List<Invitacion> getInvitaciones() {
		return invitaciones;
	}
	
	public void addInvitacion(Invitacion I) {
		invitaciones.add(I);
	}	
	
	
}
