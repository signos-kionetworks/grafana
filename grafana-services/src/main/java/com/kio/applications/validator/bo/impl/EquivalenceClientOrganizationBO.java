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

import com.kio.applications.validator.bo.IfzEquivalenciaClientOrganizationBO;
import com.kio.applications.validator.dao.EquivalenceClientOrganizationMapper;
import com.kio.applications.validator.exception.GenericException;
import com.kio.applications.validator.model.EquivalenceClientOrganization;

/**
 * The Class EquivalenceClientOrganizationBO.
 */
@Service
public class EquivalenceClientOrganizationBO
		implements
			IfzEquivalenciaClientOrganizationBO,
			Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2799435436939204953L;

	/** The equivalence client organization mapper. */
	@Autowired
	private EquivalenceClientOrganizationMapper equivalenceClientOrganizationMapper;

	/**
	 * Search client by id organization.
	 *
	 * @param id
	 *            the id
	 * @return the equivalence client organization
	 * @throws GenericException
	 *             the generic exception
	 */
	@Override
	public EquivalenceClientOrganization searchClientByIdOrganization(
			Integer id) throws GenericException {
		final Optional<com.kio.applications.validator.model.EquivalenceClientOrganization> result = this.equivalenceClientOrganizationMapper
				.selectOne(c -> c.where(
						com.kio.applications.validator.dao.EquivalenceClientOrganizationDynamicSqlSupport.idOrganizacionAwx,
						SqlBuilder.isEqualTo(id)));
        return result.orElse(null);
	}

}
