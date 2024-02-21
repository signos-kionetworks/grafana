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
 * The Class Automation.
 */
public class Automation {

    /**
     * The id.
     */
    private Long id;

    /**
     * The botname.
     */
    private String botname;

    /**
     * The bot descr.
     */
    private String botDescr;

    /**
     * The areaid.
     */
    private Integer areaid;

    /**
     * The suppgroupid.
     */
    private Integer suppgroupid = 0;

    /**
     * The specialistid.
     */
    private Integer specialistid = 0;

    /**
     * The crid.
     */
    private Integer crid = 0;

    /**
     * The clienteid.
     */
    private Integer clienteid;

    /**
     * The platformid.
     */
    private Integer platformid;

    /**
     * The tipoautid.
     */
    private Integer tipoautid;

    /**
     * The functionid.
     */
    private Integer functionid = 0;

    /**
     * The tipoexecid.
     */
    private Integer tipoexecid;

    /**
     * The tipociid.
     */
    private Integer tipociid = 0;

    /**
     * The tecnologiaid.
     */
    private Integer tecnologiaid = 0;

    /**
     * The catopid.
     */
    private Integer catopid;

    /**
     * The dirid.
     */
    private Integer dirid;

    /**
     * The devtypeid.
     */
    private Integer devtypeid;

    /**
     * The manexecs.
     */
    private Float manexecs = (float) 1.0;
    /**
     * The autoexecs.
     */
    private Float autoexecs = (float) 1.0;

    /**
     * The mantime.
     */
    private Float mantime = (float) 0.0;

    /**
     * The registered date.
     */
    private Date registeredDate = new Date();

    /**
     * The aut creator area.
     */
    private String autCreatorArea = "AUTOMATIZACION";

    /**
     * The aut creator user.
     */
    private String autCreatorUser = "automation@kionetworks.com";

    /**
     * The last modified.
     */
    private Date lastModified = new Date();

    /**
     * The aut enabled.
     */
    private Boolean autEnabled = true;

    /**
     * The impacted cis.
     */
    private Integer impactedCis = 0;

    /**
     * The total impacted cis.
     */
    private Integer totalImpactedCis = 0;

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
     * Gets the botname.
     *
     * @return the botname
     */
    public String getBotname() {
        return botname;
    }

    /**
     * Sets the botname.
     *
     * @param botname the new botname
     */
    public void setBotname(String botname) {
        this.botname = botname == null ? null : botname.trim();
    }

    /**
     * Gets the bot descr.
     *
     * @return the bot descr
     */
    public String getBotDescr() {
        return botDescr;
    }

    /**
     * Sets the bot descr.
     *
     * @param botDescr the new bot descr
     */
    public void setBotDescr(String botDescr) {
        this.botDescr = botDescr == null ? null : botDescr.trim();
    }

    /**
     * Gets the areaid.
     *
     * @return the areaid
     */
    public Integer getAreaid() {
        return areaid;
    }

    /**
     * Sets the areaid.
     *
     * @param areaid the new areaid
     */
    public void setAreaid(Integer areaid) {
        this.areaid = areaid;
    }

    /**
     * Gets the suppgroupid.
     *
     * @return the suppgroupid
     */
    public Integer getSuppgroupid() {
        return suppgroupid;
    }

    /**
     * Sets the suppgroupid.
     *
     * @param suppgroupid the new suppgroupid
     */
    public void setSuppgroupid(Integer suppgroupid) {
        this.suppgroupid = suppgroupid;
    }

    /**
     * Gets the specialistid.
     *
     * @return the specialistid
     */
    public Integer getSpecialistid() {
        return specialistid;
    }

    /**
     * Sets the specialistid.
     *
     * @param specialistid the new specialistid
     */
    public void setSpecialistid(Integer specialistid) {
        this.specialistid = specialistid;
    }

    /**
     * Gets the crid.
     *
     * @return the crid
     */
    public Integer getCrid() {
        return crid;
    }

    /**
     * Sets the crid.
     *
     * @param crid the new crid
     */
    public void setCrid(Integer crid) {
        this.crid = crid;
    }

    /**
     * Gets the clienteid.
     *
     * @return the clienteid
     */
    public Integer getClienteid() {
        return clienteid;
    }

    /**
     * Sets the clienteid.
     *
     * @param clienteid the new clienteid
     */
    public void setClienteid(Integer clienteid) {
        this.clienteid = clienteid;
    }

    /**
     * Gets the platformid.
     *
     * @return the platformid
     */
    public Integer getPlatformid() {
        return platformid;
    }

    /**
     * Sets the platformid.
     *
     * @param platformid the new platformid
     */
    public void setPlatformid(Integer platformid) {
        this.platformid = platformid;
    }

    /**
     * Gets the tipoautid.
     *
     * @return the tipoautid
     */
    public Integer getTipoautid() {
        return tipoautid;
    }

    /**
     * Sets the tipoautid.
     *
     * @param tipoautid the new tipoautid
     */
    public void setTipoautid(Integer tipoautid) {
        this.tipoautid = tipoautid;
    }

