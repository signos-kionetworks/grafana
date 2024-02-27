/*
 * ****************************************************
 * * Grafana *
 * * KIO Networks *
 * * @Author Julio Galindo *
 * ****************************************************
 */

package com.kio.applications.validator.model.web;

import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;


/**
 * The Class ExtraVars.
 */
public class ExtraVars implements Serializable {

    /**
     * The Constant serialVersionUID.
     */
    private final static long serialVersionUID = -6266287387738858329L;

    /**
     * The playbook start timestamp.
     */
    private Integer playbookStartTimestamp;

    /**
     * The playbook end timestamp.
     */
    private Integer playbookEndTimestamp;

    /**
     * The woid.
     */
    private String woid;

    /**
     * The platform.
     */
    private String platform;

    /**
     * The bot name.
     */
    private String botName;

    /**
     * The type of automation.
     */
    private String typeOfAutomation;

    /**
     * The type of develop.
     */
    private String typeOfDevelop;

    /**
     * The type of execution.
     */
    private String typeOfExecution;

    /**
     * The technological domain.
     */
    private String technologicalDomain;

    /**
     * The technology.
     */
    private String technology;

    /**
     * The level of specialization.
     */
    private String levelOfSpecialization;

    /**
     * The type of task.
     */
    private String typeOfTask;

    /**
     * The manual time.
     */
    private Float manualTime;

    /**
     * The total impacted cis.
     */
    private Integer totalImpactedCis;

    /**
     * The total cis.
     */
    private Integer totalCis;

    /**
     * The client.
     */
    private String client;

    /**
     * The organization.
     */
    private String organization;

    /**
     * The creator.
     */
    private String creator;

    /**
     * The specialist.
     */
    private String specialist;

    private String source = "";

    private String userAgent = "";

    private String remoteHost = "";

    private String origin = "";
    private String resource_id = "";
    private String resource_name = "";

