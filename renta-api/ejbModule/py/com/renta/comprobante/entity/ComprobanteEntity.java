package py.com.renta.comprobante.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;

import py.com.renta.persona.entity.PersonaEntity;

@Entity
@Table(name = "comprobante")
public class ComprobanteEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "ingreso", nullable = false)
	private Boolean ingreso;
	@Column(name = "fecha_doc", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date fechaDocumento;
	@JoinColumn(name = "emisor", referencedColumnName = "id", nullable = false, insertable = true, updatable = true)
	@ManyToOne(optional = false)
	private PersonaEntity emisor;
	@Column(name = "numero_doc", length = 50, nullable = false)
	private String numeroDocumento;
	@Column(name = "timbrado", length = 20, nullable = true)
	private String timbrado;
	@Column(name = "tip_doc", length = 3, nullable = false)
	private String tipoDocumento;
	@Column(name = "monto", nullable = false)
	@Min(value = 1, message = "Valor debe ser positivo")
	private Integer monto;
	@Column(name = "total_iva", nullable = false)
	@Min(value = 0, message = "Valor debe ser positivo")
	private Integer totalIVA;
	@Column(name = "monto_doc", nullable = false)
	@Min(value = 1, message = "Valor debe ser positivo")
	private Integer montoDocumento;
	@JoinColumn(name = "titular", referencedColumnName = "id", nullable = false, insertable = true, updatable = true)
	@ManyToOne(optional = false)
	private PersonaEntity titularDocumento;
	@Column(name = "observacion", length = 150, nullable = true)
	private String observacion;
	@Column(name = "fecha_creacion", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date fechaCreacion;

	public ComprobanteEntity() {
		super();
	}

	public ComprobanteEntity(Boolean ingreso, Date fechaDocumento, PersonaEntity emisor, String numeroDocumento,
			String timbrado, String tipoDocumento, Integer monto, Integer totalIVA, Integer montoDocumento,
			PersonaEntity titularDocumento, String observacion, Date fechaCreacion) {
		super();
		this.ingreso = ingreso;
		this.fechaDocumento = fechaDocumento;
		this.emisor = emisor;
		this.numeroDocumento = numeroDocumento;
		this.timbrado = timbrado;
		this.tipoDocumento = tipoDocumento;
		this.monto = monto;
		this.totalIVA = totalIVA;
		this.montoDocumento = montoDocumento;
		this.titularDocumento = titularDocumento;
		this.observacion = observacion;
		this.fechaCreacion = fechaCreacion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getIngreso() {
		return ingreso;
	}

	public void setIngreso(Boolean ingreso) {
		this.ingreso = ingreso;
	}

	public Date getFechaDocumento() {
		return fechaDocumento;
	}

	public void setFechaDocumento(Date fechaDocumento) {
		this.fechaDocumento = fechaDocumento;
	}

	public PersonaEntity getEmisor() {
		return emisor;
	}

	public void setEmisor(PersonaEntity emisor) {
		this.emisor = emisor;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getTimbrado() {
		return timbrado;
	}

	public void setTimbrado(String timbrado) {
		this.timbrado = timbrado;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public Integer getMonto() {
		return monto;
	}

	public void setMonto(Integer monto) {
		this.monto = monto;
	}

	public Integer getTotalIVA() {
		return totalIVA;
	}

	public void setTotalIVA(Integer totalIVA) {
		this.totalIVA = totalIVA;
	}

	public Integer getMontoDocumento() {
		return montoDocumento;
	}

	public void setMontoDocumento(Integer montoDocumento) {
		this.montoDocumento = montoDocumento;
	}

	public PersonaEntity getTitularDocumento() {
		return titularDocumento;
	}

	public void setTitularDocumento(PersonaEntity titularDocumento) {
		this.titularDocumento = titularDocumento;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
}