    /**
     * Gets the functionid.
     *
     * @return the functionid
     */
    public Integer getFunctionid() {
        return functionid;
    }

    /**
     * Sets the functionid.
     *
     * @param functionid the new functionid
     */
    public void setFunctionid(Integer functionid) {
        this.functionid = functionid;
    }

    /**
     * Gets the tipoexecid.
     *
     * @return the tipoexecid
     */
    public Integer getTipoexecid() {
        return tipoexecid;
    }

    /**
     * Sets the tipoexecid.
     *
     * @param tipoexecid the new tipoexecid
     */
    public void setTipoexecid(Integer tipoexecid) {
        this.tipoexecid = tipoexecid;
    }

    /**
     * Gets the tipociid.
     *
     * @return the tipociid
     */
    public Integer getTipociid() {
        return tipociid;
    }

    /**
     * Sets the tipociid.
     *
     * @param tipociid the new tipociid
     */
    public void setTipociid(Integer tipociid) {
        this.tipociid = tipociid;
    }

    /**
     * Gets the tecnologiaid.
     *
     * @return the tecnologiaid
     */
    public Integer getTecnologiaid() {
        return tecnologiaid;
    }

    /**
     * Sets the tecnologiaid.
     *
     * @param tecnologiaid the new tecnologiaid
     */
    public void setTecnologiaid(Integer tecnologiaid) {
        this.tecnologiaid = tecnologiaid;
    }

    /**
     * Gets the catopid.
     *
     * @return the catopid
     */
    public Integer getCatopid() {
        return catopid;
    }

    /**
     * Sets the catopid.
     *
     * @param catopid the new catopid
     */
    public void setCatopid(Integer catopid) {
        this.catopid = catopid;
    }

    /**
     * Gets the dirid.
     *
     * @return the dirid
     */
    public Integer getDirid() {
        return dirid;
    }

    /**
     * Sets the dirid.
     *
     * @param dirid the new dirid
     */
    public void setDirid(Integer dirid) {
        this.dirid = dirid;
    }

    /**
     * Gets the devtypeid.
     *
     * @return the devtypeid
     */
    public Integer getDevtypeid() {
        return devtypeid;
    }

    /**
     * Sets the devtypeid.
     *
     * @param devtypeid the new devtypeid
     */
    public void setDevtypeid(Integer devtypeid) {
        this.devtypeid = devtypeid;
    }

    /**
     * Gets the manexecs.
     *
     * @return the manexecs
     */
    public Float getManexecs() {
        return manexecs;
    }

    /**
     * Sets the manexecs.
     *
     * @param manexecs the new manexecs
     */
    public void setManexecs(Float manexecs) {
        this.manexecs = manexecs;
    }

    /**
     * Gets the autoexecs.
     *
     * @return the autoexecs
     */
    public Float getAutoexecs() {
        return autoexecs;
    }

    /**
     * Sets the autoexecs.
     *
     * @param autoexecs the new autoexecs
     */
    public void setAutoexecs(Float autoexecs) {
        this.autoexecs = autoexecs;
    }

    /**
     * Gets the mantime.
     *
     * @return the mantime
     */
    public Float getMantime() {
        return mantime;
    }

    /**
     * Sets the mantime.
     *
     * @param mantime the new mantime
     */
    public void setMantime(Float mantime) {
        this.mantime = mantime;
    }

    /**
     * Gets the registered date.
     *
     * @return the registered date
     */
    public Date getRegisteredDate() {
        return registeredDate;
    }

    /**
     * Sets the registered date.
     *
     * @param registeredDate the new registered date
     */
    public void setRegisteredDate(Date registeredDate) {
        this.registeredDate = registeredDate;
    }

    /**
     * Gets the aut creator area.
     *
     * @return the aut creator area
     */
    public String getAutCreatorArea() {
        return autCreatorArea;
    }

    /**
     * Sets the aut creator area.
     *
     * @param autCreatorArea the new aut creator area
     */
    public void setAutCreatorArea(String autCreatorArea) {
        this.autCreatorArea = autCreatorArea == null ? null : autCreatorArea.trim();
    }

    /**
     * Gets the aut creator user.
     *
     * @return the aut creator user
     */
    public String getAutCreatorUser() {
        return autCreatorUser;
    }

    /**
     * Sets the aut creator user.
     *
     * @param autCreatorUser the new aut creator user
     */
    public void setAutCreatorUser(String autCreatorUser) {
        this.autCreatorUser = autCreatorUser == null ? null : autCreatorUser.trim();
    }

    /**
     * Gets the last modified.
     *
     * @return the last modified
     */
    public Date getLastModified() {
        return lastModified;
    }

    /**
     * Sets the last modified.
     *
     * @param lastModified the new last modified
     */
    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    /**
     * Gets the aut enabled.
     *
     * @return the aut enabled
     */
    public Boolean getAutEnabled() {
        return autEnabled;
    }

    /**
     * Sets the aut enabled.
     *
     * @param autEnabled the new aut enabled
     */
    public void setAutEnabled(Boolean autEnabled) {
        this.autEnabled = autEnabled;
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
}