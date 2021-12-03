/*
* ****************************************************
* * Grafana *
* * KIO Networks *
* * @Author Julio Galindo *
* ****************************************************
*/
package com.kio.applications.validator.model;

/**
 * The Class Management.
 */
public class Management {

	/** The id. */
	private Integer id;

	/** The name. */
	private String name;

	/** The descr. */
	private String descr;

	/** The id unidad negocio. */
	private Integer idUnidadNegocio;

	/**
	 * Gets the descr.
	 *
	 * @return the descr
	 */
	public String getDescr() {
		return descr;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Gets the id unidad negocio.
	 *
	 * @return the id unidad negocio
	 */
	public Integer getIdUnidadNegocio() {
		return idUnidadNegocio;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the descr.
	 *
	 * @param descr the new descr
	 */
	public void setDescr(String descr) {
		this.descr = descr == null ? null : descr.trim();
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Sets the id unidad negocio.
	 *
	 * @param idUnidadNegocio the new id unidad negocio
	 */
	public void setIdUnidadNegocio(Integer idUnidadNegocio) {
		this.idUnidadNegocio = idUnidadNegocio;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}
}