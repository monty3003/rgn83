package py.com.renta.web.bean;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import py.com.renta.comprobante.boundary.ComprobanteService;
import py.com.renta.comprobante.boundary.PersonaService;
import py.com.renta.comprobante.entity.ComprobanteEntity;
import py.com.renta.persona.entity.PersonaEntity;

@ManagedBean(name = "cargarBean")
@SessionScoped
public class CargarComprobanteBean implements Serializable {
	private static final long serialVersionUID = 1L;
	@EJB(beanName = "comprobanteService", lookup = "java:app/renta-api/ComprobanteService")
	private ComprobanteService comprobanteService;
	@EJB(beanName = "personaService", lookup = "java:app/renta-api/PersonaService")
	private PersonaService personaService;
	private ComprobanteEntity entity;
	private String fechaEmision;
	private String emisor;
	private String tipo;
	private Boolean ingreso;
	private PersonaEntity emisorEntity;
	private String numeroDocumento;
	private String timbrado;
	private Integer monto;
	private Integer totalIVA;
	private Integer montoDocumento;
	private PersonaEntity titularDocumento;
	private String observacion;
	private Date fechaCreacion;
	private Date fechaDocumento;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
	private List<ComprobanteEntity> listaComprobantesCargados;

	@PostConstruct
	void init() {
		listaComprobantesCargados = new ArrayList<ComprobanteEntity>();
		emisorEntity=new PersonaEntity();
	}

	public String nuevoComprobante() {

		return "cargarComprobante";
	}

	public void validarEmisor(FacesContext context, UIComponent component, Object value) {
		emisorEntity = personaService.findByRuc((String) value);
		if (emisorEntity == null) {
			emisorEntity = new PersonaEntity();
			emisorEntity.setRucCi((String) value);
		}
	}

	public String guardarComprobante() {
		try {
			fechaDocumento = sdf.parse(fechaEmision);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fechaCreacion = new Date();
		entity = new ComprobanteEntity(ingreso, fechaDocumento, emisorEntity, numeroDocumento, timbrado, tipo, monto,
				totalIVA, montoDocumento, titularDocumento, observacion, fechaCreacion);
		entity = comprobanteService.guardar(entity);
		listaComprobantesCargados.add(entity);
		return nuevoComprobante();
	}

	public ComprobanteEntity getEntity() {
		return entity;
	}

	public void setEntity(ComprobanteEntity entity) {
		this.entity = entity;
	}

	public String getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(String fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public String getEmisor() {
		return emisor;
	}

	public void setEmisor(String emisor) {
		this.emisor = emisor;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Boolean getIngreso() {
		return ingreso;
	}

	public void setIngreso(Boolean ingreso) {
		this.ingreso = ingreso;
	}

	public PersonaEntity getEmisorEntity() {
		return emisorEntity;
	}

	public void setEmisorEntity(PersonaEntity emisorEntity) {
		this.emisorEntity = emisorEntity;
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

	public List<ComprobanteEntity> getListaComprobantesCargados() {
		return listaComprobantesCargados;
	}

	public void setListaComprobantesCargados(List<ComprobanteEntity> listaComprobantesCargados) {
		this.listaComprobantesCargados = listaComprobantesCargados;
	}

}
