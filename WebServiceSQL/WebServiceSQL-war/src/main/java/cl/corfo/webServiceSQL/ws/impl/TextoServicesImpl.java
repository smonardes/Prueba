package cl.corfo.webServiceSQL.ws.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.jws.WebService;

import cl.corfo.webServiceSQL.exceptions.WebServiceSQLBusinessException;
import cl.corfo.webServiceSQL.filters.FiltroTexto;
import cl.corfo.webServiceSQL.model.AdobeTexto;
import cl.corfo.webServiceSQL.services.TextoServicesLocal;
import cl.corfo.webServiceSQL.services.TextoServicesWS;

@WebService(name="Textos", targetNamespace = "http://services.webServiceSQL.corfo.cl/", endpointInterface = "cl.corfo.webServiceSQL.services.TextoServicesWS",
			portName = "TextosServicePort", serviceName = "TextosService")
public class TextoServicesImpl /*extends BaseWebServicesImpl*/ implements TextoServicesWS {

	//private Log log = LogFactory.getLog(TextoServicesImpl.class);
	
	@EJB
	private TextoServicesLocal textoServicesLocal;
			
	public TextoServicesImpl() {
		super();
		
		/*try {			
			this.textoServicesRemote = 
					(TextoServicesRemote) ctx.lookup(super.env.getProperty("services.remote.name.aerolineas"));
		} catch (NamingException e) {
			log.error(e.getMessage());
		}*/
	}

	public AdobeTexto guardarTexto(AdobeTexto texto) throws WebServiceSQLBusinessException {
		try {
			return this.textoServicesLocal.guardarTexto(texto);
		} catch (Exception e) {
			//log.error(e.getMessage());
			throw new WebServiceSQLBusinessException(e.getMessage());
		}
	}
	
	public AdobeTexto actualizarTexto(AdobeTexto texto) throws WebServiceSQLBusinessException {
		try {
			return this.textoServicesLocal.actualizarTexto(texto);
		} catch (Exception e) {
			//log.error(e.getMessage());
			throw new WebServiceSQLBusinessException(e.getMessage());
		}
	}
	
	public AdobeTexto buscarTexto(Integer id) throws WebServiceSQLBusinessException {
		try {
			AdobeTexto texto = this.textoServicesLocal.buscarTexto(id);
			
			return texto;					
		} catch (Exception e) {
			//log.error(e.getMessage());
			throw new WebServiceSQLBusinessException(e.getMessage());
		}
	}
	
	public void eliminarTexto(AdobeTexto texto) throws WebServiceSQLBusinessException {
		try {
			this.textoServicesLocal.eliminarTexto(texto);
		} catch (Exception e) {
			//log.error(e.getMessage());
			throw new WebServiceSQLBusinessException(e.getMessage());
		}
	}
	
	public List<AdobeTexto> buscarTextos(FiltroTexto filtro) throws WebServiceSQLBusinessException {
		try {
			List<AdobeTexto> textos = this.textoServicesLocal.buscarTextos(filtro);
			
			return textos;
		} catch (Exception e) {
			//log.error(e.getMessage()); 
			throw new WebServiceSQLBusinessException(e.getMessage());
		}
	}	
	
}
