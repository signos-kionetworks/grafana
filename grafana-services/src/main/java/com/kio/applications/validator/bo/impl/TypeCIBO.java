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
import com.kio.applications.validator.dao.TypeCIMapper;
import com.kio.applications.validator.exception.GenericException;
import com.kio.applications.validator.model.TypeCI;

/**
 * The Class TypeCIBO.
 */
@Service
public class TypeCIBO implements IfzSelectBO<TypeCI>, Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3004743731990669905L;
	/** The typeCI mapper. */
	@Autowired
	private TypeCIMapper typeCIMapper;

	/**
	 * Select by id.
	 *
	 * @param id
	 *            the id
	 * @return the type CI
	 * @throws GenericException
	 *             the generic exception
	 */
	@Override
	public TypeCI selectById(int id) throws GenericException {
		final Optional<com.kio.applications.validator.model.TypeCI> result = this.typeCIMapper
				.selectOne(c -> c.where(
						com.kio.applications.validator.dao.TypeCIDynamicSqlSupport.id,
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
	 * @return the type CI
	 * @throws GenericException
	 *             the generic exception
	 */
	@Override
	public TypeCI selectByName(String value) throws GenericException {
		final Optional<com.kio.applications.validator.model.TypeCI> result = this.typeCIMapper
				.selectOne(c -> c.where(
						com.kio.applications.validator.dao.TypeCIDynamicSqlSupport.name,
						SqlBuilder.isInCaseInsensitive(
								value.trim().toUpperCase()))
						.or(com.kio.applications.validator.dao.TypeCIDynamicSqlSupport.descr,
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
