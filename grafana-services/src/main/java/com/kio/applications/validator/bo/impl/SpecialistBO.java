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
import com.kio.applications.validator.dao.SpecialistMapper;
import com.kio.applications.validator.exception.GenericException;
import com.kio.applications.validator.model.Specialist;

/**
 * The Class SpecialistBO.
 */
@Service
public class SpecialistBO implements IfzSelectBO<Specialist>, Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -5283118460060165694L;
	/** The specialist mapper. */
	@Autowired
	private SpecialistMapper specialistMapper;

	/**
	 * Select by id.
	 *
	 * @param id
	 *            the id
	 * @return the specialist
	 * @throws GenericException
	 *             the generic exception
	 */
	@Override
	public Specialist selectById(int id) throws GenericException {
		final Optional<com.kio.applications.validator.model.Specialist> result = this.specialistMapper
				.selectOne(c -> c.where(
						com.kio.applications.validator.dao.SpecialistDynamicSqlSupport.id,
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
	 * @return the specialist
	 * @throws GenericException
	 *             the generic exception
	 */
	@Override
	public Specialist selectByName(String value) throws GenericException {
		final Optional<com.kio.applications.validator.model.Specialist> result = this.specialistMapper
				.selectOne(c -> c.where(
						com.kio.applications.validator.dao.SpecialistDynamicSqlSupport.name,
						SqlBuilder.isInCaseInsensitive(
								value.trim().toUpperCase()))
						.or(com.kio.applications.validator.dao.SpecialistDynamicSqlSupport.descr,
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
