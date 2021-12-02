/*
* ****************************************************
* * Grafana *
* * KIO Networks *
* * @Author Julio Galindo *
* ****************************************************
*/
package com.kio.applications.validator.model;

/**
 * The Class OperativeCatalog.
 */
public class OperativeCatalog {

	/** The id. */
	private Integer id;

	/** The catalogo. */
	private Integer catalogo = 1;

	/** The catnivel 1. */
	private Integer catnivel1;

	/** The catnivel 2. */
	private Integer catnivel2;

	/** The catnivel 3. */
	private Integer catnivel3;

	/** The producto. */
	private Integer producto;

	/** The tipo. */
	private Integer tipo = 3;

	/** The automatizable. */
	private Boolean automatizable = true;

	/** The tiempominutos. */
	private Float tiempominutos = (float) 0.0;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Integer getId() {
		return id;
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
	 * Gets the catalogo.
	 *
	 * @return the catalogo
	 */
	public Integer getCatalogo() {
		return catalogo;
	}

	/**
	 * Sets the catalogo.
	 *
	 * @param catalogo the new catalogo
	 */
	public void setCatalogo(Integer catalogo) {
		this.catalogo = catalogo;
	}

	/**
	 * Gets the catnivel 1.
	 *
	 * @return the catnivel 1
	 */
	public Integer getCatnivel1() {
		return catnivel1;
	}

	/**
	 * Sets the catnivel 1.
	 *
	 * @param catnivel1 the new catnivel 1
	 */
	public void setCatnivel1(Integer catnivel1) {
		this.catnivel1 = catnivel1;
	}

	/**
	 * Gets the catnivel 2.
	 *
	 * @return the catnivel 2
	 */
	public Integer getCatnivel2() {
		return catnivel2;
	}

	/**
	 * Sets the catnivel 2.
	 *
	 * @param catnivel2 the new catnivel 2
	 */
	public void setCatnivel2(Integer catnivel2) {
		this.catnivel2 = catnivel2;
	}

	/**
	 * Gets the catnivel 3.
	 *
	 * @return the catnivel 3
	 */
	public Integer getCatnivel3() {
		return catnivel3;
	}

	/**
	 * Sets the catnivel 3.
	 *
	 * @param catnivel3 the new catnivel 3
	 */
	public void setCatnivel3(Integer catnivel3) {
		this.catnivel3 = catnivel3;
	}

	/**
	 * Gets the producto.
	 *
	 * @return the producto
	 */
	public Integer getProducto() {
		return producto;
	}

	/**
	 * Sets the producto.
	 *
	 * @param producto the new producto
	 */
	public void setProducto(Integer producto) {
		this.producto = producto;
	}

	/**
	 * Gets the tipo.
	 *
	 * @return the tipo
	 */
	public Integer getTipo() {
		return tipo;
	}

	/**
	 * Sets the tipo.
	 *
	 * @param tipo the new tipo
	 */
	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	/**
	 * Gets the automatizable.
	 *
	 * @return the automatizable
	 */
	public Boolean getAutomatizable() {
		return automatizable;
	}

	/**
	 * Sets the automatizable.
	 *
	 * @param automatizable the new automatizable
	 */
	public void setAutomatizable(Boolean automatizable) {
		this.automatizable = automatizable;
	}

	/**
	 * Gets the tiempominutos.
	 *
	 * @return the tiempominutos
	 */
	public Float getTiempominutos() {
		return tiempominutos;
	}

	/**
	 * Sets the tiempominutos.
	 *
	 * @param tiempominutos the new tiempominutos
	 */
	public void setTiempominutos(Float tiempominutos) {
		this.tiempominutos = tiempominutos;
	}
}