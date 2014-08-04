package cl.corfo.webServiceSQL.dao;

import java.util.List;

import cl.corfo.webServiceSQL.filters.FiltroTexto;
import cl.corfo.webServiceSQL.model.AdobeTexto;
import cl.seis.generic.dao.GenericDAO;

public interface TextosDAO extends GenericDAO<AdobeTexto, Integer, FiltroTexto> {
	public List<AdobeTexto> findTextos(FiltroTexto filtro);
}
