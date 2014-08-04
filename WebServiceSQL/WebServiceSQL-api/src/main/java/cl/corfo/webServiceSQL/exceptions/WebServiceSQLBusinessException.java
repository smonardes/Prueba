package cl.corfo.webServiceSQL.exceptions;

import javax.ejb.ApplicationException;

@ApplicationException(rollback = true)
public class WebServiceSQLBusinessException extends Exception {	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1156355327414246514L;

	public WebServiceSQLBusinessException(String msg){
		super(msg);
	}
}
