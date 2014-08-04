package cl.corfo.webServiceSQL.services.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.jws.WebService;

import cl.corfo.webServiceSQL.dao.TextosDAO;
import cl.corfo.webServiceSQL.exceptions.WebServiceSQLBusinessException;
import cl.corfo.webServiceSQL.filters.FiltroTexto;
import cl.corfo.webServiceSQL.model.AdobeTexto;
import cl.corfo.webServiceSQL.services.TextoServicesLocal;
import cl.corfo.webServiceSQL.services.TextoServicesRemote;
import cl.corfo.webServiceSQL.services.TextoServicesWS;

@Stateless(name = "textoServicesBean")
@WebService(name="Textos", targetNamespace = "http://services.webServiceSQL.corfo.cl/", endpointInterface = "cl.corfo.webServiceSQL.services.TextoServicesWS",
			portName = "TextosServicePort", serviceName = "TextosService")
public class TextoServicesBean implements TextoServicesLocal, TextoServicesRemote, TextoServicesWS {

	//public static final Logger log = Logger.getLogger(TextoServicesBean.class);
	
	@EJB(name="textosDAO", mappedName="textosDAO")
	private TextosDAO textoDAO;
			
	public TextoServicesBean() {
		super();
	}

	public AdobeTexto guardarTexto(AdobeTexto texto) throws WebServiceSQLBusinessException {
		try {
			return this.textoDAO.save(texto);
		} catch (Exception e) {
			//log.error(e.getMessage());
			throw new WebServiceSQLBusinessException(e.getMessage());
		}
	}
	
	public AdobeTexto actualizarTexto(AdobeTexto texto) throws WebServiceSQLBusinessException {
		try {
			return this.textoDAO.update(texto);
		} catch (Exception e) {
			//log.error(e.getMessage());
			throw new WebServiceSQLBusinessException(e.getMessage());
		}
	}
	
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public AdobeTexto buscarTexto(Integer id) throws WebServiceSQLBusinessException {
		try {			
			return  this.textoDAO.findById(id);					
		} catch (Exception e) {
			//log.error(e.getMessage());
			throw new WebServiceSQLBusinessException(e.getMessage());
		}
	}
	
	public void eliminarTexto(AdobeTexto texto) throws WebServiceSQLBusinessException {
		try {
			this.textoDAO.remove(texto);
		} catch (Exception e) {
			//log.error(e.getMessage());
			throw new WebServiceSQLBusinessException(e.getMessage());
		}
	}
	
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<AdobeTexto> buscarTextos(FiltroTexto filtro) throws WebServiceSQLBusinessException {
		try{			
			return this.textoDAO.findByCriteria(filtro);
		} catch (Exception e) {
			//log.error(e.getMessage());
			throw new WebServiceSQLBusinessException(e.getMessage());
		}
	}
	
	
}
