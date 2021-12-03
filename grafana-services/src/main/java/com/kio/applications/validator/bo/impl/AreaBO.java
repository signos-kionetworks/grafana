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
import com.kio.applications.validator.dao.AreaMapper;
import com.kio.applications.validator.exception.GenericException;
import com.kio.applications.validator.model.Area;

/**
 * The Class AreaBO.
 */
@Service
public class AreaBO implements IfzSelectBO<Area>, Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1176967350618025862L;
	/** The area mapper. */
	@Autowired
	private AreaMapper areaMapper;

	/**
	 * Select by id.
	 *
	 * @param id
	 *            the id
	 * @return the area
	 * @throws GenericException
	 *             the generic exception
	 */
	@Override
	public Area selectById(int id) throws GenericException {
		final Optional<com.kio.applications.validator.model.Area> result = this.areaMapper
				.selectOne(c -> c.where(
						com.kio.applications.validator.dao.AreaDynamicSqlSupport.id,
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
	 * @return the area
	 * @throws GenericException
	 *             the generic exception
	 */
	@Override
	public Area selectByName(String value) throws GenericException {
		final Optional<com.kio.applications.validator.model.Area> result = this.areaMapper
				.selectOne(c -> c.where(
						com.kio.applications.validator.dao.AreaDynamicSqlSupport.name,
						SqlBuilder.isInCaseInsensitive(
								value.trim().toUpperCase()))
						.or(com.kio.applications.validator.dao.AreaDynamicSqlSupport.descr,
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
