package py.com.renta.persona.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "persona")
public class PersonaEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "ruc_ci", nullable = false, length = 20)
	private String rucCi;
	@Column(name = "nombre", nullable = false, length = 100)
	private String Nombre;
	@Column(name = "actividad", nullable = false, length = 100)
	private String actividad;

	public PersonaEntity() {
		super();
	}

	public PersonaEntity(String rucCi, String nombre, String actividad) {
		super();
		this.rucCi = rucCi;
		Nombre = nombre;
		this.actividad = actividad;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRucCi() {
		return rucCi;
	}

	public void setRucCi(String rucCi) {
		this.rucCi = rucCi;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getActividad() {
		return actividad;
	}

	public void setActividad(String actividad) {
		this.actividad = actividad;
	}

}
