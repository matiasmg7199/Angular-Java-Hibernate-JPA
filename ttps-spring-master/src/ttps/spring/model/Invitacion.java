package ttps.spring.model;

import java.util.Date;

import javax.persistence.*;;
@Entity
@Table (name="Invitaciones")
public class Invitacion {
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private long id;
	
	@Column(name= "limpieza", nullable = false)
	private int limpieza;
	
	@Column(name= "simpatia", nullable = false)
	private int simpatia;
	
	@Column(name= "calidadPrecio", nullable = false)
	private int calidadPrecio;
	
	@Column(name= "sabor", nullable = false)
	private int sabor;
	
	@Column(name= "diseño", nullable = false)
	private int diseño;
	
	@Column(name= "aceptada", nullable = false)
	private boolean aceptada;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "evento_id", nullable = false)
	private Evento evento;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="foodtruck_id", nullable = false)
	private FoodTruck foodtruck;
	
	public int getLimpieza() {
		return limpieza;
	}
	public void setLimpieza(int limpieza) {
		this.limpieza = limpieza;
	}
	public int getSimpatia() {
		return simpatia;
	}
	public void setSimpatia(int simpatia) {
		this.simpatia = simpatia;
	}
	public int getCalidadPrecio() {
		return calidadPrecio;
	}
	public void setCalidadPrecio(int calidadPrecio) {
		this.calidadPrecio = calidadPrecio;
	}
	public int getSabor() {
		return sabor;
	}
	public void setSabor(int sabor) {
		this.sabor = sabor;
	}
	public int getDiseño() {
		return diseño;
	}
	public void setDiseño(int diseño) {
		this.diseño = diseño;
	}
	public boolean isAceptada() {
		return aceptada;
	}
	public void setAceptada(boolean aceptada) {
		this.aceptada = aceptada;
	}
	public Invitacion(int limpieza, int simpatia, int calidadPrecio, int sabor, int diseño,
			boolean aceptada) {
		super();
		this.limpieza = limpieza;
		this.simpatia = simpatia;
		this.calidadPrecio = calidadPrecio;
		this.sabor = sabor;
		this.diseño = diseño;
		this.aceptada = aceptada;
	}
	public Invitacion() {
		super();
	}
	
	
	
	
}