    /**
     * Gets the bot name.
     *
     * @return the bot name
     */
    public String getBotName() {
        return botName;
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

    /**
     * Gets the client.
     *
     * @return the client
     */
    public String getClient() {
        return client;
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
     * Gets the creator.
     *
     * @return the creator
     */
    public String getCreator() {
        return creator;
    }

    /**
     * Sets the creator.
     *
     * @param creator the new creator
     */
    @XmlElement(name = "creator")
    public void setCreator(String creator) {
        this.creator = creator;
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
     * Sets the level of specialization.
     *
     * @param levelOfSpecialization the new level of specialization
     */
    @XmlElement(name = "level_of_specialization")
    public void setLevelOfSpecialization(String levelOfSpecialization) {
        this.levelOfSpecialization = levelOfSpecialization;
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
     * Sets the manual time.
     *
     * @param manualTime the new manual time
     */
    @XmlElement(name = "manual_time")
    public void setManualTime(Float manualTime) {
        this.manualTime = manualTime;
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
     * Sets the organization.
     *
     * @param organization the new organization
     */
    @XmlElement(name = "organization")
    public void setOrganization(String organization) {
        this.organization = organization;
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
     * Sets the platform.
     *
     * @param platform the new platform
     */
    @XmlElement(name = "platform")
    public void setPlatform(String platform) {
        this.platform = platform;
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
     * Sets the playbook end timestamp.
     *
     * @param playbookEndTimestamp the new playbook end timestamp
     */
    @XmlElement(name = "playbook_end_timestamp")
    public void setPlaybookEndTimestamp(Integer playbookEndTimestamp) {
        this.playbookEndTimestamp = playbookEndTimestamp;
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
     * Sets the playbook start timestamp.
     *
     * @param playbookStartTimestamp the new playbook start timestamp
     */
    @XmlElement(name = "playbook_start_timestamp")
    public void setPlaybookStartTimestamp(Integer playbookStartTimestamp) {
        this.playbookStartTimestamp = playbookStartTimestamp;
    }

    /**
     * Gets the specialist.
     *
     * @return the specialist
     */
    public String getSpecialist() {
        return specialist;
    }

    /**
     * Sets the specialist.
     *
     * @param specialist the new specialist
     */
    @XmlElement(name = "specialist")
    public void setSpecialist(String specialist) {
        this.specialist = specialist;
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
     * Sets the technological domain.
     *
     * @param technologicalDomain the new technological domain
     */
    @XmlElement(name = "technological_domain")
    public void setTechnologicalDomain(String technologicalDomain) {
        this.technologicalDomain = technologicalDomain;
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
     * Sets the technology.
     *
     * @param technology the new technology
     */
    @XmlElement(name = "technology")
    public void setTechnology(String technology) {
        this.technology = technology;
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
     * Sets the total cis.
     *
     * @param totalCis the new total cis
     */
    @XmlElement(name = "total_cis")
    public void setTotalCis(Integer totalCis) {
        this.totalCis = totalCis;
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
    @XmlElement(name = "total_impacted_cis")
    public void setTotalImpactedCis(Integer totalImpactedCis) {
        this.totalImpactedCis = totalImpactedCis;
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
     * Sets the type of automation.
     *
     * @param typeOfAutomation the new type of automation
     */
    @XmlElement(name = "type_of_automation")
    public void setTypeOfAutomation(String typeOfAutomation) {
        this.typeOfAutomation = typeOfAutomation;
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
     * Sets the type of develop.
     *
     * @param typeOfDevelop the new type of develop
     */
    @XmlElement(name = "type_of_develop")
    public void setTypeOfDevelop(String typeOfDevelop) {
        this.typeOfDevelop = typeOfDevelop;
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
     * Sets the type of execution.
     *
     * @param typeOfExecution the new type of execution
     */
    @XmlElement(name = "type_of_execution")
    public void setTypeOfExecution(String typeOfExecution) {
        this.typeOfExecution = typeOfExecution;
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
     * Sets the type of task.
     *
     * @param typeOfTask the new type of task
     */
    @XmlElement(name = "type_of_task")
    public void setTypeOfTask(String typeOfTask) {
        this.typeOfTask = typeOfTask;
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
     * Sets the woid.
     *
     * @param woid the new woid
     */
    @XmlElement(name = "woid")
    public void setWoid(String woid) {
        this.woid = woid;
    }

    /**
     * Gets source.
     *
     * @return the source
     */
    public String getSource() {
        return source;
    }

    /**
     * Sets source.
     *
     * @param source the source
     */
    @XmlElement(name = "source")
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * Gets user agent.
     *
     * @return the user agent
     */
    public String getUserAgent() {
        return userAgent;
    }

    /**
     * Sets user agent.
     *
     * @param userAgent the user agent
     */
    @XmlElement(name = "user_agent")
    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    /**
     * Gets remote host.
     *
     * @return the remote host
     */
    public String getRemoteHost() {
        return remoteHost;
    }

    /**
     * Sets remote host.
     *
     * @param remoteHost the remote host
     */
    @XmlElement(name = "remote_host")
    public void setRemoteHost(String remoteHost) {
        this.remoteHost = remoteHost;
    }


    /**
     * Gets origin.
     *
     * @return the origin
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * Sets origin.
     *
     * @param origin the origin
     */
    @XmlElement(name = "origin")
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    /**
     * Gets resource id.
     *
     * @return the resource id
     */
    public String getResourceId() {
        return resource_id;
    }

    /**
     * Sets resource id.
     *
     * @param resource_id the resource id
     */
    @XmlElement(name = "resource_id")
    public void setResourceId(String resource_id) {
        this.resource_id = resource_id;
    }

    /**
     * Gets resource name.
     *
     * @return the resource name
     */
    public String getResourceName() {
        return resource_name;
    }

    /**
     * Sets resource name.
     *
     * @param resource_name the resource name
     */
    @XmlElement(name = "resource_name")
    public void setResourceName(String resource_name) {
        this.resource_name = resource_name;
    }
}
