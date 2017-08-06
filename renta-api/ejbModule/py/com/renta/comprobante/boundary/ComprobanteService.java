package py.com.renta.comprobante.boundary;

import java.io.Serializable;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import py.com.renta.comprobante.entity.ComprobanteEntity;

@Stateless
public class ComprobanteService implements Serializable {
	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName = "rentaPU")
	private EntityManager em;

	public ComprobanteEntity guardar(ComprobanteEntity entity) {
		if (entity.getId() == null) {
			em.persist(entity);
		} else {
			em.merge(entity);
		}
		em.flush();
		return entity;
	}

}
