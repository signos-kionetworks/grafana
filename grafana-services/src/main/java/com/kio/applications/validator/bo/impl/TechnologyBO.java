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
import com.kio.applications.validator.dao.TechnologyMapper;
import com.kio.applications.validator.exception.GenericException;
import com.kio.applications.validator.model.Technology;

/**
 * The Class TechnologyBO.
 */
@Service
public class TechnologyBO implements IfzSelectBO<Technology>, Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8068689493251011438L;
	/** The technology mapper. */
	@Autowired
	private TechnologyMapper technologyMapper;

	/**
	 * Select by id.
	 *
	 * @param id
	 *            the id
	 * @return the technology
	 * @throws GenericException
	 *             the generic exception
	 */
	@Override
	public Technology selectById(int id) throws GenericException {
		final Optional<com.kio.applications.validator.model.Technology> result = this.technologyMapper
				.selectOne(c -> c.where(
						com.kio.applications.validator.dao.TechnologyDynamicSqlSupport.id,
						SqlBuilder.isEqualTo(id)));
        return result.orElse(null);
	}

	/**
	 * Select by name.
	 *
	 * @param value
	 *            the value
	 * @return the technology
	 * @throws GenericException
	 *             the generic exception
	 */
	@Override
	public Technology selectByName(String value) throws GenericException {
		final Optional<com.kio.applications.validator.model.Technology> result = this.technologyMapper
				.selectOne(c -> c.where(
						com.kio.applications.validator.dao.TechnologyDynamicSqlSupport.name,
						SqlBuilder.isInCaseInsensitive(
								value.trim().toUpperCase()))
						.or(com.kio.applications.validator.dao.TechnologyDynamicSqlSupport.descr,
								SqlBuilder.isInCaseInsensitive(
										value.trim().toUpperCase()))
						.limit(1));
        return result.orElse(null);
	}

}
