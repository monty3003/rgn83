package py.com.renta.web.bean;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import py.com.renta.comprobante.boundary.ComprobanteService;
import py.com.renta.comprobante.entity.ComprobanteEntity;

@ManagedBean(name = "cargarBean")
@ViewScoped
public class CargarComprobanteBean implements Serializable {
	private static final long serialVersionUID = 1L;
	@EJB(beanName = "comprobanteService", lookup = "java:app/ComprobanteService")
	private ComprobanteService comprobanteService;
	private ComprobanteEntity entity;

	public String guardarComprobante() {
		entity = comprobanteService.guardar(entity);
		return "cargarComprobante";
	}

}
