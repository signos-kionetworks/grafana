/*
 * ****************************************************
 * * Grafana *
 * * KIO Networks *
 * * @Author Julio Galindo *
 * ****************************************************
 */

package com.kio.applications.validator.bo.impl;

import java.io.Serializable;
import java.util.Optional;

import org.mybatis.dynamic.sql.SqlBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kio.applications.validator.bo.IfzSaveBO;
import com.kio.applications.validator.bo.IfzSearchByKeyBO;
import com.kio.applications.validator.bo.IfzSearchByTextBO;
import com.kio.applications.validator.dao.AutomationMapper;
import com.kio.applications.validator.exception.GenericException;
import com.kio.applications.validator.model.Automation;

/**
 * The Class AutomationBO.
 */
@Service
public class AutomationBO
		implements IfzSaveBO<Automation>, IfzSearchByKeyBO<Automation>, IfzSearchByTextBO<Automation>, Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8798643153312463893L;

	/** The automation mapper. */
	@Autowired
	private AutomationMapper automationMapper;

	/**
	 * Save.
	 *
	 * @param object the object
	 * @return the automation
	 * @throws GenericException the generic exception
	 */
	@Override
	public Automation save(Automation object) throws GenericException {
		if (null != object.getId()) {
			this.automationMapper.updateByPrimaryKey(object);
			return object;
		} else {
			this.automationMapper.insertSelective(object);
		}
		return object;
	}

	/**
	 * Search by key.
	 *
	 * @param value the value
	 * @return the automation
	 * @throws GenericException the generic exception
	 */
	@Override
	public Automation searchByKey(Automation value) throws GenericException {
		final Optional<Automation> automation = this.automationMapper.selectOne(c -> c
				.where(com.kio.applications.validator.dao.AutomationDynamicSqlSupport.areaid,
						SqlBuilder.isEqualTo(value.getAreaid()))
				.and(com.kio.applications.validator.dao.AutomationDynamicSqlSupport.dirid,
						SqlBuilder.isEqualTo(value.getDirid()))
				.and(com.kio.applications.validator.dao.AutomationDynamicSqlSupport.platformid,
						SqlBuilder.isEqualTo(value.getPlatformid()))
				.and(com.kio.applications.validator.dao.AutomationDynamicSqlSupport.tipoautid,
						SqlBuilder.isEqualTo(value.getTipoautid()))
				.and(com.kio.applications.validator.dao.AutomationDynamicSqlSupport.tipoexecid,
						SqlBuilder.isEqualTo(value.getTipoexecid()))
				.and(com.kio.applications.validator.dao.AutomationDynamicSqlSupport.devtypeid,
						SqlBuilder.isEqualTo(value.getDevtypeid()))
				.and(com.kio.applications.validator.dao.AutomationDynamicSqlSupport.catopid,
						SqlBuilder.isEqualTo(value.getCatopid()))
				.and(com.kio.applications.validator.dao.AutomationDynamicSqlSupport.clienteid,
						SqlBuilder.isEqualTo(value.getClienteid()))
				.orderBy(com.kio.applications.validator.dao.AutomationDynamicSqlSupport.id).limit(1));

        return automation.orElse(value);
	}

	@Override
	public Automation searchByText(String text) throws GenericException {
		final Optional<Automation> automation = this.automationMapper.selectOne(c -> c
				.where(com.kio.applications.validator.dao.AutomationDynamicSqlSupport.botname,
						SqlBuilder.isEqualTo(text))
				.orderBy(com.kio.applications.validator.dao.AutomationDynamicSqlSupport.id).limit(1));
        return automation.orElse(null);
	}

}
