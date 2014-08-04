package cl.corfo.webServiceSQL.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_ADBm_Texto")
public class AdobeTexto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3015050880669143736L;

	@Id
	@Column(name = "TEXT_Id", nullable = false)
	private Integer id;

	@Column(name = "TEXT_Texto", nullable = false)
	private String texto;
	
	public AdobeTexto(){
		super();
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	
}
