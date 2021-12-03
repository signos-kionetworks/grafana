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
import com.kio.applications.validator.dao.FunctionMapper;
import com.kio.applications.validator.exception.GenericException;
import com.kio.applications.validator.model.Function;

/**
 * The Class FunctionBO.
 */
@Service
public class FunctionBO implements IfzSelectBO<Function>, Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1176967350618025862L;
	/** The function mapper. */
	@Autowired
	private FunctionMapper functionMapper;

	/**
	 * Select by id.
	 *
	 * @param id the id
	 * @return the function
	 * @throws GenericException the generic exception
	 */
	@Override
	public Function selectById(int id) throws GenericException {
		final Optional<com.kio.applications.validator.model.Function> result = this.functionMapper.selectOne(c -> c
				.where(com.kio.applications.validator.dao.FunctionDynamicSqlSupport.id, SqlBuilder.isEqualTo(id)));
		if (result.isPresent()) {
			return result.get();
		} else {
			return null;
		}
	}

	/**
	 * Select by name.
	 *
	 * @param value the value
	 * @return the function
	 * @throws GenericException the generic exception
	 */
	@Override
	public Function selectByName(String value) throws GenericException {
		final Optional<com.kio.applications.validator.model.Function> result = this.functionMapper.selectOne(c -> c
				.where(com.kio.applications.validator.dao.FunctionDynamicSqlSupport.name,
						SqlBuilder.isInCaseInsensitive(value.trim().toUpperCase()))
				.or(com.kio.applications.validator.dao.FunctionDynamicSqlSupport.descr,
						SqlBuilder.isInCaseInsensitive(value.trim().toUpperCase())).limit(1));
		if (result.isPresent()) {
			return result.get();
		} else {
			return null;
		}
	}

}
