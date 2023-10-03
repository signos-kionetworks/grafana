/*
* ****************************************************
* * Grafana *
* * KIO Networks *
* * @Author Julio Galindo *
* ****************************************************
*/
package com.kio.applications.validator.model;

import java.util.Date;

/**
 * The Class Indicator.
 */
public class Indicator {

	/** The id. */
	private Long id;

	/** The time. */
	private Date time;

	/** The autid. */
	private Long autid;

	/** The autotime. */
	private Float autotime;

	/** The svtime. */
	private Float svtime;

	/** The transactionid. */
	private String transactionid;

	/** The ticketid. */
	private String ticketid = "0";

	/** The svfte. */
	private Float svfte;

	/** The impacted cis. */
	private Integer impactedCis;

	/** The total impacted cis. */
	private Integer totalImpactedCis;

	private float mantime;

	/** The source. */
	private String source;

	/** The userAgent. */
	private String userAgent;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the time.
	 *
	 * @return the time
	 */
	public Date getTime() {
		return time;
	}

	/**
	 * Sets the time.
	 *
	 * @param time the new time
	 */
	public void setTime(Date time) {
		this.time = time;
	}

	/**
	 * Gets the autid.
	 *
	 * @return the autid
	 */
	public Long getAutid() {
		return autid;
	}

	/**
	 * Sets the autid.
	 *
	 * @param autid the new autid
	 */
	public void setAutid(Long autid) {
		this.autid = autid;
	}

	/**
	 * Gets the autotime.
	 *
	 * @return the autotime
	 */
	public Float getAutotime() {
		return autotime;
	}

	/**
	 * Sets the autotime.
	 *
	 * @param autotime the new autotime
	 */
	public void setAutotime(Float autotime) {
		this.autotime = autotime;
	}

	/**
	 * Gets the svtime.
	 *
	 * @return the svtime
	 */
	public Float getSvtime() {
		return svtime;
	}

	/**
	 * Sets the svtime.
	 *
	 * @param svtime the new svtime
	 */
	public void setSvtime(Float svtime) {
		this.svtime = svtime;
	}

	/**
	 * Gets the transactionid.
	 *
	 * @return the transactionid
	 */
	public String getTransactionid() {
		return transactionid;
	}

	/**
	 * Sets the transactionid.
	 *
	 * @param transactionid the new transactionid
	 */
	public void setTransactionid(String transactionid) {
		this.transactionid = transactionid == null ? null : transactionid.trim();
	}

	/**
	 * Gets the ticketid.
	 *
	 * @return the ticketid
	 */
	public String getTicketid() {
		return ticketid;
	}

	/**
	 * Sets the ticketid.
	 *
	 * @param ticketid the new ticketid
	 */
	public void setTicketid(String ticketid) {
		this.ticketid = ticketid == null ? null : ticketid.trim();
	}

	/**
	 * Gets the svfte.
	 *
	 * @return the svfte
	 */
	public Float getSvfte() {
		return svfte;
	}

	/**
	 * Sets the svfte.
	 *
	 * @param svfte the new svfte
	 */
	public void setSvfte(Float svfte) {
		this.svfte = svfte;
	}

	/**
	 * Gets the impacted cis.
	 *
	 * @return the impacted cis
	 */
	public Integer getImpactedCis() {
		return impactedCis;
	}

	/**
	 * Sets the impacted cis.
	 *
	 * @param impactedCis the new impacted cis
	 */
	public void setImpactedCis(Integer impactedCis) {
		this.impactedCis = impactedCis;
	}

	/**
	 * Gets the total impacted cis.
	 *
	 * @return the total impacted cis
	 */
	public Integer getTotalImpactedCis() {
		return totalImpactedCis;
	}

	/**
	 * Sets the total impacted cis.
	 *
	 * @param totalImpactedCis the new total impacted cis
	 */
	public void setTotalImpactedCis(Integer totalImpactedCis) {
		this.totalImpactedCis = totalImpactedCis;
	}

	public float getMantime() {
		return mantime;
	}

	public void setMantime(float mantime) {
		this.mantime = mantime;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source == null ? null : source.trim();
	}

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent == null ? null : userAgent.trim();
	}
}
