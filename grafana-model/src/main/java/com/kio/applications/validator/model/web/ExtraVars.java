/*
 * ****************************************************
 * * Grafana *
 * * KIO Networks *
 * * @Author Julio Galindo *
 * ****************************************************
 */

package com.kio.applications.validator.model.web;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;

// TODO: Auto-generated Javadoc
/**
 * The Class ExtraVars.
 */

public class ExtraVars implements Serializable {

	/** The Constant serialVersionUID. */
	private final static long serialVersionUID = -6266287387738858329L;

	/** The playbook start timestamp. */
	private Integer playbookStartTimestamp;

	/** The playbook end timestamp. */
	private Integer playbookEndTimestamp;

	/** The woid. */
	private String woid;

	/** The platform. */
	private String platform;

	/** The bot name. */
	private String botName;

	/** The type of automation. */
	private String typeOfAutomation;

	/** The type of develop. */
	private String typeOfDevelop;

	/** The type of execution. */
	private String typeOfExecution;

	/** The technological domain. */
	private String technologicalDomain;

	/** The technology. */
	private String technology;

	/** The level of specialization. */
	private String levelOfSpecialization;

	/** The type of task. */
	private String typeOfTask;

	/** The manual time. */
	private Float manualTime;

	/** The total impacted cis. */
	private Integer totalImpactedCis;

	/** The total cis. */
	private Integer totalCis;

	/** The client. */
	private String client;

	/** The organization. */
	private String organization;

	/**
	 * Gets the client.
	 *
	 * @return the client
	 */
	public String getClient() {
		return client;
	}

	/**
	 * Gets the level of specialization.
	 *
	 * @return the level of specialization
	 */
	public String getLevelOfSpecialization() {
		return levelOfSpecialization;
	}

	/**
	 * Gets the manual time.
	 *
	 * @return the manual time
	 */
	public Float getManualTime() {
		return manualTime;
	}

	/**
	 * Gets the organization.
	 *
	 * @return the organization
	 */
	public String getOrganization() {
		return organization;
	}

	/**
	 * Gets the platform.
	 *
	 * @return the platform
	 */
	public String getPlatform() {
		return platform;
	}

	/**
	 * Gets the playbook end timestamp.
	 *
	 * @return the playbook end timestamp
	 */
	public Integer getPlaybookEndTimestamp() {
		return playbookEndTimestamp;
	}

	/**
	 * Gets the playbook start timestamp.
	 *
	 * @return the playbook start timestamp
	 */
	public Integer getPlaybookStartTimestamp() {
		return playbookStartTimestamp;
	}

	/**
	 * Gets the technological domain.
	 *
	 * @return the technological domain
	 */
	public String getTechnologicalDomain() {
		return technologicalDomain;
	}

	/**
	 * Gets the technology.
	 *
	 * @return the technology
	 */
	public String getTechnology() {
		return technology;
	}

