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

import com.kio.applications.validator.bo.IfzSelectBO;
import com.kio.applications.validator.dao.TypeAutomationMapper;
import com.kio.applications.validator.exception.GenericException;
import com.kio.applications.validator.model.TypeAutomation;

/**
 * The Class TypeAutomationBO.
 */
@Service
public class TypeAutomationBO implements IfzSelectBO<TypeAutomation>, Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 4572342625977699608L;
	/** The typeAutomation mapper. */
	@Autowired
	private TypeAutomationMapper typeAutomationMapper;

	/**
	 * Select by name.
	 *
	 * @param value the value
	 * @return the type automation
	 * @throws GenericException the generic exception
	 */
	@Override
	public TypeAutomation selectByName(String value) throws GenericException {
		final Optional<com.kio.applications.validator.model.TypeAutomation> result = this.typeAutomationMapper
				.selectOne(c -> c
						.where(com.kio.applications.validator.dao.TypeAutomationDynamicSqlSupport.name,
								SqlBuilder.isInCaseInsensitive(value.trim().toUpperCase()))
						.or(com.kio.applications.validator.dao.TypeAutomationDynamicSqlSupport.descr,
								SqlBuilder.isInCaseInsensitive(value.trim().toUpperCase())));
		if (result.isPresent()) {
			return result.get();
		} else {
			return null;
		}
	}

	/**
	 * Select by id.
	 *
	 * @param id the id
	 * @return the type automation
	 * @throws GenericException the generic exception
	 */
	@Override
	public TypeAutomation selectById(int id) throws GenericException {
		final Optional<com.kio.applications.validator.model.TypeAutomation> result = this.typeAutomationMapper
				.selectOne(c -> c.where(com.kio.applications.validator.dao.TypeAutomationDynamicSqlSupport.id,
						SqlBuilder.isEqualTo(id)));
		if (result.isPresent()) {
			return result.get();
		} else {
			return null;
		}
	}

}
