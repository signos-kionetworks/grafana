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
import com.kio.applications.validator.dao.TechnologicalDomainMapper;
import com.kio.applications.validator.exception.GenericException;
import com.kio.applications.validator.model.TechnologicalDomain;

/**
 * The Class TechnologicalDomainBO.
 */
@Service
public class TechnologicalDomainBO implements IfzSelectBO<TechnologicalDomain>, Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2597060429064236879L;
	/** The technologicalDomain mapper. */
	@Autowired
	private TechnologicalDomainMapper technologicalDomainMapper;

	/**
	 * Select by id.
	 *
	 * @param id the id
	 * @return the technological domain
	 * @throws GenericException the generic exception
	 */
	@Override
	public TechnologicalDomain selectById(int id) throws GenericException {
		final Optional<com.kio.applications.validator.model.TechnologicalDomain> result = this.technologicalDomainMapper
				.selectOne(c -> c.where(com.kio.applications.validator.dao.TechnologicalDomainDynamicSqlSupport.id,
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
	 * @return the technological domain
	 * @throws GenericException the generic exception
	 */
	@Override
	public TechnologicalDomain selectByName(String value) throws GenericException {
		final Optional<com.kio.applications.validator.model.TechnologicalDomain> result = this.technologicalDomainMapper
				.selectOne(c -> c
						.where(com.kio.applications.validator.dao.TechnologicalDomainDynamicSqlSupport.name,
								SqlBuilder.isInCaseInsensitive(value.trim().toUpperCase()))
						.or(com.kio.applications.validator.dao.TechnologicalDomainDynamicSqlSupport.descr,
								SqlBuilder.isInCaseInsensitive(value.trim().toUpperCase())).limit(1));
		if (result.isPresent()) {
			return result.get();
		} else {
			return null;
		}
	}

}
