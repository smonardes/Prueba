package cl.corfo.webServiceSQL.filters;

import javax.inject.Named;

import cl.corfo.webServiceSQL.model.AdobeTexto;
import cl.seis.generic.filters.FiltroBase;

@Named("filtroTexto")
public class FiltroTexto extends FiltroBase<AdobeTexto> {


	/**
	 * 
	 */
	private static final long serialVersionUID = 8439943477225655929L;
	
	//private String codigoAeronave;
	

	public FiltroTexto() {
		super();
	}

	@Override
	public void limpiar() {
		//this.codigoAeronave = null;
	}

}
