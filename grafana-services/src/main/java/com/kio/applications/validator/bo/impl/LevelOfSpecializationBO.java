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
import com.kio.applications.validator.dao.LevelOfSpecializationMapper;
import com.kio.applications.validator.exception.GenericException;
import com.kio.applications.validator.model.LevelOfSpecialization;

/**
 * The Class LevelOfSpecializationBO.
 */
@Service
public class LevelOfSpecializationBO implements IfzSelectBO<LevelOfSpecialization>, Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1277606981685964646L;
	/** The levelOfSpecialization mapper. */
	@Autowired
	private LevelOfSpecializationMapper levelOfSpecializationMapper;

	/**
	 * Select by id.
	 *
	 * @param id the id
	 * @return the level of specialization
	 * @throws GenericException the generic exception
	 */
	@Override
	public LevelOfSpecialization selectById(int id) throws GenericException {
		final Optional<com.kio.applications.validator.model.LevelOfSpecialization> result = this.levelOfSpecializationMapper
				.selectOne(c -> c.where(com.kio.applications.validator.dao.LevelOfSpecializationDynamicSqlSupport.id,
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
	 * @param value the value
	 * @return the level of specialization
	 * @throws GenericException the generic exception
	 */
	@Override
	public LevelOfSpecialization selectByName(String value) throws GenericException {
		final Optional<com.kio.applications.validator.model.LevelOfSpecialization> result = this.levelOfSpecializationMapper
				.selectOne(c -> c
						.where(com.kio.applications.validator.dao.LevelOfSpecializationDynamicSqlSupport.name,
								SqlBuilder.isInCaseInsensitive(value.trim().toUpperCase()))
						.or(com.kio.applications.validator.dao.LevelOfSpecializationDynamicSqlSupport.descr,
								SqlBuilder.isInCaseInsensitive(value.trim().toUpperCase())).limit(1));
		if (result.isPresent()) {
			return result.get();
		} else {
			return null;
		}
	}

}
