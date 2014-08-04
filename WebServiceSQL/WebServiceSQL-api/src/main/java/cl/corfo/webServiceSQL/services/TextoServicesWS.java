package cl.corfo.webServiceSQL.services;

import java.util.List;

import javax.jws.WebService;

import cl.corfo.webServiceSQL.exceptions.WebServiceSQLBusinessException;
import cl.corfo.webServiceSQL.filters.FiltroTexto;
import cl.corfo.webServiceSQL.model.AdobeTexto;

@WebService
public interface TextoServicesWS {
	
	public AdobeTexto guardarTexto(AdobeTexto adobeTexto) throws WebServiceSQLBusinessException;
	
	public AdobeTexto actualizarTexto(AdobeTexto adobeTexto) throws WebServiceSQLBusinessException;
	
	public AdobeTexto buscarTexto(Integer id) throws WebServiceSQLBusinessException;
	
	public void eliminarTexto(AdobeTexto adobeTexto) throws WebServiceSQLBusinessException;

	public List<AdobeTexto> buscarTextos(FiltroTexto filtro) throws WebServiceSQLBusinessException;
}
