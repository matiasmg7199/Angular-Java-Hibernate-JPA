package ttps.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="Usuarios")
public class Usuario {
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private long id;
	
	@Column(name= "nombre", nullable = false)
	private String nombre;
	
	@Column(name= "apellido", nullable = false)
	private String apellido;
	
	@Column(name= "email", nullable = false)
	private String email;
	
	@Column(name= "nombreUsuario", nullable = false)
	private String nombreUsuario;
	
	@Column(name= "contraseña", nullable = false)
	private String contraseña;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public Usuario(String nombre, String apellido, String email, String nombreUsuario, String contraseña) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.nombreUsuario = nombreUsuario;
		this.contraseña = contraseña;
	}
	public Usuario() {
		super();
	}
	
	public boolean soyOrganizador(){
		return false;
	}
	
	public boolean soyFoodTrucker(){
		return false;
	}
}
