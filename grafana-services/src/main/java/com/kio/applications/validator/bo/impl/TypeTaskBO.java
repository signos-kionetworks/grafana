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
import com.kio.applications.validator.dao.TypeTaskMapper;
import com.kio.applications.validator.exception.GenericException;
import com.kio.applications.validator.model.TypeTask;

/**
 * The Class TaskTypeBO.
 */
@Service
public class TypeTaskBO implements IfzSelectBO<TypeTask>, Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3463898127239629063L;
	/** The taskType mapper. */
	@Autowired
	private TypeTaskMapper typeTaskMapper;

	/**
	 * Select by id.
	 *
	 * @param id
	 *            the id
	 * @return the type task
	 * @throws GenericException
	 *             the generic exception
	 */
	@Override
	public TypeTask selectById(int id) throws GenericException {
		final Optional<com.kio.applications.validator.model.TypeTask> result = this.typeTaskMapper
				.selectOne(c -> c.where(
						com.kio.applications.validator.dao.TypeTaskDynamicSqlSupport.id,
						SqlBuilder.isEqualTo(id)));
        return result.orElse(null);
	}

	/**
	 * Select by name.
	 *
	 * @param value
	 *            the value
	 * @return the type task
	 * @throws GenericException
	 *             the generic exception
	 */
	@Override
	public TypeTask selectByName(String value) throws GenericException {
		final Optional<com.kio.applications.validator.model.TypeTask> result = this.typeTaskMapper
				.selectOne(c -> c.where(
						com.kio.applications.validator.dao.TypeTaskDynamicSqlSupport.name,
						SqlBuilder.isInCaseInsensitive(
								value.trim().toUpperCase()))
						.or(com.kio.applications.validator.dao.TypeTaskDynamicSqlSupport.descr,
								SqlBuilder.isInCaseInsensitive(
										value.trim().toUpperCase()))
						.limit(1));
        return result.orElse(null);
	}

}
