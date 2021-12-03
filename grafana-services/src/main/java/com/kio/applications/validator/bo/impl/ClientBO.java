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
import com.kio.applications.validator.dao.ClientMapper;
import com.kio.applications.validator.exception.GenericException;
import com.kio.applications.validator.model.Client;

/**
 * The Class ClientBO.
 */
@Service
public class ClientBO implements IfzSelectBO<Client>, Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5188836336427525816L;

	/** The client mapper. */
	@Autowired
	private ClientMapper clientMapper;

	/**
	 * Select by id.
	 *
	 * @param id
	 *            the id
	 * @return the client
	 * @throws GenericException
	 *             the generic exception
	 */
	@Override
	public Client selectById(int id) throws GenericException {
		final Optional<com.kio.applications.validator.model.Client> client = this.clientMapper
				.selectOne(c -> c.where(
						com.kio.applications.validator.dao.ClientDynamicSqlSupport.id,
						SqlBuilder.isEqualTo(id)));
		if (client.isPresent()) {
			return client.get();
		} else {
			return null;
		}
	}

	/**
	 * Select by name.
	 *
	 * @param value
	 *            the value
	 * @return the client
	 * @throws GenericException
	 *             the generic exception
	 */
	@Override
	public Client selectByName(String value) throws GenericException {
		final Optional<com.kio.applications.validator.model.Client> client = this.clientMapper
				.selectOne(c -> c.where(
						com.kio.applications.validator.dao.ClientDynamicSqlSupport.name,
						SqlBuilder.isInCaseInsensitive(
								value.trim().toUpperCase()))
						.or(com.kio.applications.validator.dao.ClientDynamicSqlSupport.descr,
								SqlBuilder.isInCaseInsensitive(
										value.trim().toUpperCase()))
						.limit(1));
		if (client.isPresent()) {
			return client.get();
		} else {
			return null;
		}
	}

}
