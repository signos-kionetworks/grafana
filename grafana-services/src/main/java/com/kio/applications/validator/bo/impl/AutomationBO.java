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

import com.kio.applications.validator.bo.IfzAutomationBO;
import com.kio.applications.validator.bo.IfzSaveBO;
import com.kio.applications.validator.dao.AutomationMapper;
import com.kio.applications.validator.exception.GenericException;
import com.kio.applications.validator.model.Automation;

/**
 * The Class AutomationBO.
 */
@Service
public class AutomationBO implements IfzSaveBO<Automation>, IfzAutomationBO, Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8798643153312463893L;
	
	/** The automation mapper. */
	@Autowired
	private AutomationMapper automationMapper;

	/**
	 * Select automation.
	 *
	 * @param value the value
	 * @return the automation
	 * @throws GenericException the generic exception
	 */
	@Override
	public Automation selectAutomation(Automation value) throws GenericException {
		//TODO: Agregar las demas validaciones para buscar el automation id
		final Optional<Automation> automation = this.automationMapper.selectOne(c -> c
				.where(com.kio.applications.validator.dao.AutomationDynamicSqlSupport.areaid,
						SqlBuilder.isEqualTo(value.getAreaid()))
				.and(com.kio.applications.validator.dao.AutomationDynamicSqlSupport.dirid,
						SqlBuilder.isEqualTo(value.getDirid()))
				.and(com.kio.applications.validator.dao.AutomationDynamicSqlSupport.clienteid,
						SqlBuilder.isEqualTo(value.getClienteid()))
				
				);

		if (automation.isPresent()) {
			return automation.get();
		} else {
			return value;
		}
	}

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

}
