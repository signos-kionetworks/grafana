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
import com.kio.applications.validator.dao.PlatformMapper;
import com.kio.applications.validator.exception.GenericException;
import com.kio.applications.validator.model.Platform;

/**
 * The Class PlatformBO.
 */
@Service
public class PlatformBO implements IfzSelectBO<Platform>, Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8087045393972259502L;
	/** The platform mapper. */
	@Autowired
	private PlatformMapper platformMapper;

	/**
	 * Select by id.
	 *
	 * @param id the id
	 * @return the platform
	 * @throws GenericException the generic exception
	 */
	@Override
	public Platform selectById(int id) throws GenericException {
		final Optional<com.kio.applications.validator.model.Platform> result = this.platformMapper.selectOne(c -> c
				.where(com.kio.applications.validator.dao.PlatformDynamicSqlSupport.id, SqlBuilder.isEqualTo(id)));
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
	 * @return the platform
	 * @throws GenericException the generic exception
	 */
	@Override
	public Platform selectByName(String value) throws GenericException {
		final Optional<com.kio.applications.validator.model.Platform> result = this.platformMapper
				.selectOne(c -> c.where(com.kio.applications.validator.dao.PlatformDynamicSqlSupport.name,
						SqlBuilder.isInCaseInsensitive(value.trim().toUpperCase())).or(com.kio.applications.validator.dao.ClientDynamicSqlSupport.descr,
								SqlBuilder.isInCaseInsensitive(value.trim().toUpperCase())).limit(1));
		if (result.isPresent()) {
			return result.get();
		} else {
			return null;
		}
	}

}