	/**
	 * Gets the total cis.
	 *
	 * @return the total cis
	 */
	public Integer getTotalCis() {
		return totalCis;
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
	 * Gets the type of automation.
	 *
	 * @return the type of automation
	 */
	public String getTypeOfAutomation() {
		return typeOfAutomation;
	}

	/**
	 * Gets the type of develop.
	 *
	 * @return the type of develop
	 */
	public String getTypeOfDevelop() {
		return typeOfDevelop;
	}

	/**
	 * Gets the type of execution.
	 *
	 * @return the type of execution
	 */
	public String getTypeOfExecution() {
		return typeOfExecution;
	}

	/**
	 * Gets the type of task.
	 *
	 * @return the type of task
	 */
	public String getTypeOfTask() {
		return typeOfTask;
	}

	/**
	 * Gets the woid.
	 *
	 * @return the woid
	 */
	public String getWoid() {
		return woid;
	}

	/**
	 * Gets the bot name.
	 *
	 * @return the bot name
	 */
	public String getBotName() {
		return botName;
	}

	/**
	 * Sets the client.
	 *
	 * @param client the new client
	 */
	@XmlElement(name = "client")
	public void setClient(String client) {
		this.client = client;
	}

	/**
	 * Sets the level of specialization.
	 *
	 * @param levelOfSpecialization the new level of specialization
	 */
	@XmlElement(name = "level_of_specialization")
	public void setLevelOfSpecialization(String levelOfSpecialization) {
		this.levelOfSpecialization = levelOfSpecialization;
	}

	/**
	 * Sets the manual time.
	 *
	 * @param manualTime the new manual time
	 */
	@XmlElement(name = "manual_time")
	public void setManualTime(Float manualTime) {
		this.manualTime = manualTime;
	}

	/**
	 * Sets the organization.
	 *
	 * @param organization the new organization
	 */
	@XmlElement(name = "organization")
	public void setOrganization(String organization) {
		this.organization = organization;
	}

	/**
	 * Sets the platform.
	 *
	 * @param platform the new platform
	 */
	@XmlElement(name = "platform")
	public void setPlatform(String platform) {
		this.platform = platform;
	}

	/**
	 * Sets the playbook end timestamp.
	 *
	 * @param playbookEndTimestamp the new playbook end timestamp
	 */
	@XmlElement(name = "playbook_end_timestamp")
	public void setPlaybookEndTimestamp(Integer playbookEndTimestamp) {
		this.playbookEndTimestamp = playbookEndTimestamp;
	}

	/**
	 * Sets the playbook start timestamp.
	 *
	 * @param playbookStartTimestamp the new playbook start timestamp
	 */
	@XmlElement(name = "playbook_start_timestamp")
	public void setPlaybookStartTimestamp(Integer playbookStartTimestamp) {
		this.playbookStartTimestamp = playbookStartTimestamp;
	}

	/**
	 * Sets the technological domain.
	 *
	 * @param technologicalDomain the new technological domain
	 */
	@XmlElement(name = "technological_domain")
	public void setTechnologicalDomain(String technologicalDomain) {
		this.technologicalDomain = technologicalDomain;
	}

	/**
	 * Sets the technology.
	 *
	 * @param technology the new technology
	 */
	@XmlElement(name = "technology")
	public void setTechnology(String technology) {
		this.technology = technology;
	}

	/**
	 * Sets the total cis.
	 *
	 * @param totalCis the new total cis
	 */
	@XmlElement(name = "total_cis")
	public void setTotalCis(Integer totalCis) {
		this.totalCis = totalCis;
	}

	/**
	 * Sets the total impacted cis.
	 *
	 * @param totalImpactedCis the new total impacted cis
	 */
	@XmlElement(name = "total_impacted_cis")
	public void setTotalImpactedCis(Integer totalImpactedCis) {
		this.totalImpactedCis = totalImpactedCis;
	}

	/**
	 * Sets the type of automation.
	 *
	 * @param typeOfAutomation the new type of automation
	 */
	@XmlElement(name = "type_of_automation")
	public void setTypeOfAutomation(String typeOfAutomation) {
		this.typeOfAutomation = typeOfAutomation;
	}

	/**
	 * Sets the type of develop.
	 *
	 * @param typeOfDevelop the new type of develop
	 */
	@XmlElement(name = "type_of_develop")
	public void setTypeOfDevelop(String typeOfDevelop) {
		this.typeOfDevelop = typeOfDevelop;
	}

	/**
	 * Sets the type of execution.
	 *
	 * @param typeOfExecution the new type of execution
	 */
	@XmlElement(name = "type_of_execution")
	public void setTypeOfExecution(String typeOfExecution) {
		this.typeOfExecution = typeOfExecution;
	}

	/**
	 * Sets the type of task.
	 *
	 * @param typeOfTask the new type of task
	 */
	@XmlElement(name = "type_of_task")
	public void setTypeOfTask(String typeOfTask) {
		this.typeOfTask = typeOfTask;
	}

	/**
	 * Sets the woid.
	 *
	 * @param woid the new woid
	 */
	@XmlElement(name = "woid")
	public void setWoid(String woid) {
		this.woid = woid;
	}

	/**
	 * Sets the bot name.
	 *
	 * @param botName the new bot name
	 */
	@XmlElement(name = "botName")
	public void setBotName(String botName) {
		this.botName = botName;
	}

}
