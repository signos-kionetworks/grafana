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
import com.kio.applications.validator.dao.OrganizationAWXMapper;
import com.kio.applications.validator.exception.GenericException;
import com.kio.applications.validator.model.OrganizationAWX;

/**
 * The Class OrganizationAWXBO.
 */
@Service
public class OrganizationAWXBO
		implements
			IfzSelectBO<OrganizationAWX>,
			Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7445098684822267314L;

	/** The organization AWX mapper. */
	@Autowired
	private OrganizationAWXMapper organizationAWXMapper;

	/**
	 * Select by id.
	 *
	 * @param id
	 *            the id
	 * @return the organization AWX
	 * @throws GenericException
	 *             the generic exception
	 */
	@Override
	public OrganizationAWX selectById(int id) throws GenericException {
		final Optional<com.kio.applications.validator.model.OrganizationAWX> result = this.organizationAWXMapper
				.selectOne(c -> c.where(
						com.kio.applications.validator.dao.OrganizationAWXDynamicSqlSupport.id,
						SqlBuilder.isEqualTo(id)));
        return result.orElse(null);
	}

	/**
	 * Select by name.
	 *
	 * @param value
	 *            the value
	 * @return the organization AWX
	 * @throws GenericException
	 *             the generic exception
	 */
	@Override
	public OrganizationAWX selectByName(String value) throws GenericException {
		final Optional<com.kio.applications.validator.model.OrganizationAWX> result = this.organizationAWXMapper
				.selectOne(c -> c.where(
						com.kio.applications.validator.dao.OrganizationAWXDynamicSqlSupport.name,
						SqlBuilder.isInCaseInsensitive(
								value.trim().toUpperCase()))
						.limit(1));
        return result.orElse(null);
	}

}
