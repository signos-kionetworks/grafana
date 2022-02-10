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
import com.kio.applications.validator.dao.TypeDevelopMapper;
import com.kio.applications.validator.exception.GenericException;
import com.kio.applications.validator.model.TypeDevelop;

/**
 * The Class TypeDevelopBO.
 */
@Service
public class TypeDevelopBO implements IfzSelectBO<TypeDevelop>, Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1176967350618025862L;
	/** The typeDevelop mapper. */
	@Autowired
	private TypeDevelopMapper typeDevelopMapper;

	/**
	 * Select by id.
	 *
	 * @param id
	 *            the id
	 * @return the type develop
	 * @throws GenericException
	 *             the generic exception
	 */
	@Override
	public TypeDevelop selectById(int id) throws GenericException {
		final Optional<com.kio.applications.validator.model.TypeDevelop> result = this.typeDevelopMapper
				.selectOne(c -> c.where(
						com.kio.applications.validator.dao.TypeDevelopDynamicSqlSupport.id,
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
	 * @return the type develop
	 * @throws GenericException
	 *             the generic exception
	 */
	@Override
	public TypeDevelop selectByName(String value) throws GenericException {
		final Optional<com.kio.applications.validator.model.TypeDevelop> result = this.typeDevelopMapper
				.selectOne(c -> c.where(
						com.kio.applications.validator.dao.TypeDevelopDynamicSqlSupport.name,
						SqlBuilder.isInCaseInsensitive(
								value.trim().toUpperCase()))
						.or(com.kio.applications.validator.dao.TypeDevelopDynamicSqlSupport.descr,
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
