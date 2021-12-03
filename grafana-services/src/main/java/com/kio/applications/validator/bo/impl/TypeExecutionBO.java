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
import com.kio.applications.validator.dao.TypeExecutionMapper;
import com.kio.applications.validator.exception.GenericException;
import com.kio.applications.validator.model.TypeExecution;

/**
 * The Class TypeExecutionBO.
 */
@Service
public class TypeExecutionBO
		implements
			IfzSelectBO<TypeExecution>,
			Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8005828699964566098L;
	/** The typeExecution mapper. */
	@Autowired
	private TypeExecutionMapper typeExecutionMapper;

	/**
	 * Select by id.
	 *
	 * @param id
	 *            the id
	 * @return the type execution
	 * @throws GenericException
	 *             the generic exception
	 */
	@Override
	public TypeExecution selectById(int id) throws GenericException {
		final Optional<com.kio.applications.validator.model.TypeExecution> result = this.typeExecutionMapper
				.selectOne(c -> c.where(
						com.kio.applications.validator.dao.TypeExecutionDynamicSqlSupport.id,
						SqlBuilder.isEqualTo(id)));
		if (result.isPresent()) {
			return result.get();
		} else {
			return null;
		}
	}

	/**
	 * Select by name.
	 *
	 * @param value
	 *            the value
	 * @return the type execution
	 * @throws GenericException
	 *             the generic exception
	 */
	@Override
	public TypeExecution selectByName(String value) throws GenericException {
		final Optional<com.kio.applications.validator.model.TypeExecution> result = this.typeExecutionMapper
				.selectOne(c -> c.where(
						com.kio.applications.validator.dao.TypeExecutionDynamicSqlSupport.name,
						SqlBuilder.isInCaseInsensitive(
								value.trim().toUpperCase()))
						.or(com.kio.applications.validator.dao.TypeExecutionDynamicSqlSupport.descr,
								SqlBuilder.isInCaseInsensitive(
										value.trim().toUpperCase()))
						.limit(1));
		if (result.isPresent()) {
			return result.get();
		} else {
			return null;
		}
	}

}
