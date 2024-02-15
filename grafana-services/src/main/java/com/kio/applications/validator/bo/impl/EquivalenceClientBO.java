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
import com.kio.applications.validator.dao.EquivalenceClientMapper;
import com.kio.applications.validator.exception.GenericException;
import com.kio.applications.validator.model.EquivalenceClient;

/**
 * The Class EquivalenceClientBO.
 */
@Service
public class EquivalenceClientBO
		implements
			IfzSelectBO<EquivalenceClient>,
			Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3232918375070840213L;
	/** The equivalence client mapper. */
	@Autowired
	private EquivalenceClientMapper equivalenceClientMapper;

	@Override
	public EquivalenceClient selectById(int id) throws GenericException {

		return null;

	}

	/**
	 * Select by name.
	 *
	 * @param value
	 *            the value
	 * @return the equivalence client
	 * @throws GenericException
	 *             the generic exception
	 */
	@Override
	public EquivalenceClient selectByName(String value)
			throws GenericException {
		final Optional<EquivalenceClient> equivalenceClient = this.equivalenceClientMapper
				.selectOne(c -> c.where(
						com.kio.applications.validator.dao.EquivalenceClientDynamicSqlSupport.valor,
						SqlBuilder.isInCaseInsensitive(
								value.trim().toUpperCase()))
						.limit(1));
        return equivalenceClient.orElse(null);
	}

}
