/*
* ****************************************************
* * Grafana *
* * KIO Networks *
* * @Author Julio Galindo *
* ****************************************************
*/

package com.kio.applications.validator.model.web;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

// TODO: Auto-generated Javadoc
/**
 * The Class ExtraVars.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "playbook_start_timestamp", "woid", "platform", "type_of_automation", "type_of_develop",
		"type_of_execution", "technological_domain", "technology", "level_of_specialization", "type_of_task",
		"manual_time", "total_impacted_cis", "total_cis", "client", "organization" })
public class ExtraVars implements Serializable {

	/** The playbook start timestamp. */
	@JsonProperty("playbook_start_timestamp")
	private Integer playbookStartTimestamp;

	/** The woid. */
	@JsonProperty("woid")
	private String woid;

	/** The platform. */
	@JsonProperty("platform")
	private String platform;

	/** The type of automation. */
	@JsonProperty("type_of_automation")
	private String typeOfAutomation;

	/** The type of develop. */
	@JsonProperty("type_of_develop")
	private String typeOfDevelop;

	/** The type of execution. */
	@JsonProperty("type_of_execution")
	private String typeOfExecution;

	/** The technological domain. */
	@JsonProperty("technological_domain")
	private String technologicalDomain;

	/** The technology. */
	@JsonProperty("technology")
	private String technology;

	/** The level of specialization. */
	@JsonProperty("level_of_specialization")
	private String levelOfSpecialization;

	/** The type of task. */
	@JsonProperty("type_of_task")
	private String typeOfTask;

	/** The manual time. */
	@JsonProperty("manual_time")
	private Float manualTime;

	/** The total impacted cis. */
	@JsonProperty("total_impacted_cis")
	private Integer totalImpactedCis;

	/** The total cis. */
	@JsonProperty("total_cis")
	private Integer totalCis;

	/** The client. */
	@JsonProperty("client")
	private String client;

	/** The organization. */
	@JsonProperty("organization")
	private String organization;

	/** The Constant serialVersionUID. */
	private final static long serialVersionUID = -6266287387738858329L;

	/**
	 * Gets the playbook start timestamp.
	 *
	 * @return the playbook start timestamp
	 */
	@JsonProperty("playbook_start_timestamp")
	public Integer getPlaybookStartTimestamp() {
		return playbookStartTimestamp;
	}

	/**
	 * Sets the playbook start timestamp.
	 *
	 * @param playbookStartTimestamp the new playbook start timestamp
	 */
	@JsonProperty("playbook_start_timestamp")
	public void setPlaybookStartTimestamp(Integer playbookStartTimestamp) {
		this.playbookStartTimestamp = playbookStartTimestamp;
	}

	/**
	 * Gets the woid.
	 *
	 * @return the woid
	 */
	@JsonProperty("woid")
	public String getWoid() {
		return woid;
	}

	/**
	 * Sets the woid.
	 *
	 * @param woid the new woid
	 */
	@JsonProperty("woid")
	public void setWoid(String woid) {
		this.woid = woid;
	}

	/**
	 * Gets the platform.
	 *
	 * @return the platform
	 */
	@JsonProperty("platform")
	public String getPlatform() {
		return platform;
	}

	/**
	 * Sets the platform.
	 *
	 * @param platform the new platform
	 */
	@JsonProperty("platform")
	public void setPlatform(String platform) {
		this.platform = platform;
	}

	/**
	 * Gets the type of automation.
	 *
	 * @return the type of automation
	 */
	@JsonProperty("type_of_automation")
	public String getTypeOfAutomation() {
		return typeOfAutomation;
	}

	/**
	 * Sets the type of automation.
	 *
	 * @param typeOfAutomation the new type of automation
	 */
	@JsonProperty("type_of_automation")
	public void setTypeOfAutomation(String typeOfAutomation) {
		this.typeOfAutomation = typeOfAutomation;
	}

	/**
	 * Gets the type of develop.
	 *
	 * @return the type of develop
	 */
	@JsonProperty("type_of_develop")
	public String getTypeOfDevelop() {
		return typeOfDevelop;
	}

	/**
	 * Sets the type of develop.
	 *
	 * @param typeOfDevelop the new type of develop
	 */
	@JsonProperty("type_of_develop")
	public void setTypeOfDevelop(String typeOfDevelop) {
		this.typeOfDevelop = typeOfDevelop;
	}

	/**
	 * Gets the type of execution.
	 *
	 * @return the type of execution
	 */
	@JsonProperty("type_of_execution")
	public String getTypeOfExecution() {
		return typeOfExecution;
	}

	/**
	 * Sets the type of execution.
	 *
	 * @param typeOfExecution the new type of execution
	 */
	@JsonProperty("type_of_execution")
	public void setTypeOfExecution(String typeOfExecution) {
		this.typeOfExecution = typeOfExecution;
	}

	/**
	 * Gets the technological domain.
	 *
	 * @return the technological domain
	 */
	@JsonProperty("technological_domain")
	public String getTechnologicalDomain() {
		return technologicalDomain;
	}

	/**
	 * Sets the technological domain.
	 *
	 * @param technologicalDomain the new technological domain
	 */
	@JsonProperty("technological_domain")
	public void setTechnologicalDomain(String technologicalDomain) {
		this.technologicalDomain = technologicalDomain;
	}

	@JsonProperty("technology")
	public String getTechnology() {
		return technology;
	}

	@JsonProperty("technology")
	public void setTechnology(String technology) {
		this.technology = technology;
	}

	/**
	 * Gets the level of specialization.
	 *
	 * @return the level of specialization
	 */
	@JsonProperty("level_of_specialization")
	public String getLevelOfSpecialization() {
		return levelOfSpecialization;
	}

	/**
	 * Sets the level of specialization.
	 *
	 * @param levelOfSpecialization the new level of specialization
	 */
	@JsonProperty("level_of_specialization")
	public void setLevelOfSpecialization(String levelOfSpecialization) {
		this.levelOfSpecialization = levelOfSpecialization;
	}

	/**
	 * Gets the type of task.
	 *
	 * @return the type of task
	 */
	@JsonProperty("type_of_task")
	public String getTypeOfTask() {
		return typeOfTask;
	}

	/**
	 * Sets the type of task.
	 *
	 * @param typeOfTask the new type of task
	 */
	@JsonProperty("type_of_task")
	public void setTypeOfTask(String typeOfTask) {
		this.typeOfTask = typeOfTask;
	}

	/**
	 * Gets the manual time.
	 *
	 * @return the manual time
	 */
	@JsonProperty("manual_time")
	public Float getManualTime() {
		return manualTime;
	}

	/**
	 * Sets the manual time.
	 *
	 * @param manualTime the new manual time
	 */
	@JsonProperty("manual_time")
	public void setManualTime(Float manualTime) {
		this.manualTime = manualTime;
	}

	/**
	 * Gets the total impacted cis.
	 *
	 * @return the total impacted cis
	 */
	@JsonProperty("total_impacted_cis")
	public Integer getTotalImpactedCis() {
		return totalImpactedCis;
	}

	/**
	 * Sets the total impacted cis.
	 *
	 * @param totalImpactedCis the new total impacted cis
	 */
	@JsonProperty("total_impacted_cis")
	public void setTotalImpactedCis(Integer totalImpactedCis) {
		this.totalImpactedCis = totalImpactedCis;
	}

	/**
	 * Gets the total cis.
	 *
	 * @return the total cis
	 */
	@JsonProperty("total_cis")
	public Integer getTotalCis() {
		return totalCis;
	}

	/**
	 * Sets the total cis.
	 *
	 * @param totalCis the new total cis
	 */
	@JsonProperty("total_cis")
	public void setTotalCis(Integer totalCis) {
		this.totalCis = totalCis;
	}

	/**
	 * Gets the client.
	 *
	 * @return the client
	 */
	@JsonProperty("client")
	public String getClient() {
		return client;
	}

	/**
	 * Sets the client.
	 *
	 * @param client the new client
	 */
	@JsonProperty("client")
	public void setClient(String client) {
		this.client = client;
	}

	/**
	 * Gets the organization.
	 *
	 * @return the organization
	 */
	@JsonProperty("organization")
	public String getOrganization() {
		return organization;
	}

	/**
	 * Sets the organization.
	 *
	 * @param organization the new organization
	 */
	@JsonProperty("organization")
	public void setOrganization(String organization) {
		this.organization = organization;
	}

}
