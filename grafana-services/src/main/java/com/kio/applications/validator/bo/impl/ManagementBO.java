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
import com.kio.applications.validator.dao.ManagementMapper;
import com.kio.applications.validator.exception.GenericException;
import com.kio.applications.validator.model.Management;

/**
 * The Class ManagementBO.
 */
@Service
public class ManagementBO implements IfzSelectBO<Management>, Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7547474532498655926L;
	/** The management mapper. */
	@Autowired
	private ManagementMapper managementMapper;

	/**
	 * Select by id.
	 *
	 * @param id the id
	 * @return the management
	 * @throws GenericException the generic exception
	 */
	@Override
	public Management selectById(int id) throws GenericException {
		final Optional<com.kio.applications.validator.model.Management> result = this.managementMapper.selectOne(c -> c
				.where(com.kio.applications.validator.dao.ManagementDynamicSqlSupport.id, SqlBuilder.isEqualTo(id)));
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
	 * @return the management
	 * @throws GenericException the generic exception
	 */
	@Override
	public Management selectByName(String value) throws GenericException {
		final Optional<com.kio.applications.validator.model.Management> result = this.managementMapper.selectOne(c -> c
				.where(com.kio.applications.validator.dao.ManagementDynamicSqlSupport.name,
						SqlBuilder.isInCaseInsensitive(value.trim().toUpperCase()))
				.or(com.kio.applications.validator.dao.ManagementDynamicSqlSupport.descr,
						SqlBuilder.isInCaseInsensitive(value.trim().toUpperCase())).limit(1));
		if (result.isPresent()) {
			return result.get();
		} else {
			return null;
		}
	}

}
