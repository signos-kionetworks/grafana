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
import com.kio.applications.validator.dao.SupportGroupMapper;
import com.kio.applications.validator.exception.GenericException;
import com.kio.applications.validator.model.SupportGroup;

/**
 * The Class SupportGroupBO.
 */
@Service
public class SupportGroupBO implements IfzSelectBO<SupportGroup>, Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3797253579430638848L;
	/** The supportGroup mapper. */
	@Autowired
	private SupportGroupMapper supportGroupMapper;

	/**
	 * Select by id.
	 *
	 * @param id
	 *            the id
	 * @return the support group
	 * @throws GenericException
	 *             the generic exception
	 */
	@Override
	public SupportGroup selectById(int id) throws GenericException {
		final Optional<com.kio.applications.validator.model.SupportGroup> result = this.supportGroupMapper
				.selectOne(c -> c.where(
						com.kio.applications.validator.dao.SupportGroupDynamicSqlSupport.id,
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
	 * @return the support group
	 * @throws GenericException
	 *             the generic exception
	 */
	@Override
	public SupportGroup selectByName(String value) throws GenericException {
		final Optional<com.kio.applications.validator.model.SupportGroup> result = this.supportGroupMapper
				.selectOne(c -> c.where(
						com.kio.applications.validator.dao.SupportGroupDynamicSqlSupport.name,
						SqlBuilder.isInCaseInsensitive(
								value.trim().toUpperCase()))
						.or(com.kio.applications.validator.dao.SupportGroupDynamicSqlSupport.descr,
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
