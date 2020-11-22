package ttps.spring.model;

import javax.persistence.*;

@Entity
@Table (name="TipoDeComidas")
public class TipoComida {
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private long id;
	
	@Column(name= "nombre", nullable = false)
	private String nombre;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public TipoComida(String nombre) {
		super();
		this.nombre = nombre;
	}

	public TipoComida() {
		super();
	}
	
	
}
