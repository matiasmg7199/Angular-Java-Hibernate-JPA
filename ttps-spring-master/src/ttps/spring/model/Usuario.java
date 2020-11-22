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
	
	@Column(name= "contrase�a", nullable = false)
	private String contrase�a;
	
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
	public String getContrase�a() {
		return contrase�a;
	}
	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}
	public Usuario(String nombre, String apellido, String email, String nombreUsuario, String contrase�a) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.nombreUsuario = nombreUsuario;
		this.contrase�a = contrase�a;
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
