package cl.corfo.webServiceSQL.dao.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import cl.corfo.webServiceSQL.dao.TextosDAO;
import cl.corfo.webServiceSQL.filters.FiltroTexto;
import cl.corfo.webServiceSQL.model.AdobeTexto;
import cl.seis.generic.dao.GenericDAOImpl;

@Stateless
@Named(value = "textosDAO")
public class TextosDAOImpl extends GenericDAOImpl<AdobeTexto, Integer, FiltroTexto> implements TextosDAO {
	
	@PersistenceContext(name = "WebServiceSQL-pu")
	private EntityManager em;
	
	
	public TextosDAOImpl() {
		super(AdobeTexto.class);		
	}

	@Override
	public List<AdobeTexto> findTextos(FiltroTexto filtro) {		
		return super.findByCriteria(filtro);
	}
	
	@Override
	protected CriteriaQuery<AdobeTexto> createFilter(FiltroTexto filtro) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		//Predicate restricciones = null, condicion = null;
		
		CriteriaQuery<AdobeTexto> cq = cb.createQuery(AdobeTexto.class);
		Root<AdobeTexto> texto = cq.from(AdobeTexto.class);
		cq.select(texto);
					
		/*if ((filtro.getCodigos() != null) && !filtro.getCodigos().isEmpty()) {
			condicion = aerolinea.get(SacAerolinea_.codigo).in(filtro.getCodigos());
			
			restricciones = condicion;
		}*/
		
		/*if ((filtro.getCodigoCliente() != null) && !"".equals(filtro.getCodigoCliente().trim())) {
			condicion = cb.equal(aerolinea.get(SacAerolinea_.cliente).get(SacCliente_.clntCcliente),filtro.getCodigoCliente());
			
			if (restricciones == null)
				restricciones = condicion;
			else 
				restricciones = cb.and(restricciones, condicion);
		}*/		
		
		/*if (restricciones != null)
			cq.where(restricciones);*/
		
		return cq;
	}
	
	@PostConstruct
	void configuration() {
		super.entityManager = em;
	}
}
